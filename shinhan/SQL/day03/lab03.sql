-- ========================================
--      		JOIN
-- ========================================

-- 1.�������� �̸��� ���޸�(job_title)�� ��ȸ�Ͻÿ�.
select first_name, job_title
from employees join jobs on (employees.job_id = jobs.job_id);


-- 2.�μ��̸��� �μ��� ���� ���ø�(city)�� ��ȸ�Ͻÿ�.
select department_name, city
from departments join locations on (departments.location_id = locations.location_id);


-- 3. ������ �̸��� �ٹ��������� ��ȸ�Ͻÿ�. (employees, departments, locations,countries)
select first_name, country_name
from employees 
join departments on (employees.department_id = departments.department_id) 
join locations on (departments.location_id = locations.location_id)
join countries on (locations.country_id = countries.country_id);
 

-- 4. ��å(job_title)�� 'manager' �� ����� �̸�, ��å, �μ����� ��ȸ�Ͻÿ�.
select first_name, job_title, department_name
from employees 
join jobs using (job_id)
join departments using (department_id)
--where lower(job_title) like '%manager';
where substr(jobs.job_title, -7) = initcap('manager');

-- 5. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�.
select first_name, hire_date, department_name
from employees 
join departments using (department_id);


-- 6. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�. ��, �μ��� ���� ������ �ִٸ� �� ���������� ��°���� ���Խ�Ų��.
select first_name, hire_date, department_name
from employees 
left outer join departments on (employees.department_id = departments.department_id);


-- 7. ������ �̸��� ��å(job_title)�� ����Ͻÿ�. ��, ������ �ʴ� ��å�� �ִٸ� �� ��å������ ��°���� ���Խ�Ű�ÿ�.
select first_name, job_title
from employees 
right outer join jobs on (employees.job_id = jobs.job_id);
 
select job_title, count(*)
from employees 
right outer join jobs on (employees.job_id = jobs.job_id)
group by job_title;

insert into jobs values('play', '������~', 50000, 60000);
commit;