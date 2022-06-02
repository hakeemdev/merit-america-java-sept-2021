-- Part one: Query for orders
SELECT c.last_name, c.first_name, c.street_address, s.sale_id, p.pizza_id, p.size_id, p.crust, p.sauce, pt.topping_name
FROM customer AS c
JOIN sale AS s ON c.customer_id = s.customer_id
JOIN pizza AS p ON s.sale_id = p.sale_id
LEFT JOIN pizza_topping AS pt ON p.pizza_id = pt.pizza_id
WHERE c.last_name = 'Mamwell' AND c.first_name = 'Elenore'
ORDER BY c.last_name, c.first_name, s.sale_id, p.pizza_id;

-- Part two: Add additional pizza


-- Part three: Change existing pizza


-- Part four: Remove additional pizza
