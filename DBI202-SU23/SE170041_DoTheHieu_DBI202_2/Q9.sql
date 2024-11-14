CREATE PROCEDURE GET_ManagerID
(
	@id INT,
	@manager_id INT OUT
)
AS 
BEGIN
	SELECT @manager_id = employees.manager_id
	FROM dbo.employees 
	WHERE employees.employee_id = @id
END 




