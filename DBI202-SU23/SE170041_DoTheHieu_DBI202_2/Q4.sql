SELECT e.employee_id, CONCAT(e.first_name,' ',e.last_name) AS full_name, j.job_title, e.phone_number
FROM employees e 
LEFT JOIN jobs j ON e.job_id = j.job_id
WHERE j.job_title = 'Programmer' AND e.phone_number LIKE '590%'
