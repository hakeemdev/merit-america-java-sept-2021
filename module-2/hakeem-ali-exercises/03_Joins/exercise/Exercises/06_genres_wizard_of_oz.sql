-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECT genre_name
FROM genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie ON movie.movie_id = movie_genre.movie_id
WHERE title = 'The Wizard of Oz';