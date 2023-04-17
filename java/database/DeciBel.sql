

SELECT * 
FROM song
JOIN song_genre ON song_genre.song_id = song.song_id
JOIN genre ON song_genre.genre_id = genre.genre_id;

SELECT *
FROM genre

INSERT INTO song_genre (song_id, genre_id)
VALUES (1,4),(2,4), (3,4), (4,4), (5,4) , (6,4), (7,4), (8,4), (9,4)

SELECT *
FROM playlist


DELETE FROM playlist_users
WHERE playlist_id = ?
DELETE FROM song_playlist
WHERE playlist_id = ?
DELETE FROM playlist
WHERE playlist_id = ?;
