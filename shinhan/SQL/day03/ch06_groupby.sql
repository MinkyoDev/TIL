-- sql문 실행순서
select *  --3
from employees  --1
where job_id = 'IT_PROG'  --2
order by 1; --4

-- 단일행 함수  1건 -> 1건
select first_name, lower(email)
from employees 
where job_id = 'IT_PROG'
and length(first_name) > 5
order by 1;

-- 다중행 함수  여러건 -> 1건, 칼럼이름을 사용하면 null은 제외
select avg(salary), sum(salary), max(salary), min(salary), count(salary), count(department_id), count(commission_pct) "null제외", count(*) "null포함"
from employees;

-- sum, avg 등은 null 제외
select sum(department_id)/106, avg(department_id)
from employees;

-- distinct 중복제거
select count(department_id), count(distinct department_id)
from employees;

-- group by
select department_id, count(department_id), count(*), sum(salary)
from employees
group by department_id
order by 1;

-- select절에 사용한 칼럼이 집계함수를 사용하지 않았다면 반드시 group by절에 참여해야 함
select department_id 부서벌, job_id 직책별, sum(salary) 급여합계, count(*) 직원수  --4
from employees  --1
where department_id is not null  --2
group by department_id, job_id  --3
order by 1;  --5

-- 집계함수는 where절에 사용 불가
-- 조건을 위해 having절 사용
select department_id 부서벌, job_id 직책별, sum(salary) 급여합계, count(*) 직원수, count(commission_pct)
from employees
where department_id is not null
group by department_id, job_id
having count(*) > 10
order by 1;

-- rollup은 대그룹의 중간합계를 제공
select department_id 부서벌, job_id 직책별, sum(salary) 급여합계, count(*) 직원수
from employees
where department_id is not null
group by rollup(department_id, job_id)
order by 1;

-- cube는 모든 조합의 합계 제공
select department_id 부서벌, job_id 직책별, sum(salary) 급여합계, count(*) 직원수
from employees
where department_id is not null
group by cube(department_id, job_id)
order by 1;

-- grouping : 해당 칼럼값이 null이면 1을 출력
select department_id 부서벌, job_id 직책별, sum(salary) 급여합계, count(*) 직원수, grouping(department_id), grouping(job_id)
from employees
where department_id is not null
group by rollup(department_id, job_id)
order by 1;

select department_id 부서벌, job_id 직책별, sum(salary) 급여합계, count(*) 직원수, grouping(department_id), grouping(job_id)
from employees
where department_id is not null
group by cube(department_id, job_id)
order by 1;

-- grouping을 사용하여 null에 특정 값을 부여
select department_id 부서벌, decode(grouping(job_id), 1, '합계', job_id), sum(salary) 급여합계, count(*) 직원수, grouping(department_id), grouping(job_id)
from employees
where department_id is not null
group by rollup(department_id, job_id)
order by 1;

-- LISTAGG : 값들을 가로로 바꿔줌
select department_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name) "Employees"
from employees
group by department_id;

select department_id, job_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name) "Employees"
from employees
group by department_id, job_id;