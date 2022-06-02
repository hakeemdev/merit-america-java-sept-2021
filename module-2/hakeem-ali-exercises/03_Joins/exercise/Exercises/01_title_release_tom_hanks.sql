-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)
SELECT title, release_date
FROM movie
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
WHERE actor_id = 31;
