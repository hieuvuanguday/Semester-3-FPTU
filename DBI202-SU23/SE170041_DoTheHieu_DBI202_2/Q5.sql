SELECT e.department_id, d.department_name, MIN(e.salary) AS [MIN(salary)] FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
GROUP BY e.department_id, d.department_name
ORDER BY MIN(e.salary) ASC;
