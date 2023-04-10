BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO genre (genre_name)
VALUES ('rap'),('rock'),('hip-hop'),('classical'),
('electronic'),('jazz'),('blues'),(' country'), ('pop'),('alternative'), ('anime'),('funk');

INSERT INTO mood (mood_name)
VALUES ('happy'), ('sad'),('angry'), ('romantic'),
('silly'), ('unhinged'), ('motivated'), ('chill'), ('workout');

INSERT INTO song(title, artist)
VALUES ('Swan Lake', ' Pyotr Ilyich Tchaikovsky'),
('Light of the Seven','Ramin Djawadi'),('Dance of the Knights', 'Sergei Prokofiev'),
('The Four Seasons of Buenos Aires', 'Astor Piazzolla'),('Rust', 'Hans Zimmer'),('Toccata and Fugue D Minor', 'Johann Sebastian Bach'),
('Portals', 'Alan Silvestri'),('Time', 'Hans Zimmer'),('Trepak', ' Pyotr Ilyich Tchaikovsky')

INSERT INTO song_genre (song_id, genre_id)
VALUES (1,4),(2,4), (3,4), (4,4), (5,4) , (6,4), (7,4), (8,4), (9,4)
