select * from tab;

desc employees;

-- *는 모든 컬럼을 의미
select * 
from employees;

select employees.*
from employees;

-- 칼럼 나열하기
select employee_id, first_name
from employees;

-- 별명주기, as는 생략 가능
select employee_id as 직원번호, first_name 직원이름
from employees;

-- 직원들이 근무하는 부서들
select DEPARTMENT_ID
from employees;

-- 중복 제거(distinct) - 모든 칼럼을 합쳐서 모두 중복인것만 중복으로 처리
-- null : 정의된 값이 없다. 부서 값이 없다.
select distinct DEPARTMENT_ID
from employees;

select distinct DEPARTMENT_ID, first_name, last_name
from employees;

-- 산순연산자 사용가능
select first_name, last_name, SALARY*12 연봉
from employees;

-- invalid identifier 유효하지 않은 식별자, 칼럼 이름이 틀림
-- table을 생성하면 Data Dictionary(data 사전)에 칼럼 이름이 대문자로 들어간다. (ORACLE)


-- 컬럼 이름이 ""사용가능 - 중간에 특수문자 넣을 때 사용
-- SQL에서 ""을 사용하면 식별자 이름이다. 소문자에는 사용 못함.
select first_name, "LAST_NAME", SALARY*12 "연 봉"
from employees;

-- 107번 연산함
select 10+20
from employees;

-- 한번만 할때 사용하는 table
desc dual;
select * from dual;

select 10+20, sysdate
from dual;

-- ||은 concat 연산자. 문자열을 연결
-- SQL문에서 ''은 값을 의미
select first_name, "LAST_NAME", SALARY*12 "연 봉", 10+20, LAST_NAME||' -> '||SALARY
from employees;

-- NULL은 값 비교, 계산 불가
-- nvl(,) : null인지 체크해서 값을 변경함
select first_name, last_name, commission_pct, 
    nvl(commission_pct,0)*SALARY
from employees;

-- null은 = 으로 값 비교 불가(is 사용), 계산불가 (null 참여한 계산 결과는 null), is 사용
select first_name, last_name, commission_pct, 
    nvl(commission_pct,0)*SALARY
from employees
where commission_pct is null;

select *
from employees
where department_id = null;

select *
from employees
where department_id is null;

select *
from employees
where department_id is not null;

select first_name, last_name, salary, commission_pct, nvl(commission_pct,0)*salary+salary "실제 급여"
from employees;

select first_name||' '||last_name as name, nvl(commission_pct,0)*salary+salary "급여"
from employees;

