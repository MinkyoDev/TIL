-- ========================================
--    		SubQuery
-- ========================================
-- 1. 'IT'�μ����� �ٹ��ϴ� �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, salary, hire_date
from employees 
join departments using (department_id)
where department_name = 'IT';

select first_name, salary, hire_date
from employees 
where department_id = (
                    select department_id from departments
                    where department_name = 'IT');


-- 2. 'Alexander' �� ���� �μ����� �ٹ��ϴ� ������ �̸��� �μ�id�� ��ȸ�Ͻÿ�.
select first_name, department_id
from employees
where department_id in (
                    select department_id from employees
                    where first_name = 'Alexander');


-- 3. 80���μ��� ��ձ޿����� ���� �޿��� �޴� ������ �̸�, �μ�id, �޿��� ��ȸ�Ͻÿ�.
select first_name, department_id, salary from employees
where salary > (
                select avg(salary) from employees
                where department_id = '80');



-- 4. 'South San Francisco'�� �ٹ��ϴ� ������ �ּұ޿����� �޿��� ���� �����鼭 50 ���μ��� ��ձ޿����� ���� �޿��� �޴� ������ �̸�, �޿�, �μ���, �μ�id�� ��ȸ�Ͻÿ�.
select first_name, salary, department_name, department_id
from employees join departments using (department_id)
where salary > any (
                    select salary from employees
                    join departments using (department_id)
                    join locations using (location_id)
                    where city = 'South San Francisco')
and salary > (
                    select avg(salary) from employees 
                    where department_id = 50);


-------------------scott/tiger (emp, dept)

-- 1. BLAKE�� ������ �μ��� ���� ��� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�. ������� BLAKE�� ���ܽ�ŵ�ϴ�.
select ename, hiredate from emp 
where deptno = (
                    select deptno from emp where ename = 'BLAKE')
and ename != 'BLAKE';


-- 2. �μ��� ��ġ�� DALLAS�� ��� ����� �̸�, �μ���ȣ , ������ ǥ���Ͻÿ� 
select ename, deptno, job from emp join dept using (deptno) where loc = 'DALLAS';

select ename, deptno, job from emp 
where deptno = (select deptno from dept where loc = 'DALLAS');


-- 3. KING���� �����ϴ� ��� ����� �̸��� �޿��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ� 
select ename, sal from emp where mgr = (select empno from emp where ename = 'KING');













 
