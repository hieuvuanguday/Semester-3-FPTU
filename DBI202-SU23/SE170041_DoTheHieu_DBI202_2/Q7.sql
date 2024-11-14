SELECT c.country_id, c.country_name, COUNT(e.employee_id) AS [number of employee] FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
LEFT JOIN locations l ON d.location_id = l.location_id
LEFT JOIN countries c ON l.country_id = c.country_id
GROUP BY c.country_id, c.country_name
HAVING COUNT(e.employee_id) >= 2
ORDER BY COUNT(e.employee_id) DESC