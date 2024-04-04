-- transaction : �ϳ��� ������ �۾�����
select *
from employees
where department_id = 60
and job_id = 'IT_PROG'
and hire_date >= sysdate - 20*365
and salary >= 0;

insert into employees values(?,?,?,?,?,?,?,?,?,?,?);



-- ========= ch13 =========
-- foreign key : �ܷ�Ű, ����Ű, �ٸ� ���̺��� pk�� �����Ѵ�.
-- default ���� �������Ǻ��� �պκп� �����Ѵ�.
drop table customer;
-- Į�� �������� �������� �����ϱ�
create table customer (
    cust_id number constraint customer_cid_pk primary key,  -- primary key : not null + unique
    cust_name varchar2(30) not null,  -- �ʼ�(�ݵ�� �Է�)
    email varchar(20) constraint customer_email_uk unique,  -- ������ ��, null ����
    deptid number constraint customer_deptid_fk references departments (department_id),  -- ����Ű, �ݵ�� �θ�Ű�� �����ؾ� �Ѵ�.
    point2 number constraint customer_point_check check (point2 > 0),  -- check ������ �����ؾ� ��.
    gender char(3) default '��' constraint customer_gender_check check (gender in ('��','��'))   -- �ѱ� 1�ڴ� 3btye
);

-- ���̺� �������� �������� �����ϱ�
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
    constraint customer_gender_check2 check (gender in ('��','��'))
);


insert into customer(cust_id, cust_name) values (1, '��浿');
insert into customer(cust_id, cust_name) values (2, '��浿');
insert into customer(cust_id, cust_name, email) values (3, '��浿', 'aaaa');
insert into customer(cust_id, cust_name, email, deptid) values (4, '��浿', 'bbbb', 10);
insert into customer(cust_id, cust_name, email, deptid, point2) values (5, '��浿', 'bbbbx', 10, 100);
insert into customer(cust_id, cust_name, email, deptid, point2, gender) values (6, '��浿', 'bbbbsdx', 10, 100, '��');
select * from customer;

select * from user_constraints;