-- 2005년 1월 30일 이후에 입사한 직원 조회
-- 이상, 이하 (포함)
-- 이전, 이후 (포함)
-- '10000' -> 10000 자동으로 변환
-- '05/01/30' -> to_data('05/01/30') 자동으로 날짜로 변환
select *
from employees
where salary >= 10000
and commission_pct is not null
and job_id = 'SA_REP'
and hire_date >= '05/01/30';

-- not을 나타내는 방법 3가지
select *from employees
where not department_id = 80;

select *from employees
where department_id <> 80;

select *from employees
where department_id != 80;

-- 급여가 10000이상 20000이하
select *from employees
where salary >= 10000 and salary <= 20000;

select *from employees
where salary between 10000 and 20000;

-- 부서가 60,90,100인 직원 조회
select *from employees
where department_id = 60 or department_id = 90 or department_id = 100;

select *from employees
where department_id in (60, 90, 100);

-- 부서가 60,90,100이 아닌 직원 조회
select *from employees
where department_id <> 60 or department_id <> 90 or department_id <> 100;

select *from employees
where department_id not in (60, 90, 100);

-- LIKE
-- % : 하나 이상의 임의의 문자
-- _ : 하나의 임의의 문자
select *from employees
where first_name like 'S%';

select *from employees
where first_name like '%an%';

select *from employees
where first_name like '%e';

select *from employees
where first_name like '_____';

select *from employees
where first_name like '_____a';

select *from employees
where first_name not like '_a%';

-- SCOTT
select * from emp
where mgr is null;

select *from employees
where manager_id is null;

-- ORDER BY
-- asc(ascending) 생략가능
-- desc(descending)
-- oracle에서는 asc일때 null은 마지막에 나온다.
-- nulls first 사용하면 null이 처음에 나온다. nulls last는 맨 뒤에
select *from employees
where manager_id is not null
order by commission_pct nulls first;

select *from employees
where manager_id is not null
order by commission_pct desc nulls last;



