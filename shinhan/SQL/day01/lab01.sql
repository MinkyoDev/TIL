-- ========================================
--   		SELECT �⺻
-- ========================================
-- 1. �޿��� 15000 �̻��� �������� �̸�, �޿�, �μ�id�� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, department_id �μ�id
from employees
where salary >= 15000;

select first_name, salary, department_id
from employees
where salary >= 15000;

-- 2. ���� �߿��� ������ 170000 �̻��� �������� �̸�, ������ ��ȸ�Ͻÿ�. ������ �޿�(salary)�� 12�� ���� ���Դϴ�.
select first_name||' '||last_name as �̸�, salary*12 as ����
from employees
where salary >= 17000;

-- 3. ���� �߿��� �μ�id�� ���� ������ �̸��� �޿��� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�
from employees
where department_id is null;

-- 4. 2004�� ������ �Ի��� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where hire_date <= '04/12/31';

select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where to_char(hire_date, 'yyyy') <= 2004;

-- �⵵ : RR  50 �̻��̸� 19, �̸��̸� 20
select * from nls_session_parameters;
-- �⺻ ���� : NLS_DATE_FORMAT -> RR/MM/DD
alter session set NLS_DATE_FORMAT = 'yyyy/mm/dd';



-- -- �������� -- 
-- 1. 80, 50 �� �μ��� ���������鼭 �޿��� 13000 �̻��� ������ �̸�, �޿�, �μ�id�� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, department_id �μ�id
from employees
where department_id in (80, 50) and salary >= 13000;

-- 2. 2005�� ���Ŀ� �Ի��� ������ �߿��� �޿��� 1300 �̻� 20000 ������ �������� �̸�, �޿�, �μ�id, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, department_id �μ�id, hire_date �Ի���
from employees
where hire_date >= '05/01/01' and salary between 1300 and 20000;



-- -- SQL �񱳿����� --
-- 1. 80, 50 �� �μ��� ���������鼭 �޿��� 13000 �̻��� ������ �̸�, �޿�, �μ�id�� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, department_id �μ�id
from employees
where department_id in (80, 50) and salary >= 13000;

-- 2. 2005�� ���Ŀ� �Ի��� ������ �߿��� �޿��� 1300 �̻� 30000 ������ �������� �̸�, �޿�, �μ�id, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, department_id �μ�id, hire_date �Ի���
from employees
where hire_date >= '05/01/01' and salary between 1300 and 30000;

-- 3. 2005�⵵ �Ի��� ������ ������ ����Ͻÿ�.
select *
from employees
where hire_date >= '05/01/01' and hire_date <= '05/12/31';

select *
from employees
where hire_date between '05/01/01' and '05/12/31';

-- 4. �̸��� D�� �����ϴ� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where first_name like 'D%';

-- 5. 12���� �Ի��� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where hire_date like '%/12/%';

select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where to_char(hire_date, 'mm') = 12;

-- 6. �̸��� le �� �� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where first_name like '%le%' or last_name like '%le%';

-- 7. �̸��� m���� ������ ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where last_name like '%m';

-- 8. �̸��� ����° ���ڰ� r�� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, salary �޿�, hire_date �Ի���
from employees
where first_name like '__r%';

-- 9. Ŀ�̼��� �޴� ������ �̸�, Ŀ�̼�, �޿��� ��ȸ�Ͻÿ�.
select * from employees;
select first_name||' '||last_name as �̸�, commission_pct Ŀ�̼�, salary �޿�
from employees
where commission_pct is not null;

-- 10. Ŀ�̼��� ���� �ʴ� ������ �̸�, Ŀ�̼�, �޿��� ��ȸ�Ͻÿ�.
select first_name||' '||last_name as �̸�, commission_pct Ŀ�̼�, salary �޿�
from employees
where commission_pct is null;

-- 11. 2000��뿡 �Ի��ؼ� 30, 50, 80 �� �μ��� ���������鼭, �޿��� 5000 �̻� 17000 ���ϸ� �޴� ������ ��ȸ�Ͻÿ�. 
--      ��, Ŀ�̼��� ���� �ʴ� �������� �˻� ��󿡼� ���ܽ�Ű��, ���� �Ի��� ������ 
--      ���� ��µǾ�� �ϸ� �Ի����� ���� ��� �޿��� ���� ������ ���� ��µǷ� �Ͻÿ�.
select first_name, salary, hire_date, department_id, commission_pct
from employees
where hire_date between '2000/01/01' and '2009/12/31'
and department_id in (30, 50, 80)
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date, salary desc;