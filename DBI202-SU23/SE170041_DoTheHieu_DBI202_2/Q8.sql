CREATE TRIGGER Salary_Min_Max
ON employees
FOR UPDATE 
AS
BEGIN
	DECLARE @min DECIMAL(8,2)
	DECLARE @max DECIMAL(8,2)
	DECLARE @salary DECIMAL(8,2)
	SELECT @max = J.max_salary FROM jobs J, inserted INS WHERE J.job_id=INS.job_id
	SELECT @min = J.min_salary FROM jobs J, inserted INS WHERE J.job_id=INS.job_id
	SELECT @salary = INS.salary FROM inserted INS
	IF (@salary<@min or @salary>@max)
		BEGIN
			UPDATE employees 
			SET salary = DLT.salary
			FROM deleted DLT, inserted INS
			WHERE INS.employee_id=DLT.employee_id
		END

END




