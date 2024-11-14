SELECT location_id, country_id, street_address, city
FROM locations
WHERE country_id IN ('CA', 'US')
ORDER BY country_id ASC;

