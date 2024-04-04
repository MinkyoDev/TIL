--========================================
--    		SubQuery
  ========================================

-- 1. 직원들의 이름, 입사일, 부서명을 조회하시오. 단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
--    그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다. (outer-join , nvl() )
select first_name, hire_date, nvl(department_name, '<부서없음>')
from employees
left outer join departments using (department_id);


-- 2. 직원의 직책에 따라 월급을 다르게 지급하려고 한다. 직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고 나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 적절하게 조회하시오. (decode)
select first_name, salary, job_title, decode(substr(job_title, -7), 'Manager', salary*0.5, salary)
from employees
join jobs using (job_id);


-- 3. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
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

-- 4. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도 출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.
select job_title, count(first_name)
from employees
right outer join jobs using (job_id)
group by job_title
having count(*) >= 3;


-- 5. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.
select first_name, department_name, salary
from employees join departments using (department_id)
where (department_id, salary) in (
                    select department_id, max(salary)
                    from employees
                    group by department_id);


-- 6. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 최소급여를 마지막에 포함시켜 출력 하시오.
select emp.first_name, emp.department_id, emp.salary, eachdept.minsal
from employees emp join (
                    select department_id, min(salary) minsal
                    from employees
                    group by department_id) eachdept on (emp.department_id = eachdept.department_id);

select first_name, department_id, salary, (select min(salary) from employees where department_id = outeremp.department_id)
from employees outeremp;
 


