# Write your MySQL query statement below
DELETE p1
From person p1, person p2
where p1.email = p2.email AND p1.ID > p2.ID;