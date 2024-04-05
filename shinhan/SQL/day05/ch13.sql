-- 급여를 가장 많이 받는 상위 5명 조회
select rownum, aa.*
from (
select first_name, salary
from employees
order by salary desc) aa
where rownum <= 6;

-- 급여를 가장 많이 받는 5번째 직원
select *
from (
        select rownum rr, aa.*
        from (
                select first_name, salary
                from employees
                order by salary desc) aa
        )
where rr = 5;

-- row_number() : 중복이 없이 전체 순위 지정
-- rank() : 중복이 있으면 중복 랭크를 제외하고 순서를 지정
-- dense_rank() : 중복랭크를 하나의 순서로 지정
select *
from (
select first_name, salary, 
row_number() over (order by salary desc) 랭크1,
rank() over (order by salary desc) 랭크2,
dense_rank() over (order by salary desc) 랭크3
from employees)
where rownum <= 5;

-- 테이블 복사 (employees -> emp_copy)
-- 테이블 복사 (department -> dept_copy) : 제약조건 중 not null만 복사됨
-- DDL(create table, drop table, rename, truncate, alter table) : 자동 커밋됨
create table emp_copy
as
select * from employees where department_id = 60;

select * from user_constraints where table_name = 'EMP_COPY';
select * from user_cons_columns where table_name = 'EMP_COPY';

select * from emp_copy;

-- 제약조건 추가하기
alter table emp_copy add constraint emp_copy_empid_pk Primary key(employee_id);
alter table emp_copy add constraint emp_copy_deptid_fk foreign key (department_id) references dept_copy(department_id);

----------------------
create table dept_copy
as
select * from departments where manager_id is not null;

select * from dept_copy;

select * from user_constraints where table_name = 'DEPT_COPY';
select * from user_cons_columns where table_name = 'DEPT_COPY';

alter table dept_copy add constraint dept_copy_deptid_pk Primary key(department_id);

-- DML(insert, delete, update) : 저장확정 commit, 취소 rollback
insert into emp_copy values(108, 'aa', 'bb', 'cc', '444', sysdate, 'aa', 1000, null, 333, 100);
delete from emp_copy where department_id = 77;
commit;

-- 자식이 있는데 지우려 했을 때
alter table dept_copy drop constraint dept_copy_deptid_pk cascade;