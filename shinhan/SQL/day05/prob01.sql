
-- sql1: 결제를 가장 많이한 가게
create table merchants (
    id number,
    name varchar2(50),
    business_id varchar2(50),
    tax_type varchar2(50),
    category_id number
);

drop table card_usages;

create table card_usages (
    id number,
    created_at date,
    category number,
    amount number,
    merchant_id number
);

insert into merchants values(3907,'KFC학동역','201-81-89723','일반과세자',1);
insert into merchants values(4989,'미켈 고깃집','785-49-00298','일반과세자',1);
insert into merchants values(6297,'뉴발란스 강남점','214-85-50334','일반과세자',6);
insert into merchants values(27052,'주식회사이마트몰','104-86-50432','일반과세자',2);
insert into merchants values(118009,'플라이앤컴퍼티(주)','211-88-57343','일반과세자',1);

insert into card_usages values(195772, to_date('2018-05-02 18:54:43', 'yyyy-mm-dd hh24:mi:ss'),0,2700,3907);
insert into card_usages values(2530342, to_date('2018-01-28 09:47:33', 'yyyy-mm-dd hh24:mi:ss'),0,12300,3907);
insert into card_usages values(899325, to_date('2018-08-03 16:57:36', 'yyyy-mm-dd hh24:mi:ss'),0,45000,4989);
insert into card_usages values(400811, to_date('2018-05-28 12:45:34', 'yyyy-mm-dd hh24:mi:ss'),0,4000,6297);
insert into card_usages values(743640, to_date('2018-07-07 11:47:17', 'yyyy-mm-dd hh24:mi:ss'),0,299000,27052);
insert into card_usages values(1052039, to_date('2018-08-15 13:40:01', 'yyyy-mm-dd hh24:mi:ss'),1,-12900,118009);
insert into card_usages values(1120840, to_date('2018-08-21 06:58:55', 'yyyy-mm-dd hh24:mi:ss'),0,20800,118009);


select * from merchants;
select * from card_usages;

select bb.id, bb.name, bb.amount
from (
        select merchants.id, merchants.name, aa.amount amount
        from (
                select merchant_id, sum(amount) amount
                from card_usages
                where category = 0
                group by merchant_id
                ) aa 
        join merchants on (aa.merchant_id = merchants.id)
        order by amount desc) bb
where rownum <= 4;


select bb.id, bb.name, bb.amount
from (
        select card.merchant_id id, m.name name, sum(amount) amount
        from card_usages card
        join merchants m on (card.merchant_id = m.id)
        where category = 0
        group by card.merchant_id, m.name) bb
where rownum <= 4;


-- sql2: 월급대비 매출
create table employees2 (
    id number,
    name varchar2(50),
    salary number,
    branch_id number
);

create table sellings (
    car_id number,
    employee_id number,
    created_at TIMESTAMP,
    price number
);
drop table sellings;

insert into employees2 values (1015, 'Vex', 900, 1);
insert into employees2 values (3317, 'Stephanie', 250, 3);
insert into employees2 values (3884, 'Audrina', 470, 1);
insert into employees2 values (3912, 'Courtney', 300, 2);

insert into sellings values (306, 3317, to_date('2016-07-19 12:40:54', 'yyyy-mm-dd hh24:mi:ss'), 500);
insert into sellings values (414, 3884, to_date('2016-07-17 07:53:19', 'yyyy-mm-dd hh24:mi:ss'), 1700);
insert into sellings values (537, 3317, to_date('2016-07-22 18:47:05', 'yyyy-mm-dd hh24:mi:ss'), 1600);
insert into sellings values (594, 3884, to_date('2016-12-02 19:33:28', 'yyyy-mm-dd hh24:mi:ss'), 700);
insert into sellings values (810, 3912, to_date('2016-07-09 03:09:21', 'yyyy-mm-dd hh24:mi:ss'), 4100);
insert into sellings values (900, 1015, to_date('2016-08-14 13:20:56', 'yyyy-mm-dd hh24:mi:ss'), 15300);

select * from employees2;
select * from sellings;

select emp.name, emp.salary
from sellings sell
join employees2 emp on (sell.employee_id = emp.id)
where sell.created_at between to_date('2016-07-01', 'yyyy-mm-dd') and to_date('2016-07-31', 'yyyy-mm-dd')
group by sell.employee_id, emp.name, emp.salary
having round(sum(sell.price)/emp.salary) <= 10
order by 2 desc, 1 asc;