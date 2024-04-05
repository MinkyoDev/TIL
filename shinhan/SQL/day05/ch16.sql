-- index(����) : ������ �˻��ӵ� ���, ���� : ����� �ð� �ҿ�, ������ ������
-- Oracle�� primary key�� �ڵ����� index�� ���������. �߰� ����
select *
from user_ind_columns where table_name = 'EMPLOYEES';

select * from employees
where first_name = 'Alexander';

select * from employees
where first_name = 'Steven';

-- index ������ Į���� �����ϸ� (�Լ����) index�� ������ �ʰ� ���� ����
select * from employees
where initcap(first_name) = 'Alexander';

explain plan for
select * from employees
where first_name = 'Alexander';

explain plan for
select * from employees
where job_id = 'IT_PROG';

select * from table(DBMS_XPLAN.display);


-- index ���� ���� ���� �� ��
create table emp_copy2  -- ���� + data ����, not null ���� �ٸ� ���������� ���� �ȵ�.
as
select * from employees;

insert into emp_copy2 select * from employees;
insert into emp_copy2 select * from emp_copy2;
commit;
select count(*) from emp_copy2;

select * from emp_copy2;
insert into emp_copy2 values (2, 'aa','bb','zz','1212',sysdate,'IT',12345,null,null,null);

select * from emp_copy2 where employee_id = 2;
select * from emp_copy2 where first_name = 'aa';
set timing on;

create index emp_copy2_firstname_ix on emp_copy2(first_name);

