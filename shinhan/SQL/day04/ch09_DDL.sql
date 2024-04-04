
-- rowid : ���� �����Ͱ� ����� ��ġ(DBMS�� ����Ѵ�), index ����
select rowid, rownum, first_name, salary
from employees
order by salary desc;

-- 1. �޿��� ���� ���� �޴� ���� 5���� ���� ������ ��ȸ�Ͻÿ�.
select rownum, aa.*
from (
        select rownum, first_name, salary
        from employees
        order by salary desc) aa
where rownum <= 5;

-- ���� �޿� 6������ 10������
select *
from (
    select rr, aa.*
    from (
            select rownum rr, first_name, salary
            from employees
            order by salary desc) aa)
where rr between 6 and 10;

-- select �� rownum �ο� ���Ŀ� order by
select rownum, bb.*
from (
        select rownum rr, aa.*
        from (
                select rownum, first_name, salary
                from employees
                order by salary desc) aa
        ) bb
where rr >= 6 and rr <= 10;



-- DDL (Data Definition Language) : �ڵ� commit
-- create table, drop table, alter table, rename, truncate
create table emp01 (
    empno number(4),
    ename varchar2(20),
    sal number(7,2)
);

select * from tab;

create table emp03
as
select employee_id, first_name, salary, hire_date
from employees
where department_id = 60;

desc emp03;
select * from emp03;

-- table ������ �����ϰ� data�� �������� �ʱ�
create table emp_04
as
select * from employees
where 1=0;  -- �ǵ������� Ʋ�� ���� ����

select * from emp_04;

select * from emp03;
desc emp03;
-- alter table : ���̺�  ����
alter table emp03 add (job varchar2(20));
alter table emp03 modify (first_name varchar2(30));
alter table emp03 modify (first_name varchar2(5));

alter table emp03 drop column first_name;  -- ���� : rollback �Ұ�

-- drop table : ���̺� ����
drop table emp03;

-- truncate table : ������ �����ϰ� data�� ����, rollback �Ұ�
select * from emp01;
truncate table emp01;

-- DD (Data Dictionary)
select * from user_tables;
select * from all_tables;

-- DML (Date Manipulation Language) : insert, delete, update  �ڵ� commit X
insert into emp01 values (100, '����', 1000);  -- ���� ���ǿ����� Ȯ�ΰ���, �ٸ� ���ǿ����� Ȯ�� �Ұ���
select * from emp01;
commit;  -- db�� ������ ����

desc emp01;

insert into emp01(empno, ename, sal) values (1, 'aa', 500);
insert into emp01(empno, ename, sal) values (1, 'aa', 500, 600);  -- "too many values"
insert into emp01(empno, ename, sal) values (1, aa, 500);  -- "column not allowed here" (���ڰ��� �ݵ�� ''�� ���)
insert into emp01(empno, sal, ename) values (1, 'aa', 500);  -- "invaild number" (Type ����)
insert into emp01(empno, sal) values (1, 500);  -- ����, �Է¾ȵ� ���� null
insert into emp01(empno, sal) values (1, 600);
insert into emp01(empno, sal, ename) values (1, 600, null);
insert into emp01(empno, sal, ename) values (1, null, null);

insert into emp01 values (1, 'aa', 500);
insert into emp01 values (1, 'aa');  -- "not enough values"

select * from emp01;

create table emp05
as
select employee_id, first_name, salary from employees where 1=0;

select * from emp05;

insert into emp05
select employee_id, first_name, salary from employees where department_id = 60;

insert into emp05
select department_id, department_name, 0 from departments;

select * from emp05 order by 1;
commit;

update emp05 set salary = 20000;
rollback;  -- ���ݱ��� ������ ��� DML�� ���󺹱�

update emp05 set salary = 20000 where employee_id = 10;

update emp05 set salary = 30000, first_name = 'shinhanDS' where employee_id = 20;

-- 20�� ������ �޿��� 10�� ������ �޿��� ���� �����
update emp05 set salary = (select distinct salary from emp05 where employee_id  = 10)
where employee_id = 20;

select * from emp05 order by 1;
commit;

delete from emp05 where employee_id = 10;

-- 107��
create table emp06
as
select * from employees;

create table emp07
as
select * from employees where job_id = 'IT_PROG';

update emp07 set job_id = 'firstzone';

commit;

select * from emp06;
select * from emp07;

insert into emp07 values(999, 'a','b', 'zz', '1234',sysdate, 'aa',1000, 0.1, 100, 60);

merge into emp06 using emp07 on(emp06.employee_id = emp07.employee_id)
when matched then
        update set emp06.job_id = emp07.job_id
when not matched then
        insert   values(
                        emp07.employee_id,
                        emp07.first_name,
                        emp07.last_name,
                        emp07.email,
                        emp07.phone_number,
                        emp07.hire_date,
                        emp07.job_id,
                        emp07.salary,
                        emp07.commission_pct,
                        emp07.manager_id,
                        emp07.department_id);
                        
select * from employees;
