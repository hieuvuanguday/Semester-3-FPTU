SELECT p.proname, COUNT(d.quantity) AS [Total quantity] FROM tblProducts p
LEFT JOIN tblInv_Detail d ON p.proid = d.proid
WHERE p.proname = 'Router Wifi Chuẩn Wifi 6 AX5400 TP-Link Archer AX73'
GROUP BY p.proname;



