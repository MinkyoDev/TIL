select * from tab;

desc employees;

-- ��ȸ : select
-- �ۼ����� : select-from-where-order by
-- ���� ���� : from-where-select-order by

select employee_id, first_name, salary �޿�
from employees
where salary >= 10000
order by salary;

select employee_id, first_name, salary �޿�
from employees
where salary >= 10000
order by 1;  -- �÷��̸�, ����, �÷���ȣ ����

select *
from employees
where salary >= 10000
and commission_pct is not null
and first_name like '____'
order by 2;