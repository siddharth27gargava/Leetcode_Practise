# Write your MySQL query statement below
select query_name,
round((avg(rating/position)),2) AS quality,
round(((sum(rating<3)/count(rating)) * 100),2) AS poor_query_percentage
from queries
where query_name is not null
group by query_name;
