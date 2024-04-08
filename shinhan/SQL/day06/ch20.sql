set SERVEROUTPUT on;

declare
    -- 스칼라타입
    v_empid number(10) := 100;
    v_fname varchar2(40);
    
    -- 참조타입
    v_empid2 employees.employee_id%type := 200;
    v_fname2 employees.first_name%type := '신한';
    
    -- 레코드
    v_empRecord employees%rowtype;
begin
    v_fname := '스티븐';
    dbms_output.put_line('-----------------');
    dbms_output.put_line('v_empid='||v_empid);
    dbms_output.put_line('v_fname='||v_fname);
    dbms_output.put_line('v_empid2='||v_empid2);
    dbms_output.put_line('v_fname2='||v_fname2);
    
    select first_name
    into v_fname
    from employees
    where employee_id = v_empid;
    
    select *
    into v_empRecord
    from employees
    where employee_id = v_empid2;
    
    dbms_output.put_line('v_fname='||v_fname);
    dbms_output.put_line('v_empRecord='||v_empRecord.first_name);
    dbms_output.put_line('v_empRecord='||v_empRecord.salary);
end;
/

-- dbms_output : 패키지 이름
-- put_line() : 함수, println과 같다.
-- "" : 식별자
-- '' : 값
-- / : 실행



declare
    -- 타입 정의
    type fnameType_table is table of employees.first_name%type index by binary_integer;
    -- 변수 선언
    fname_arr fnameType_table;
    -- 첨자를 선언
    idx binary_integer := 0;
begin
    for fnameRec in (select * from employees where department_id = 60) loop
    idx := idx + 1;
    fname_arr(idx) := fnameRec.first_name;
    dbms_output.put_line('fname_arr: '||fname_arr(idx)||'  first_name: '||fnameRec.first_name);
    end loop;
end;
/

-- 타입 정의 & IF문
declare
    -- 타입 정의
    type empRecordType is record(
        v_empid employees.employee_id%type,
        v_fname employees.first_name%type,
        v_salary number(8,2)
    );
    -- 변수 선언
    v_emp empRecordType;
    -- 첨자를 선언
    idx binary_integer := 0;
begin
    select employee_id, first_name, salary
    into v_emp
    from employees
    where employee_id = 100;
    
    dbms_output.put_line('직원번호: '||v_emp.v_empid);
    dbms_output.put_line('이름: '||v_emp.v_fname);
    dbms_output.put_line('급여: '||v_emp.v_salary);
    
    if (v_emp.v_salary > 30000) then
        dbms_output.put_line('급여 높음: '||v_emp.v_salary);
    else
        dbms_output.put_line('급여 낮음: '||v_emp.v_salary);
    end if;
end;
/

-- 반복문
declare
    i number := 1;
begin
    loop
        DBMS_OUTPUT.PUT_LINE ('i='||i);
        i := i + 1;
        if i>5 then
            DBMS_OUTPUT.PUT_LINE ('i는 5까지');
            exit;
        end if;
    end loop;
    DBMS_OUTPUT.PUT_LINE ('--------------');
    
    for j in reverse 1..5 loop
        DBMS_OUTPUT.PUT_LINE ('j='||j);
    end loop;
end;
/
