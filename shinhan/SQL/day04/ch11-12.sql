-- transaction : 하나의 논리적인 작업단위
select *
from employees
where department_id = 60
and job_id = 'IT_PROG'
and hire_date >= sysdate - 20*365
and salary >= 0;

insert into employees values(?,?,?,?,?,?,?,?,?,?,?);



-- ========= ch13 =========
-- foreign key : 외래키, 참조키, 다른 테이블의 pk를 참조한다.
-- default 값은 제약조건보다 앞부분에 정의한다.
drop table customer;
-- 칼럼 영역에서 제약조건 정의하기
create table customer (
    cust_id number constraint customer_cid_pk primary key,  -- primary key : not null + unique
    cust_name varchar2(30) not null,  -- 필수(반드시 입력)
    email varchar(20) constraint customer_email_uk unique,  -- 유일한 값, null 가능
    deptid number constraint customer_deptid_fk references departments (department_id),  -- 참조키, 반드시 부모키가 존재해야 한다.
    point2 number constraint customer_point_check check (point2 > 0),  -- check 조건을 만족해야 함.
    gender char(3) default '남' constraint customer_gender_check check (gender in ('남','여'))   -- 한글 1자는 3btye
);

-- 테이블 레벨에서 제약조건 정의하기
create table cutomer2 (
    cust_id number, 
    cust_name varchar2(30),
    email varchar(20),
    deptid number,
    point2 number,
    gender char(3),
    constraint customer_cid_pk2 primary key(cust_id),
    constraint customer_email_uk2 unique(cust_name),
    constraint customer_deptid_fk2 foreign key(deptid) references departments (department_id),
    constraint customer_point_check2 check (point2 > 0),
    constraint customer_gender_check2 check (gender in ('남','여'))
);


insert into customer(cust_id, cust_name) values (1, '김길동');
insert into customer(cust_id, cust_name) values (2, '김길동');
insert into customer(cust_id, cust_name, email) values (3, '김길동', 'aaaa');
insert into customer(cust_id, cust_name, email, deptid) values (4, '김길동', 'bbbb', 10);
insert into customer(cust_id, cust_name, email, deptid, point2) values (5, '김길동', 'bbbbx', 10, 100);
insert into customer(cust_id, cust_name, email, deptid, point2, gender) values (6, '김길동', 'bbbbsdx', 10, 100, '남');
select * from customer;

select * from user_constraints;