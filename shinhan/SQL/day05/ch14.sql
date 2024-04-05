-- VIEW ������ ���̺�, select���� ����, view�� ���ؼ� table�� �̿�
-- or replace : �����ϸ� ��ü
-- noforce : ������ ������ �����Ұ�
-- force : ������ �������� ����
create or replace view emp_dept60_view
as
select * from employees where department_id = 60;

-- force�� ������ ����, �⺻�� no force
create or replace force view emp_dept60_view
as
select * from employees2 where department_id = 60;

select * from user_views;  -- ������ ���� �˻�, select���� ����Ǿ� ����

select * from emp_dept60_view;  -- view�� ���ؼ� ���� table�� data�� ��ȸ

update emp_dept60_view set salary = 9999 where employee_id = 107;
update emp_dept60_view set department_id = 90 where employee_id = 107;

select * from employees;
rollback;

-- with check option : ó�� ������ �� ������ ����
create or replace view emp_dept60_view
as
select * from employees where department_id = 60 with check option;
select * from emp_dept60_view;
update emp_dept60_view set department_id = 90 where employee_id = 107;  -- �μ��� �ٲ��� ����.

-- ������ �ٹ��ϴ� �μ��� �����̸��� ����Ͻÿ�
-- ������ sql���� ���� ���ȴٸ� view�� ����� ���´�. DML�� �Ұ�
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