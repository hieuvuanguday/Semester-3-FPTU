SELECT v.invid, v.invdate, d.proid, d.quantity, d.price FROM  tblInvoices v
RIGHT JOIN tblInv_Detail d ON v.invid = d.invid
WHERE v.employeeid = 'S003';

