select * from employees;
select * from departments;
select * from countries;
select * from regions;

-- cross join : ���ι����� ���� ��� * �Ǽ���ŭ ���
select first_name, department_name
from employees, departments
order by 1;

-- equi join : = �����ڸ� �̿�
-- ������ ���������� �߿�, ������ �μ��� ���� -> �����Ǽ�
select first_name, department_name
from employees, departments
where employees.department_id = departments.department_id
order by 1;

select employees.first_name, employees.salary, jobs.job_title, jobs.max_salary
from employees, jobs
where employees.job_id = jobs.job_id
order by 1;

-- �μ� ���̺��� manager_id�� �μ���, ���� �� 1��, �μ����� �̸���?
select departments.*, employees.first_name, employees.last_name
from employees, departments
where employees.employee_id = departments.manager_id;

select emp.first_name, dept.department_name, dept.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id;

-- ���� ���� : Oracle, sybase, MySQL ... ������. �ٸ� ǥ���� �ƴ�
select emp.first_name, dept.department_name, dept.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id(+);  -- Oracle���� outer join �ϴ� ��. �ٸ� dbms������ ����

-- ǥ�� ����
-- using�� ������ ���̺� ���� �̸��� Į������ ���ν� ���
select first_name, department_name, department_id
from employees join departments using(department_id)
where department_id > 0;

-- join on : Į���� �̸��� �ٸ� ��� �����ϴ� ��
select first_name, department_name, emp.department_id
from employees emp join departments dept on(emp.department_id = dept.department_id)
where emp.department_id > 0;

-- non-equi join
select * from tab;

select emp.*, salgrade.*
from emp, salgrade
where emp.sal between losal and hisal;

select emp.*, salgrade.*
from emp join salgrade on (emp.sal between losal and hisal);

-- self join : �ڱ� ���̺��� �ڱⰡ ����, �����ϰ��� �ϴ� Į���� �ڽ��� ���̺� �ִ� ���.
select ����.first_name, ����.salary, �޴���.first_name, �޴���.salary
from employees ����, employees �޴���
where ����.manager_id = �޴���.employee_id
order by ����.employee_id;

-- ǥ�� (inner�� ��������)
select ����.first_name, ����.salary, �޴���.first_name, �޴���.salary
from employees ���� inner join employees �޴��� on (����.manager_id = �޴���.employee_id)
order by ����.employee_id;

-- outer join : ���ǿ� ���� �ʴ� �൵ ��ȸ�ϰ��� �Ҷ� (�����ʿ� +�� �ִ´�)
select ����.first_name, ����.salary, �޴���.first_name, �޴���.salary
from employees ����, employees �޴���
where ����.manager_id = �޴���.employee_id(+)  --Oracle�� ����, sybase�� *�̿�, �����Ұ�
order by ����.employee_id;

-- ǥ��
select ����.first_name, ����.salary, �޴���.first_name, �޴���.salary
from employees ���� left outer join employees �޴��� on (����.manager_id = �޴���.employee_id)
order by ����.employee_id;

select ����.first_name, ����.salary, nvl(�޴���.first_name, '�޴�������'), nvl2(�޴���.salary, to_char(�޴���.salary), '�޴�������')
from employees �޴��� right outer join employees ���� on (����.manager_id = �޴���.employee_id)
order by ����.employee_id;

-- ������ �μ����� ����
select first_name, salary, nvl(department_name, '�μ�����')
from employees left outer join departments on (employees.department_id = departments.department_id);

-- full outer join�� ��� ������ �ȴ�.
select nvl(first_name, '��������'), salary, nvl(department_name, '�μ�����')
from employees full join departments on (employees.department_id = departments.department_id);