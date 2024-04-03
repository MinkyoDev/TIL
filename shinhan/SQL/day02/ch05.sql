-- 연산 한번 하는데 바람직하지 않음
select DISTINCT 10+20
from employees;

-- dual의 소유자는 sys, sys가 공개한 것
-- 1건의 데이터를 조회해야 하는 경우 사용
desc dual;

select * from dual;

select 10+20, sysdate
from dual;


-- 숫자 함수
select 12.5, round(12.5) 반올림, round(12.567, 2) "반올림(소수 2자리)", floor(12.56) 버림, ceil(12.567) 올림, mod(10,3)
from dual;

-- 문자 함수
-- concat은 다른 db에도 있음, ||연산자는 Oracle에만, MySQL은 +
select first_name, upper(first_name), lower(first_name), initcap(email), substr(first_name,1), substr(first_name,1,3), length(first_name), first_name||' '||last_name, concat(first_name, last_name)
from employees;

-- SCOTT
desc emp;

-- ''으로 감싸면 대소문자를 구분함
select * from emp
where job = upper('manager');

-- 만약 job_id가 index로 만들어져 있다면 칼럼값을 조작하지 않는 것이 효율적
select * from employees
where job_id = upper('it_prog');

select * from employees
where lower(job_id) = lower('it_prog');

-- manager들만 찾으려면
-- like 보다는 = 이 더 빠름
select * from jobs
where job_title like '%Manager';

select * from jobs
where substr(job_title, -7) = 'Manager';

select * from jobs
where substr(job_title, -7) = initcap('manager');

-- 12월에 입사한 직원들
select first_name, hire_date, substr(hire_date, 1, 2) 년도, substr(hire_date, 4, 2) 월, substr(hire_date, 7, 2) 일
from employees
--where hire_date like'__/12/__'
--where substr(hire_date, 4, 2) = 12;
where to_char(hire_date, 'mm') = 12;

-- 마지막 인덱스는 -1
select first_name, instr(first_name, 'e') "위치찾기", instr(first_name, 'e', 5) "5부터 위치찾기", instr(first_name, 'e', -2) "뒤에서부터 위치찾기", instr(first_name, 'e', 2, 2) "시작위치, 몇번째"
from employees;

-- LPAD : 왼쪽에 값 채우기, 자릿수가 넘으면 짤림
-- RPAD : 오른쪽에 값 채우기, 자릿수가 넘으면 짤림
select first_name, lpad(first_name,10,'*'), rpad(first_name,10,'*')
from employees;

-- LTRIM : 왼쪽 공백 제거
-- RTRIM : 오른쪽 공백 제거
-- TRIM : 양쪽 공백 제거
select '*'||ltrim('   Oracle   ')||'*', '*'||rtrim('   Oracle   ')||'*', '*'||trim('   Oracle   ')||'*'
from dual;

-- TRIM 특정 문자 제거
select trim('a' from 'aaaaaaOricleaaaaaa')
from dual;

select first_name, trim('A' from first_name)
from employees;

-- 날짜 계산
select first_name, hire_date, sysdate+1 내일, floor(sysdate-hire_date) 근무일수, floor(months_between(sysdate, hire_date)/12) 근무년수
from employees
order by 근무년수 desc;

select first_name, hire_date, add_months(hire_date, 6) "6개월 후", sysdate, add_months(sysdate, 6), last_day(hire_date), next_day(sysdate, '금'), to_char(hire_date, 'yyyy/mm/dd hh:mi:ss day d dy')
from employees;

-- mm: 일을 기준으로 반올림. 16일이 기준
select first_name, hire_date, round(hire_date, 'mm') "반올림(일)", trunc(hire_date, 'mm') "버림(일)"
from employees;

-- to_char : 날짜 -> 문자
-- mm : 월 / mon: 월까지 나옴
select to_char(sysdate, 'yyyy/mm/dd hh:mi:ss day d dy'), to_char(sysdate, 'yyyy/mon/dd hh:mi:ss day d dy'), to_char(sysdate, 'yyyy/mm/dd hh:mi:ss day d dy hh24 am/pm')
from dual;

-- to_char : 숫자 -> 문자 L붙이면 통화 단위 나옴
select to_char(10000, '99,999,999'), to_char(10000, 'L000,000,000.00')
from dual;

-- to_date
select *
from employees
where hire_date >= '05/01/01';

alter session set NLS_DATE_FORMAT = 'mm/dd/yyyy';

select *
from employees
where hire_date >= '01/01/2005';

select *
from employees
where to_char(hire_date, 'rr/mm/dd') >= '05/01/01';

alter session set NLS_DATE_FORMAT = 'RR/mm/dd';

-- nvl(colmn, null일때 대체값) : null 처리 함수
-- nvl(colmn, null일때 대체값, null일때)
select first_name, salary, nvl(to_char(commission_pct), '커미션 없음'), nvl2(commission_pct, to_char(commission_pct), '커미션 없음'), salary+salary*commission_pct 실수령액, salary+salary*nvl(commission_pct, 0) 실수령액,
nvl(to_char(department_id), '부서없음')
from employees
--where department_id is null
--where nvl(to_char(department_id), '부서없음') = '부서없음'
order by commission_pct nulls first;

-- coalesce
select first_name, commission_pct, department_id, coalesce(to_char(commission_pct), to_char(department_id), first_name) "null아닌 첫번째 칼럼값"
from employees;

-- decode는 =연산자가 생략된 것. 즉 =경우만 가능
-- case는 sql문에서 허용되는 모든 연산자 사용 가능
select first_name, salary, decode(salary, 24000, '매우많음', 17000, '많음', 12008, '적당', '적음') 급여평가, decode(length(first_name), 9, 'large', 8, 'middle', 'small') 이름길이,
    case when salary >= 2000 then '많음' 
    when salary < 2000 and salary >= 1000 then '적당' 
    when salary < 10000 and salary >= 5000 then '적음' 
    else '모자람' end 급여평가2, 
    job_id,
    decode(job_id, 'AD_PRES', 'A', 'AD_VP', 'A', 'IT_PROG', 'A', 'B') job2,
    case when job_id in('AD_PRES', 'AD_VP', 'IT_PROG') then 'A' else 'B' end job3
from employees;


