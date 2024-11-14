SELECT p.proid, p.proname, s.supname FROM tblProducts p
LEFT JOIN tblSuppliers s ON p.supcode = s.supcode
WHERE s.supcode = 'Hoàn Vũ';