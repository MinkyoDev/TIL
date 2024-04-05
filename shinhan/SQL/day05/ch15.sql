-- sequence : 자동 번호 생성기 (오라클에만 있음), mysql에는 autoincrement가 있음.
-- 1부터 시작해서 1씩 증가
create sequence board_seq;

create table board(
    bno number constraint board_bno_PK primary key,
    title varchar2(50) not null,
    content varchar2(2000),
    writer varchar2(30),
    create_date date default sysdate
);

insert into board(bno, title) values (999, '금요일');
insert into board values (board_seq.nextval, '금요일', '꽃구경', 'min', sysdate);
delete from board where bno = 5;
select * from board;

select * from user_sequences;

select * from departments;
desc departments;
insert into departments values (DEPARTMENTS_SEQ.nextval, 'test', null, null);
