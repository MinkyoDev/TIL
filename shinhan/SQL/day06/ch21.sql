create or replace procedure sp_empall(v_deptid employees.department_id%type)
is
begin
    for empRecord in (select * from employees where department_id = v_deptid) loop
        dbms_output.put_line(empRecord.first_name);
        dbms_output.put_line(empRecord.email);
        dbms_output.put_line(empRecord.salary);
        dbms_output.put_line(empRecord.department_id);
        dbms_output.put_line('-------------------');
    end loop;
end;
/

create or replace procedure sp_empsal(v_salary in employees.salary%type)
is
begin
    for empRecord in (select * from employees where salary >= v_salary) loop
        dbms_output.put_line(empRecord.first_name);
        dbms_output.put_line(empRecord.email);
        dbms_output.put_line(empRecord.salary);
        dbms_output.put_line(empRecord.department_id);
        dbms_output.put_line('-------------------');
    end loop;
end;
/

create or replace procedure sp_empinfo (
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
/

execute sp_empall(10);
execute sp_empsal(15000);

variable a varchar2(30);
variable b varchar2(30);
variable c number;
execute sp_empinfo(100, :a, :b, :c);
print a;
print b;
print c;

-- fuction �Լ�
create or replace function f_bonus(v_empid employees.employee_id%type)
return number
is
    v_bonus number(10,2);
begin
    select salary * 1.5 into v_bonus from employees where v_empid = employee_id;
    return v_bonus;
end;
/

select f_bonus(100) from dual;

select employee_id, first_name, length(first_name), salary, f_bonus(employee_id) from employees;

-- Ŀ�� : select ����� �������� �� �ݵ�� Ŀ���� ����Ѵ�.
-- 1. Ŀ�� ����
-- 2. Ŀ�� open
-- 3. Ŀ�� fetch
-- 4. Ŀ�� �ݱ�
create or replace procedure sp_emp2
is
    v_empRecord employees%rowtype;
    cursor cur_emp is select * from employees;  -- Ŀ�� ����
begin 
    -- Ŀ�� ����
    open cur_emp;
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;
        dbms_output.put_line('�����̸�: '||v_empRecord.first_name);
    end loop;
    -- Ŀ�� �ݱ�
    close cur_emp;
end;
/
execute sp_emp2;

-- for���� ����ϸ� �ڵ����� Ŀ���� ���� ������ �ݾ���
-- �Ͻ��� Ŀ���� �̿���
create or replace procedure sp_emp3
is
begin 
    for v_empRecord in (select * from employees) loop
        dbms_output.put_line('�����̸�: '||v_empRecord.first_name);
    end loop;
end;
/
execute sp_emp3;


-- ���� ���ν��� : sp_empByDept - Ư���μ��� Ư���ݾ� �̻��� �޿��� �޴� ������ȸ�ϰ� ����Ѵ�.
create or replace procedure sp_empByDept(
    v_deptid in employees.department_id%type,
    v_sal in employees.salary%type
) is
begin
    for v_empRecord in (select * from employees where department_id = v_deptid and salary >= v_sal) loop
        dbms_output.put_line('�����̸�: '||v_empRecord.first_name);
        dbms_output.put_line('�μ�id: '||v_empRecord.department_id);
        dbms_output.put_line('�޿�: '||v_empRecord.salary);
        dbms_output.put_line('--------------------------------------');
    end loop;
end;
/
execute sp_empByDept(50, 5000);

-- ���� �Լ� : f_tax - 60�� �μ��� �������� tax�� ����ϴ� �Լ�(�޿��� 10%)
create or replace function f_tax (v_deptid employees.department_id%type, v_empid employees.employee_id%type)
return number
is
    v_tax number(10,2);
begin
    select salary * 0.1 into v_tax from employees where v_empid = employee_id and department_id = v_deptid;
    return v_tax;
end;
/

select employee_id, first_name, salary, nvl(f_tax(50, employee_id), 0) tax from employees;