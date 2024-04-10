# Write your MySQL query statement below
select uni.unique_id, emp.name
from Employees emp
LEFT JOIN EmployeeUNI uni
ON emp.id = uni.id;