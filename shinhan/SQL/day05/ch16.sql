-- index(색인) : 목적은 검색속도 향상, 단점 : 만드는 시간 소요, 공간을 차지함
-- Oracle은 primary key가 자동으로 index로 만들어진다. 추가 가능
select *
from user_ind_columns where table_name = 'EMPLOYEES';

select * from employees
where first_name = 'Alexander';

select * from employees
where first_name = 'Steven';

-- index 설정한 칼럼을 조작하면 (함수사용) index는 사용되지 않게 됨을 주의
select * from employees
where initcap(first_name) = 'Alexander';

explain plan for
select * from employees
where first_name = 'Alexander';

explain plan for
select * from employees
where job_id = 'IT_PROG';

select * from table(DBMS_XPLAN.display);


-- index 있을 때와 없을 때 비교
create table emp_copy2  -- 구조 + data 복사, not null 말고 다른 제약조건은 복사 안됨.
as
select * from employees;

insert into emp_copy2 select * from employees;
insert into emp_copy2 select * from emp_copy2;
commit;
select count(*) from emp_copy2;

select * from emp_copy2;
insert into emp_copy2 values (2, 'aa','bb','zz','1212',sysdate,'IT',12345,null,null,null);

select * from emp_copy2 where employee_id = 2;
select * from emp_copy2 where first_name = 'aa';
set timing on;

create index emp_copy2_firstname_ix on emp_copy2(first_name);

