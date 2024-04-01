select * from tab;

desc employees;

-- *�� ��� �÷��� �ǹ�
select * 
from employees;

select employees.*
from employees;

-- Į�� �����ϱ�
select employee_id, first_name
from employees;

-- �����ֱ�, as�� ���� ����
select employee_id as ������ȣ, first_name �����̸�
from employees;

-- �������� �ٹ��ϴ� �μ���
select DEPARTMENT_ID
from employees;

-- �ߺ� ����(distinct) - ��� Į���� ���ļ� ��� �ߺ��ΰ͸� �ߺ����� ó��
-- null : ���ǵ� ���� ����. �μ� ���� ����.
select distinct DEPARTMENT_ID
from employees;

select distinct DEPARTMENT_ID, first_name, last_name
from employees;

-- ��������� ��밡��
select first_name, last_name, SALARY*12 ����
from employees;

-- invalid identifier ��ȿ���� ���� �ĺ���, Į�� �̸��� Ʋ��
-- table�� �����ϸ� Data Dictionary(data ����)�� Į�� �̸��� �빮�ڷ� ����. (ORACLE)


-- �÷� �̸��� ""��밡�� - �߰��� Ư������ ���� �� ���
-- SQL���� ""�� ����ϸ� �ĺ��� �̸��̴�. �ҹ��ڿ��� ��� ����.
select first_name, "LAST_NAME", SALARY*12 "�� ��"
from employees;

-- 107�� ������
select 10+20
from employees;

-- �ѹ��� �Ҷ� ����ϴ� table
desc dual;
select * from dual;

select 10+20, sysdate
from dual;

-- ||�� concat ������. ���ڿ��� ����
-- SQL������ ''�� ���� �ǹ�
select first_name, "LAST_NAME", SALARY*12 "�� ��", 10+20, LAST_NAME||' -> '||SALARY
from employees;

-- NULL�� �� ��, ��� �Ұ�
-- nvl(,) : null���� üũ�ؼ� ���� ������
select first_name, last_name, commission_pct, 
    nvl(commission_pct,0)*SALARY
from employees;

-- null�� = ���� �� �� �Ұ�(is ���), ���Ұ� (null ������ ��� ����� null), is ���
select first_name, last_name, commission_pct, 
    nvl(commission_pct,0)*SALARY
from employees
where commission_pct is null;

select *
from employees
where department_id = null;

select *
from employees
where department_id is null;

select *
from employees
where department_id is not null;

select first_name, last_name, salary, commission_pct, nvl(commission_pct,0)*salary+salary "���� �޿�"
from employees;

select first_name||' '||last_name as name, nvl(commission_pct,0)*salary+salary "�޿�"
from employees;

