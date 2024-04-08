-- ��Ű��(����)
-- �����
create or replace package pkg_exam1 is
    procedure sp_empByDept2 (v_deptid in employees.department_id%type, v_sal in employees.salary%type);
    function f_tax2 (v_deptid employees.department_id%type, v_empid employees.employee_id%type) return number;
end;
/
-- ��ü
create or replace package body pkg_exam1 is
    procedure sp_empByDept2 (v_deptid in employees.department_id%type,v_sal in employees.salary%type) is
    begin
        for v_empRecord in (select * from employees where department_id = v_deptid and salary >= v_sal) loop
            dbms_output.put_line('�����̸�: '||v_empRecord.first_name);
            dbms_output.put_line('�μ�id: '||v_empRecord.department_id);
            dbms_output.put_line('�޿�: '||v_empRecord.salary);
            dbms_output.put_line('--------------------------------------');
        end loop;
    end;
    
    function f_tax2 (v_deptid employees.department_id%type, v_empid employees.employee_id%type) return number is
        v_tax number(10,2);
    begin
        select salary * 0.1 into v_tax from employees where v_empid = employee_id and department_id = v_deptid;
        return v_tax;
    end;
end;
/

execute pkg_exam1.sp_empByDept2(50, 5000);

select employee_id, first_name, salary, nvl(pkg_exam1.f_tax2(50, employee_id), 0) tax from employees;

-- example
create or replace package pkg_exam2 is
    procedure sp_empinfo2 (
        v_empid in employees.employee_id% type,
        v_fname out employees.first_name% type,
        v_job out employees.job_id% type,
        v_salary out employees.salary% type
    );
    function f_bonus2 (v_empid employees.employee_id%type) return number;
end;
/
create or replace package body pkg_exam2 is
    procedure sp_empinfo2 (
        v_empid in employees.employee_id% type,
        v_fname out employees.first_name% type,
        v_job out employees.job_id% type,
        v_salary out employees.salary% type
    ) is
        a number;
    begin
        select first_name, job_id, salary
        into v_fname, v_job, v_salary
        from employees
        where employee_id = v_empid;
    end;

    function f_bonus2 (v_empid employees.employee_id%type)
    return number
    is
        v_bonus number(10,2);
    begin
        select salary * 1.5 into v_bonus from employees where v_empid = employee_id;
        return v_bonus;
    end;
end;
/

variable a varchar2(30);
variable b varchar2(30);
variable c number;
execute pkg_exam2.sp_empinfo2(100, :a, :b, :c);
print a;
print b;
print c;

select employee_id, first_name, length(first_name), salary, f_bonus(employee_id) from employees;


-- Ʈ���� trigger
create table emp_trigger(
    id number primary key,
    name varchar2(100)
);

insert into emp_trigger values(1, '��');
commit;

select * from emp_trigger;

-- for each row : �Ǻ�����
create or replace trigger trigger_emp1
after insert on emp_trigger for each row
begin
    dbms_output.put_line('====emp_trigger ���̺� insert ����');
    insert into emp_sal01 values(seq_emp_sal01.nextval, 100, :new.id);
end;
/

insert into emp_trigger values(2, '��');
insert into emp_trigger values(3, '��');

create table emp_sal01(
    salno number(4) primary key,
    salary number(7,2),
    empid number(4) references emp_trigger(id)
);

create sequence seq_emp_sal01;

insert into emp_trigger values(4, '��');
insert into emp_trigger values(5, '��');

select * from emp_trigger;
select * from emp_sal01;

-- �����ϴ� ���̺��� ������ ���� �� ����.
-- �ڽ� ���̺��� �����ϸ� �θ� ���̺��� ���� �� ����.
delete from emp_trigger where id = 5;

create or replace trigger trigger_delete
before delete on emp_trigger for each row
begin
    dbms_output.put_line('====emp_trigger ���̺� delete ����');
    delete from emp_sal01 where empid = :old.id;
end;
/

CREATE TABLE ��ǰ(
    ��ǰ�ڵ� CHAR(6) PRIMARY KEY,
    ��ǰ�� VARCHAR2(12) NOT NULL,
    ������ VARCHAR(12),
    �Һ��ڰ��� NUMBER(8),
    ������ NUMBER DEFAULT 0
);

CREATE TABLE �԰�(
    �԰��ȣ NUMBER(6) PRIMARY KEY,
    ��ǰ�ڵ� CHAR(6) REFERENCES ��ǰ(��ǰ�ڵ�),
    �԰����� DATE DEFAULT SYSDATE,
    �԰���� NUMBER(6),
    �԰�ܰ� NUMBER(8),
    �԰�ݾ� NUMBER(8)
);

INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00001','��Ź��', 'LG', 500); 
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00002','��ǻ��', 'LG', 700);
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00003','�����', '�Ｚ', 600);
commit;

select * from ��ǰ;
select * from �԰�;

-- ��ǰ�� �԰�Ǹ� ��ǰ�� ��� ������ �����Ѵ�. (trigger)
create or replace trigger trigger_������
after insert on �԰� for each row
begin
    update ��ǰ
    set ������ = ������ + :new.�԰����
    where ��ǰ�ڵ� = :new.��ǰ�ڵ�;
end;
/

INSERT INTO �԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�, �԰�ݾ�) 
VALUES(1, 'A00001', 5, 320, 1600);
INSERT INTO �԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�, �԰�ݾ�) 
VALUES(2, 'A00001', 20, 320, 1600);
INSERT INTO �԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�, �԰�ݾ�) 
VALUES(3, 'A00002', 120, 420, 4600);
select * from ��ǰ;

-- ��� trigger ������
CREATE TABLE ���(
    ����ȣ NUMBER(6) PRIMARY KEY,
    ��ǰ�ڵ� CHAR(6) REFERENCES ��ǰ(��ǰ�ڵ�),
    ������� DATE DEFAULT SYSDATE,
    ������ NUMBER(6),
    ���ܰ� NUMBER(8),
    ���ݾ� NUMBER(8)
);

create or replace trigger trigger_������2
after insert on ��� for each row
begin
    update ��ǰ
    set ������ = ������ - :new.������
    where ��ǰ�ڵ� = :new.��ǰ�ڵ�;
end;
/

INSERT INTO ���(����ȣ, ��ǰ�ڵ�, ������, ���ܰ�, ���ݾ�) 
VALUES(3, 'A00002', 20, 420, 4600);
select * from ��ǰ;

-- employees table�� 100�� ������ �μ��� ����
update employees set department_id = 60
where employee_id = 100;

select * from employees where employee_id = 100;
select * from job_history;