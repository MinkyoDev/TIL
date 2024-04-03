select * from employees;
select * from departments;
select * from countries;
select * from regions;

-- cross join : 조인문장이 없는 경우 * 건수만큼 출력
select first_name, department_name
from employees, departments
order by 1;

-- equi join : = 연산자를 이용
-- 기준이 누구인지가 중요, 직원이 부서를 참조 -> 직원건수
select first_name, department_name
from employees, departments
where employees.department_id = departments.department_id
order by 1;

select employees.first_name, employees.salary, jobs.job_title, jobs.max_salary
from employees, jobs
where employees.job_id = jobs.job_id
order by 1;

-- 부서 테이블의 manager_id는 부서장, 직원 중 1명, 부서장의 이름은?
select departments.*, employees.first_name, employees.last_name
from employees, departments
where employees.employee_id = departments.manager_id;

select emp.first_name, dept.department_name, dept.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id;

-- 벤더 문법 : Oracle, sybase, MySQL ... 지원함. 다만 표준은 아님
select emp.first_name, dept.department_name, dept.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id(+);  -- Oracle에서 outer join 하는 법. 다른 dbms에서는 못씀

-- 표준 문법
-- using은 조인할 테이블에 같은 이름의 칼럼으로 조인시 사용
select first_name, department_name, department_id
from employees join departments using(department_id)
where department_id > 0;

-- join on : 칼럼의 이름이 다른 경우 조인하는 법
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

-- self join : 자기 테이블을 자기가 참조, 참조하고자 하는 칼럼이 자신의 테이블에 있는 경우.
select 직원.first_name, 직원.salary, 메니저.first_name, 메니저.salary
from employees 직원, employees 메니저
where 직원.manager_id = 메니저.employee_id
order by 직원.employee_id;

-- 표준 (inner는 생략가능)
select 직원.first_name, 직원.salary, 메니저.first_name, 메니저.salary
from employees 직원 inner join employees 메니저 on (직원.manager_id = 메니저.employee_id)
order by 직원.employee_id;

-- outer join : 조건에 맞지 않는 행도 조회하고자 할때 (없는쪽에 +를 넣는다)
select 직원.first_name, 직원.salary, 메니저.first_name, 메니저.salary
from employees 직원, employees 메니저
where 직원.manager_id = 메니저.employee_id(+)  --Oracle만 지원, sybase는 *이용, 지양할것
order by 직원.employee_id;

-- 표준
select 직원.first_name, 직원.salary, 메니저.first_name, 메니저.salary
from employees 직원 left outer join employees 메니저 on (직원.manager_id = 메니저.employee_id)
order by 직원.employee_id;

select 직원.first_name, 직원.salary, nvl(메니저.first_name, '메니저없음'), nvl2(메니저.salary, to_char(메니저.salary), '메니저없음')
from employees 메니저 right outer join employees 직원 on (직원.manager_id = 메니저.employee_id)
order by 직원.employee_id;

-- 직원의 부서정보 보기
select first_name, salary, nvl(department_name, '부서없음')
from employees left outer join departments on (employees.department_id = departments.department_id);

-- full outer join은 모두 나오게 된다.
select nvl(first_name, '직원없음'), salary, nvl(department_name, '부서없음')
from employees full join departments on (employees.department_id = departments.department_id);