-- 2005�� 1�� 30�� ���Ŀ� �Ի��� ���� ��ȸ
-- �̻�, ���� (����)
-- ����, ���� (����)
-- '10000' -> 10000 �ڵ����� ��ȯ
-- '05/01/30' -> to_data('05/01/30') �ڵ����� ��¥�� ��ȯ
select *
from employees
where salary >= 10000
and commission_pct is not null
and job_id = 'SA_REP'
and hire_date >= '05/01/30';

-- not�� ��Ÿ���� ��� 3����
select *from employees
where not department_id = 80;

select *from employees
where department_id <> 80;

select *from employees
where department_id != 80;

-- �޿��� 10000�̻� 20000����
select *from employees
where salary >= 10000 and salary <= 20000;

select *from employees
where salary between 10000 and 20000;

-- �μ��� 60,90,100�� ���� ��ȸ
select *from employees
where department_id = 60 or department_id = 90 or department_id = 100;

select *from employees
where department_id in (60, 90, 100);

-- �μ��� 60,90,100�� �ƴ� ���� ��ȸ
select *from employees
where department_id <> 60 or department_id <> 90 or department_id <> 100;

select *from employees
where department_id not in (60, 90, 100);

-- LIKE
-- % : �ϳ� �̻��� ������ ����
-- _ : �ϳ��� ������ ����
select *from employees
where first_name like 'S%';

select *from employees
where first_name like '%an%';

select *from employees
where first_name like '%e';

select *from employees
where first_name like '_____';

select *from employees
where first_name like '_____a';

select *from employees
where first_name not like '_a%';

-- SCOTT
select * from emp
where mgr is null;

select *from employees
where manager_id is null;

-- ORDER BY
-- asc(ascending) ��������
-- desc(descending)
-- oracle������ asc�϶� null�� �������� ���´�.
-- nulls first ����ϸ� null�� ó���� ���´�. nulls last�� �� �ڿ�
select *from employees
where manager_id is not null
order by commission_pct nulls first;

select *from employees
where manager_id is not null
order by commission_pct desc nulls last;



