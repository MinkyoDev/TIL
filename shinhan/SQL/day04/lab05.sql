-- SELF JOIN
-- 1. 직원의 이름과 관리자 이름을 조회하시오.
select emp.first_name, emp.manager_id, mng.first_name
from employees emp
join employees mng on (emp.manager_id = mng.employee_id);

select emp.first_name, emp.manager_id, mng.first_name
from employees emp, employees mng 
where emp.manager_id = mng.employee_id;


-- 2. 직원의 이름과 관리자 이름을 조회하시오. 관리자가 없는 직원정보도 모두 출력하시오.
select emp.first_name, emp.manager_id, mng.first_name
from employees emp
left outer join employees mng on (emp.manager_id = mng.employee_id);

select emp.first_name, emp.manager_id, mng.first_name
from employees emp, employees mng 
where emp.manager_id = mng.employee_id(+);


-- 3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오. 단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
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