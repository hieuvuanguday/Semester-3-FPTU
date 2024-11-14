SELECT v.employeeid, COUNT(v.customer) AS [Total amount] FROM tblInvoices v
GROUP BY v.employeeid;

