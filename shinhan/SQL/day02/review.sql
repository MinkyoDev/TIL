select * from tab;

desc employees;

-- 조회 : select
-- 작성순서 : select-from-where-order by
-- 실행 순서 : from-where-select-order by

select employee_id, first_name, salary 급여
from employees
where salary >= 10000
order by salary;

select employee_id, first_name, salary 급여
from employees
where salary >= 10000
order by 1;  -- 컬럼이름, 별명, 컬럼번호 가능

select *
from employees
where salary >= 10000
and commission_pct is not null
and first_name like '____'
order by 2;