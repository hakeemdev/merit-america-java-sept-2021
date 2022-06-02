-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

INSERT INTO collection (collection_id, collection_name)
VALUES (22141, 'Bill Murray Collection');

UPDATE movie SET collection_id = 22141
WHERE movie_id IN (
	SELECT movie_id FROM movie_actor
	WHERE actor_id = (
		SELECT person_id FROM person
		WHERE person_name = 'Bill Murray'));
