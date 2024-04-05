-- �޿��� ���� ���� �޴� ���� 5�� ��ȸ
select rownum, aa.*
from (
select first_name, salary
from employees
order by salary desc) aa
where rownum <= 6;

-- �޿��� ���� ���� �޴� 5��° ����
select *
from (
        select rownum rr, aa.*
        from (
                select first_name, salary
                from employees
                order by salary desc) aa
        )
where rr = 5;

-- row_number() : �ߺ��� ���� ��ü ���� ����
-- rank() : �ߺ��� ������ �ߺ� ��ũ�� �����ϰ� ������ ����
-- dense_rank() : �ߺ���ũ�� �ϳ��� ������ ����
select *
from (
select first_name, salary, 
row_number() over (order by salary desc) ��ũ1,
rank() over (order by salary desc) ��ũ2,
dense_rank() over (order by salary desc) ��ũ3
from employees)
where rownum <= 5;

-- ���̺� ���� (employees -> emp_copy)
-- ���̺� ���� (department -> dept_copy) : �������� �� not null�� �����
-- DDL(create table, drop table, rename, truncate, alter table) : �ڵ� Ŀ�Ե�
create table emp_copy
as
select * from employees where department_id = 60;

select * from user_constraints where table_name = 'EMP_COPY';
select * from user_cons_columns where table_name = 'EMP_COPY';

select * from emp_copy;

-- �������� �߰��ϱ�
alter table emp_copy add constraint emp_copy_empid_pk Primary key(employee_id);
alter table emp_copy add constraint emp_copy_deptid_fk foreign key (department_id) references dept_copy(department_id);

----------------------
create table dept_copy
as
select * from departments where manager_id is not null;

select * from dept_copy;

select * from user_constraints where table_name = 'DEPT_COPY';
select * from user_cons_columns where table_name = 'DEPT_COPY';

alter table dept_copy add constraint dept_copy_deptid_pk Primary key(department_id);

-- DML(insert, delete, update) : ����Ȯ�� commit, ��� rollback
insert into emp_copy values(108, 'aa', 'bb', 'cc', '444', sysdate, 'aa', 1000, null, 333, 100);
delete from emp_copy where department_id = 77;
commit;

-- �ڽ��� �ִµ� ����� ���� ��
alter table dept_copy drop constraint dept_copy_deptid_pk cascade;