-- sequence : �ڵ� ��ȣ ������ (����Ŭ���� ����), mysql���� autoincrement�� ����.
-- 1���� �����ؼ� 1�� ����
create sequence board_seq;

create table board(
    bno number constraint board_bno_PK primary key,
    title varchar2(50) not null,
    content varchar2(2000),
    writer varchar2(30),
    create_date date default sysdate
);

insert into board(bno, title) values (999, '�ݿ���');
insert into board values (board_seq.nextval, '�ݿ���', '�ɱ���', 'min', sysdate);
delete from board where bno = 5;
select * from board;

select * from user_sequences;

select * from departments;
desc departments;
insert into departments values (DEPARTMENTS_SEQ.nextval, 'test', null, null);
