CREATE PROCEDURE procProductnumber
(
	@supcode CHAR,
	@Productnumber INT OUTPUT
)
AS 
BEGIN
	SELECT @Productnumber = np.num FROM (SELECT dbo.tblProducts.supcode, COUNT(tblProducts.proid) AS num
											FROM dbo.tblProducts 
											WHERE tblProducts.supcode = @supcode
											GROUP BY dbo.tblProducts.supcode) AS np
	WHERE np.supcode = @supcode
END 
GO





