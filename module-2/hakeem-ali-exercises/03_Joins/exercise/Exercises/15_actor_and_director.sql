-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT person_name, title
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie.director_id = person.person_id AND movie.movie_id = movie_actor.movie_id;