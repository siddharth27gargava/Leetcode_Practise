# Write your MySQL query statement below
select e2.reports_to as employee_id, e1.name, count(e1.employee_id) as reports_count, round(avg(e2.age),0) as average_age 
from employees e1
join employees e2
on e1.employee_id = e2.reports_to
group by e2.reports_to
order by e1.employee_id;
