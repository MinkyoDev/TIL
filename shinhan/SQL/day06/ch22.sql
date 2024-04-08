-- 패키지(묶음)
-- 선언부
create or replace package pkg_exam1 is
    procedure sp_empByDept2 (v_deptid in employees.department_id%type, v_sal in employees.salary%type);
    function f_tax2 (v_deptid employees.department_id%type, v_empid employees.employee_id%type) return number;
end;
/
-- 몸체
create or replace package body pkg_exam1 is
    procedure sp_empByDept2 (v_deptid in employees.department_id%type,v_sal in employees.salary%type) is
    begin
        for v_empRecord in (select * from employees where department_id = v_deptid and salary >= v_sal) loop
            dbms_output.put_line('직원이름: '||v_empRecord.first_name);
            dbms_output.put_line('부서id: '||v_empRecord.department_id);
            dbms_output.put_line('급여: '||v_empRecord.salary);
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


-- 트리거 trigger
create table emp_trigger(
    id number primary key,
    name varchar2(100)
);

insert into emp_trigger values(1, '김');
commit;

select * from emp_trigger;

-- for each row : 건별마다
create or replace trigger trigger_emp1
after insert on emp_trigger for each row
begin
    dbms_output.put_line('====emp_trigger 테이블 insert 성공');
    insert into emp_sal01 values(seq_emp_sal01.nextval, 100, :new.id);
end;
/

insert into emp_trigger values(2, '김');
insert into emp_trigger values(3, '김');

create table emp_sal01(
    salno number(4) primary key,
    salary number(7,2),
    empid number(4) references emp_trigger(id)
);

create sequence seq_emp_sal01;

insert into emp_trigger values(4, '김');
insert into emp_trigger values(5, '김');

select * from emp_trigger;
select * from emp_sal01;

-- 참조하는 테이블이 있으면 지울 수 없다.
-- 자식 테이블이 존재하면 부모 테이블은 지울 수 없다.
delete from emp_trigger where id = 5;

create or replace trigger trigger_delete
before delete on emp_trigger for each row
begin
    dbms_output.put_line('====emp_trigger 테이블 delete 성공');
    delete from emp_sal01 where empid = :old.id;
end;
/

CREATE TABLE 상품(
    상품코드 CHAR(6) PRIMARY KEY,
    상품명 VARCHAR2(12) NOT NULL,
    제조사 VARCHAR(12),
    소비자가격 NUMBER(8),
    재고수량 NUMBER DEFAULT 0
);

CREATE TABLE 입고(
    입고번호 NUMBER(6) PRIMARY KEY,
    상품코드 CHAR(6) REFERENCES 상품(상품코드),
    입고일자 DATE DEFAULT SYSDATE,
    입고수량 NUMBER(6),
    입고단가 NUMBER(8),
    입고금액 NUMBER(8)
);

INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00001','세탁기', 'LG', 500); 
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00002','컴퓨터', 'LG', 700);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00003','냉장고', '삼성', 600);
commit;

select * from 상품;
select * from 입고;

-- 상품이 입고되면 상품의 재고 수량을 수정한다. (trigger)
create or replace trigger trigger_재고수정
after insert on 입고 for each row
begin
    update 상품
    set 재고수량 = 재고수량 + :new.입고수량
    where 상품코드 = :new.상품코드;
end;
/

INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(1, 'A00001', 5, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(2, 'A00001', 20, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(3, 'A00002', 120, 420, 4600);
select * from 상품;

-- 출고 trigger 만들어보기
CREATE TABLE 출고(
    출고번호 NUMBER(6) PRIMARY KEY,
    상품코드 CHAR(6) REFERENCES 상품(상품코드),
    출고일자 DATE DEFAULT SYSDATE,
    출고수량 NUMBER(6),
    출고단가 NUMBER(8),
    출고금액 NUMBER(8)
);

create or replace trigger trigger_재고수정2
after insert on 출고 for each row
begin
    update 상품
    set 재고수량 = 재고수량 - :new.출고수량
    where 상품코드 = :new.상품코드;
end;
/

INSERT INTO 출고(출고번호, 상품코드, 출고수량, 출고단가, 출고금액) 
VALUES(3, 'A00002', 20, 420, 4600);
select * from 상품;

-- employees table의 100번 직원의 부서를 수정
update employees set department_id = 60
where employee_id = 100;

select * from employees where employee_id = 100;
select * from job_history;