# Write your MySQL query statement below

SELECT DISTINCT a.num as ConsecutiveNums
FROM logs a
JOIN logs b ON a.id = b.id - 1 AND a.num = b.num
JOIN logs c ON a.id = c.id - 2 AND a.num = c.num;