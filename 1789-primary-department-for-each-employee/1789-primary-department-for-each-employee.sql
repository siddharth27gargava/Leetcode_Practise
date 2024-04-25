# Write your MySQL query statement below

-- Retrieving employees with flag as Y UNION Retrieving employees that appear once
select employee_id, department_id
from employee
group by employee_id
having count(employee_id) = 1
UNION
select employee_id, department_id
from employee
where primary_flag = 'Y';
