-- SELF JOIN
-- 1. ������ �̸��� ������ �̸��� ��ȸ�Ͻÿ�.
select emp.first_name, emp.manager_id, mng.first_name
from employees emp
join employees mng on (emp.manager_id = mng.employee_id);

select emp.first_name, emp.manager_id, mng.first_name
from employees emp, employees mng 
where emp.manager_id = mng.employee_id;


-- 2. ������ �̸��� ������ �̸��� ��ȸ�Ͻÿ�. �����ڰ� ���� ���������� ��� ����Ͻÿ�.
select emp.first_name, emp.manager_id, mng.first_name
from employees emp
left outer join employees mng on (emp.manager_id = mng.employee_id);

select emp.first_name, emp.manager_id, mng.first_name
from employees emp, employees mng 
where emp.manager_id = mng.employee_id(+);


-- 3. ������ �̸��� �����ڰ� �����ϴ� ������ ���� ��ȸ�Ͻÿ�. ��, ������������ 3�� �̻��� �����ڸ� ��µǵ��� �Ͻÿ�.
select mng.first_name, count(*)
from employees emp
join employees mng on (emp.manager_id = mng.employee_id)
group by rollup(mng.first_name)
having count(*) >= 3;

select mng.first_name, count(*)
from employees emp
left outer join employees mng on (emp.manager_id = mng.employee_id)
group by rollup(mng.first_name)
having count(*) >= 3;