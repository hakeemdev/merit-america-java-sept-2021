-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
INSERT INTO genre (genre_id, genre_name) 
VALUES (356, 'Sports');

INSERT INTO movie_genre (genre_id, movie_id)
VALUES (356, 7214);