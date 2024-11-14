SELECT np3.invid, np3.[Total amount] FROM (SELECT np.invid, SUM(np.Amount) AS [Total amount] 
				FROM (SELECT d.invid, d.proid, (d.quantity*d.price) AS [Amount] FROM tblInv_Detail d) AS np
				GROUP BY np.invid) np3
WHERE np3.[Total amount] = (SELECT MAX(np2.[Total amount]) AS [Total amount] FROM (SELECT np.invid, SUM(np.Amount) AS [Total amount] 
				FROM (SELECT d.invid, d.proid, (d.quantity*d.price) AS [Amount] FROM tblInv_Detail d) AS np
				GROUP BY np.invid) np2);






