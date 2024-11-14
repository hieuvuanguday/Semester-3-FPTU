SELECT TOP(10) e.first_name, e.last_name FROM employees e
LEFT JOIN jobs j ON e.job_id = j.job_id
WHERE e.employee_id NOT IN (SELECT m.employee_id AS Manager FROM employees e
							JOIN employees m ON e.manager_id = m.employee_id)
ORDER BY e.last_name ASC