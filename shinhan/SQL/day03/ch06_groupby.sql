-- sql�� �������
select *  --3
from employees  --1
where job_id = 'IT_PROG'  --2
order by 1; --4

-- ������ �Լ�  1�� -> 1��
select first_name, lower(email)
from employees 
where job_id = 'IT_PROG'
and length(first_name) > 5
order by 1;

-- ������ �Լ�  ������ -> 1��, Į���̸��� ����ϸ� null�� ����
select avg(salary), sum(salary), max(salary), min(salary), count(salary), count(department_id), count(commission_pct) "null����", count(*) "null����"
from employees;

-- sum, avg ���� null ����
select sum(department_id)/106, avg(department_id)
from employees;

-- distinct �ߺ�����
select count(department_id), count(distinct department_id)
from employees;

-- group by
select department_id, count(department_id), count(*), sum(salary)
from employees
group by department_id
order by 1;

-- select���� ����� Į���� �����Լ��� ������� �ʾҴٸ� �ݵ�� group by���� �����ؾ� ��
select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������  --4
from employees  --1
where department_id is not null  --2
group by department_id, job_id  --3
order by 1;  --5

-- �����Լ��� where���� ��� �Ұ�
-- ������ ���� having�� ���
select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������, count(commission_pct)
from employees
where department_id is not null
group by department_id, job_id
having count(*) > 10
order by 1;

-- rollup�� ��׷��� �߰��հ踦 ����
select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������
from employees
where department_id is not null
group by rollup(department_id, job_id)
order by 1;

-- cube�� ��� ������ �հ� ����
select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������
from employees
where department_id is not null
group by cube(department_id, job_id)
order by 1;

-- grouping : �ش� Į������ null�̸� 1�� ���
select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������, grouping(department_id), grouping(job_id)
from employees
where department_id is not null
group by rollup(department_id, job_id)
order by 1;

select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������, grouping(department_id), grouping(job_id)
from employees
where department_id is not null
group by cube(department_id, job_id)
order by 1;

-- grouping�� ����Ͽ� null�� Ư�� ���� �ο�
select department_id �μ���, decode(grouping(job_id), 1, '�հ�', job_id), sum(salary) �޿��հ�, count(*) ������, grouping(department_id), grouping(job_id)
from employees
where department_id is not null
group by rollup(department_id, job_id)
order by 1;

-- LISTAGG : ������ ���η� �ٲ���
select department_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name) "Employees"
from employees
group by department_id;

select department_id, job_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name) "Employees"
from employees
group by department_id, job_id;