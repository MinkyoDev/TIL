-- ���� �ѹ� �ϴµ� �ٶ������� ����
select DISTINCT 10+20
from employees;

-- dual�� �����ڴ� sys, sys�� ������ ��
-- 1���� �����͸� ��ȸ�ؾ� �ϴ� ��� ���
desc dual;

select * from dual;

select 10+20, sysdate
from dual;


-- ���� �Լ�
select 12.5, round(12.5) �ݿø�, round(12.567, 2) "�ݿø�(�Ҽ� 2�ڸ�)", floor(12.56) ����, ceil(12.567) �ø�, mod(10,3)
from dual;

-- ���� �Լ�
-- concat�� �ٸ� db���� ����, ||�����ڴ� Oracle����, MySQL�� +
select first_name, upper(first_name), lower(first_name), initcap(email), substr(first_name,1), substr(first_name,1,3), length(first_name), first_name||' '||last_name, concat(first_name, last_name)
from employees;

-- SCOTT
desc emp;

-- ''���� ���θ� ��ҹ��ڸ� ������
select * from emp
where job = upper('manager');

-- ���� job_id�� index�� ������� �ִٸ� Į������ �������� �ʴ� ���� ȿ����
select * from employees
where job_id = upper('it_prog');

select * from employees
where lower(job_id) = lower('it_prog');

-- manager�鸸 ã������
-- like ���ٴ� = �� �� ����
select * from jobs
where job_title like '%Manager';

select * from jobs
where substr(job_title, -7) = 'Manager';

select * from jobs
where substr(job_title, -7) = initcap('manager');

-- 12���� �Ի��� ������
select first_name, hire_date, substr(hire_date, 1, 2) �⵵, substr(hire_date, 4, 2) ��, substr(hire_date, 7, 2) ��
from employees
--where hire_date like'__/12/__'
--where substr(hire_date, 4, 2) = 12;
where to_char(hire_date, 'mm') = 12;

-- ������ �ε����� -1
select first_name, instr(first_name, 'e') "��ġã��", instr(first_name, 'e', 5) "5���� ��ġã��", instr(first_name, 'e', -2) "�ڿ������� ��ġã��", instr(first_name, 'e', 2, 2) "������ġ, ���°"
from employees;

-- LPAD : ���ʿ� �� ä���, �ڸ����� ������ ©��
-- RPAD : �����ʿ� �� ä���, �ڸ����� ������ ©��
select first_name, lpad(first_name,10,'*'), rpad(first_name,10,'*')
from employees;

-- LTRIM : ���� ���� ����
-- RTRIM : ������ ���� ����
-- TRIM : ���� ���� ����
select '*'||ltrim('   Oracle   ')||'*', '*'||rtrim('   Oracle   ')||'*', '*'||trim('   Oracle   ')||'*'
from dual;

-- TRIM Ư�� ���� ����
select trim('a' from 'aaaaaaOricleaaaaaa')
from dual;

select first_name, trim('A' from first_name)
from employees;

-- ��¥ ���
select first_name, hire_date, sysdate+1 ����, floor(sysdate-hire_date) �ٹ��ϼ�, floor(months_between(sysdate, hire_date)/12) �ٹ����
from employees
order by �ٹ���� desc;

select first_name, hire_date, add_months(hire_date, 6) "6���� ��", sysdate, add_months(sysdate, 6), last_day(hire_date), next_day(sysdate, '��'), to_char(hire_date, 'yyyy/mm/dd hh:mi:ss day d dy')
from employees;

-- mm: ���� �������� �ݿø�. 16���� ����
select first_name, hire_date, round(hire_date, 'mm') "�ݿø�(��)", trunc(hire_date, 'mm') "����(��)"
from employees;

-- to_char : ��¥ -> ����
-- mm : �� / mon: ������ ����
select to_char(sysdate, 'yyyy/mm/dd hh:mi:ss day d dy'), to_char(sysdate, 'yyyy/mon/dd hh:mi:ss day d dy'), to_char(sysdate, 'yyyy/mm/dd hh:mi:ss day d dy hh24 am/pm')
from dual;

-- to_char : ���� -> ���� L���̸� ��ȭ ���� ����
select to_char(10000, '99,999,999'), to_char(10000, 'L000,000,000.00')
from dual;

-- to_date
select *
from employees
where hire_date >= '05/01/01';

alter session set NLS_DATE_FORMAT = 'mm/dd/yyyy';

select *
from employees
where hire_date >= '01/01/2005';

select *
from employees
where to_char(hire_date, 'rr/mm/dd') >= '05/01/01';

alter session set NLS_DATE_FORMAT = 'RR/mm/dd';

-- nvl(colmn, null�϶� ��ü��) : null ó�� �Լ�
-- nvl(colmn, null�϶� ��ü��, null�϶�)
select first_name, salary, nvl(to_char(commission_pct), 'Ŀ�̼� ����'), nvl2(commission_pct, to_char(commission_pct), 'Ŀ�̼� ����'), salary+salary*commission_pct �Ǽ��ɾ�, salary+salary*nvl(commission_pct, 0) �Ǽ��ɾ�,
nvl(to_char(department_id), '�μ�����')
from employees
--where department_id is null
--where nvl(to_char(department_id), '�μ�����') = '�μ�����'
order by commission_pct nulls first;

-- coalesce
select first_name, commission_pct, department_id, coalesce(to_char(commission_pct), to_char(department_id), first_name) "null�ƴ� ù��° Į����"
from employees;

-- decode�� =�����ڰ� ������ ��. �� =��츸 ����
-- case�� sql������ ���Ǵ� ��� ������ ��� ����
select first_name, salary, decode(salary, 24000, '�ſ츹��', 17000, '����', 12008, '����', '����') �޿���, decode(length(first_name), 9, 'large', 8, 'middle', 'small') �̸�����,
    case when salary >= 2000 then '����' 
    when salary < 2000 and salary >= 1000 then '����' 
    when salary < 10000 and salary >= 5000 then '����' 
    else '���ڶ�' end �޿���2, 
    job_id,
    decode(job_id, 'AD_PRES', 'A', 'AD_VP', 'A', 'IT_PROG', 'A', 'B') job2,
    case when job_id in('AD_PRES', 'AD_VP', 'IT_PROG') then 'A' else 'B' end job3
from employees;


