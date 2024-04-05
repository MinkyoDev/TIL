-- VIEW 가상의 테이블, select문만 저장, view를 통해서 table을 이용
-- or replace : 존재하면 대체
-- noforce : 컴파일 오류면 생성불가
-- force : 컴파일 오류여도 생성
create or replace view emp_dept60_view
as
select * from employees where department_id = 60;

-- force는 강제로 생성, 기본은 no force
create or replace force view emp_dept60_view
as
select * from employees2 where department_id = 60;

select * from user_views;  -- 데이터 사전 검사, select문이 저장되어 있음

select * from emp_dept60_view;  -- view를 통해서 실제 table의 data를 조회

update emp_dept60_view set salary = 9999 where employee_id = 107;
update emp_dept60_view set department_id = 90 where employee_id = 107;

select * from employees;
rollback;

-- with check option : 처음 생성된 뷰 데이터 유지
create or replace view emp_dept60_view
as
select * from employees where department_id = 60 with check option;
select * from emp_dept60_view;
update emp_dept60_view set department_id = 90 where employee_id = 107;  -- 부서가 바뀌지 않음.

-- 직원이 근무하는 부서의 나라이름을 출력하시오
-- 복잡한 sql문이 자주 사용된다면 view로 만들어 놓는다. DML은 불가
drop view emp_Country_view;
create view emp_Country_view
as
select employees.first_name, countries.country_name, region_id
from employees, departments, locations, countries
where employees.department_id = departments.department_id
and departments.location_id = locations.location_id
and locations.country_id = countries.country_id;

select * from user_views;
select * 
from emp_Country_view join regions using (region_id);