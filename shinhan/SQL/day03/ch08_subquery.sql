
-- 니나와 같은 부서에 근무하는 직원들의 이름과 급여를 조회하시오
select *
from employees
where department_id = (select department_id
                       from employees
                       where first_name = 'Neena');

-- 데이비드와 같은 직책을 가진 직원들 조회
select *
from employees
where job_id in (
select job_id
from employees
where first_name = 'David');

select count(*) from employees where first_name = 'David';

-- 평균급여보다 더 높은 급여를 받고 있는 직원들을 조회
select *
from employees
where salary > (
select avg(salary)
from employees);

-- 급여가 10000 이상인 직원부서와 같은 부서인 직원들을 조회
-- ANY : 요소들 중 하나만이라도 조건에 부합하면 됨.
-- = ANY는 IN과 같다.
select * from employees
where department_id in (
                    select distinct department_id from employees
                    where salary >= 10000);
                    
-- 60번 부서에 근무하는 모든 직원의 급여보다 큰 급여를 받는 직원을 조회
-- ALL : 모든 요소의 조건을 모두 만족해야함.
select * from employees
where salary > all (
                    select salary from employees
                    where department_id = '60');
                    
select * from employees
where salary < all (
                    select salary from employees
                    where department_id = '60');

-- 단일행 서브쿼리 : 서브쿼리 결과가 1건                    
-- 다중행 서브쿼리 : 서브쿼리 결과가 2건 이상 (>ANY, < ALL ...)
-- 다중칼럼 서브쿼리
-- 부서별 최소 급여를 받는 직원의 정보를 조회하시오
select *
from employees
where (department_id, salary) in (
                    select department_id, min(salary)
                    from employees
                    group by department_id);
                    
-- 본인이 받는 급여가 본인이 속한 부서의 평균 급여보다 적은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오
-- 상관 서브쿼리
select *
from employees outeremp
where salary < (select avg(salary) from employees where department_id = outeremp.department_id);
ㄴ
-- inline view : 상관 서브쿼리보다 좋다
-- scalar subquery : select절에 들어가는 서브쿼리
select first_name, salary, avgsal, (select avg(salary) from employees) "전체평균"
from (
        select department_id, avg(salary) avgsal
        from employees
        group by department_id) inlineview, employees
where inlineview.department_id = employees.department_id
and salary < inlineview.avgsal;