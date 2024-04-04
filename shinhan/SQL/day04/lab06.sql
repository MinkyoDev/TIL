--========================================
--    		SubQuery
  ========================================

-- 1. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�. ��, �μ��� ���� ������ �ִٸ� �� ���������� ��°���� ���Խ�Ų��.
--    �׸��� �μ��� ���� ������ ���ؼ��� '<�μ�����>' �� ��µǵ��� �Ѵ�. (outer-join , nvl() )
select first_name, hire_date, nvl(department_name, '<�μ�����>')
from employees
left outer join departments using (department_id);


-- 2. ������ ��å�� ���� ������ �ٸ��� �����Ϸ��� �Ѵ�. ��å�� 'Manager'�� ���Ե� ������ �޿��� 0.5�� ���ϰ� ������ �����鿡 ���ؼ��� ������ �޿��� �����ϵ��� �Ѵ�. �����ϰ� ��ȸ�Ͻÿ�. (decode)
select first_name, salary, job_title, decode(substr(job_title, -7), 'Manager', salary*0.5, salary)
from employees
join jobs using (job_id);


-- 3. �� �μ����� �����޿��� �޴� ������ �̸��� �μ�id, �޿��� ��ȸ�Ͻÿ�.
select first_name, department_id, salary
from employees
where (department_id, salary) in (
                    select department_id, min(salary)
                    from employees
                    group by department_id);

select employees.first_name, employees.department_id, employees.salary
from employees, (select department_id, min(salary) minsal
                from employees
                group by department_id) aa
where employees.department_id = aa.department_id
and employees.salary = aa.minsal;

-- 4. �� ���޺�(job_title) �ο����� ��ȸ�ϵ� ������ ���� ������ �ִٸ� �ش� ���޵� ��°���� ���Խ�Ű�ÿ�. �׸��� ���޺� �ο����� 3�� �̻��� ���޸� ��°���� ���Խ�Ű�ÿ�.
select job_title, count(first_name)
from employees
right outer join jobs using (job_id)
group by job_title
having count(*) >= 3;


-- 5. �� �μ��� �ִ�޿��� �޴� ������ �̸�, �μ���, �޿��� ��ȸ�Ͻÿ�.
select first_name, department_name, salary
from employees join departments using (department_id)
where (department_id, salary) in (
                    select department_id, max(salary)
                    from employees
                    group by department_id);


-- 6. ������ �̸�, �μ�id, �޿��� ��ȸ�Ͻÿ�. �׸��� ������ ���� �ش� �μ��� �ּұ޿��� �������� ���Խ��� ��� �Ͻÿ�.
select emp.first_name, emp.department_id, emp.salary, eachdept.minsal
from employees emp join (
                    select department_id, min(salary) minsal
                    from employees
                    group by department_id) eachdept on (emp.department_id = eachdept.department_id);

select first_name, department_id, salary, (select min(salary) from employees where department_id = outeremp.department_id)
from employees outeremp;
 


