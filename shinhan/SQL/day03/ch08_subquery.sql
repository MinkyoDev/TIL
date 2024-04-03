
-- �ϳ��� ���� �μ��� �ٹ��ϴ� �������� �̸��� �޿��� ��ȸ�Ͻÿ�
select *
from employees
where department_id = (select department_id
                       from employees
                       where first_name = 'Neena');

-- ���̺��� ���� ��å�� ���� ������ ��ȸ
select *
from employees
where job_id in (
select job_id
from employees
where first_name = 'David');

select count(*) from employees where first_name = 'David';

-- ��ձ޿����� �� ���� �޿��� �ް� �ִ� �������� ��ȸ
select *
from employees
where salary > (
select avg(salary)
from employees);

-- �޿��� 10000 �̻��� �����μ��� ���� �μ��� �������� ��ȸ
-- ANY : ��ҵ� �� �ϳ����̶� ���ǿ� �����ϸ� ��.
-- = ANY�� IN�� ����.
select * from employees
where department_id in (
                    select distinct department_id from employees
                    where salary >= 10000);
                    
-- 60�� �μ��� �ٹ��ϴ� ��� ������ �޿����� ū �޿��� �޴� ������ ��ȸ
-- ALL : ��� ����� ������ ��� �����ؾ���.
select * from employees
where salary > all (
                    select salary from employees
                    where department_id = '60');
                    
select * from employees
where salary < all (
                    select salary from employees
                    where department_id = '60');

-- ������ �������� : �������� ����� 1��                    
-- ������ �������� : �������� ����� 2�� �̻� (>ANY, < ALL ...)
-- ����Į�� ��������
-- �μ��� �ּ� �޿��� �޴� ������ ������ ��ȸ�Ͻÿ�
select *
from employees
where (department_id, salary) in (
                    select department_id, min(salary)
                    from employees
                    group by department_id);
                    
-- ������ �޴� �޿��� ������ ���� �μ��� ��� �޿����� ���� �޿��� �޴� ������ �̸�, �μ���ȣ, �޿��� ��ȸ�Ͻÿ�
-- ��� ��������
select *
from employees outeremp
where salary < (select avg(salary) from employees where department_id = outeremp.department_id);
��
-- inline view : ��� ������������ ����
-- scalar subquery : select���� ���� ��������
select first_name, salary, avgsal, (select avg(salary) from employees) "��ü���"
from (
        select department_id, avg(salary) avgsal
        from employees
        group by department_id) inlineview, employees
where inlineview.department_id = employees.department_id
and salary < inlineview.avgsal;