# Write your MySQL query statement below
SELECT W1.Id AS Id
FROM Weather AS W1
    JOIN 
    Weather AS W2
    ON DATEDIFF(W1.RecordDate, W2.RecordDate) = 1
WHERE W1.Temperature > W2.Temperature