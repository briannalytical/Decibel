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
('Portals', 'Alan Silvestri'),('Time', 'Hans Zimmer'),('Trepak', ' Pyotr Ilyich Tchaikovsky');

INSERT INTO song_genre (song_id, genre_id)
VALUES (1,4),(2,4), (3,4), (4,4), (5,4) , (6,4), (7,4), (8,4), (9,4);

INSERT INTO song_mood(song_id, mood_id)
VALUES (1,1), (2,2), (3,3),(4,4),(5,5), (6,6), (7,7), (8,8), (9,9);

INSERT INTO song(title, artist)
VALUES ('California Love', '2Pac, Roger, Dr. Dre'), ('Robery', 'Juice WRLD'),('XXXTENTACION','YuNg BrAtZ'), ('Mood Swings','Pop Smoke'),
('Bored In the House', 'Tyga, Curtise Roach'), ('Rocking a Cardigan in Atlanta', 'Lil Shordie Scott'),('Cowboy Bebop','A-Kil'),
('PWRDRL','Benny the Butcher, Elcamino'), ('X Gon Give It To Ya', 'DMX');

INSERT INTO song_genre (song_id, genre_id)
VALUES (10,1),(11,1), (12,1), (13,1), (14,1), (15,1), (16,1), (17,1), (18,1);

INSERT INTO song_mood (song_id, mood_id)
VALUES (10,1),(11,2), (12,3), (13,4), (14,5), (15,6), (16,7), (17,8), (18,9);

INSERT INTO song(title, artist)
	VALUES ('The Middle', 'Jimmy Eat World'),('Drag My Body', 'Hot Water Music'),('The Diary of Jane', 'Breaking Benjamin'),
	('River', 'Bishop Briggs'),('Stayin Alive', 'Les Claypools Duo De Twang'),('Top Drawer', 'Man Man'),('If U C My Enemies', 'Rubblebucket'),
	('Big Empty', 'Stone Temple Pilots'),('Lazy Boys Dash', 'Jimmies Chicken Shack');

INSERT INTO song_genre (song_id, genre_id)
VALUES (19,2),(20,2), (21,2), (22,2), (23,2) , (24,2), (25,2), (26,2), (27,2);

INSERT INTO song (title, artist)
VALUES ('Gold on the Ceiling','The Black Keys'),('Islands','Young the Giant'),('This is How I Disappar','My Chemical Romance'),
('I Would Do Anything For You','Foster the People'), ('Cherry Blossoms','Rubblebucket'), ('Nails For Breakfast, Tacks for Snacks','Panic At The Disco'),
('A Beautiful Lie','30 Seconds to Mars'), ('Middle of Nowhere','Hot Hot Heat'), ('Pretender','Foo Foo Fighters');

INSERT INTO song_genre (song_id, genre_id)
VALUES (28,10),(29,10), (30,10), (31,10), (32,10), (33,10), (34,10), (35,10), (36,10);

INSERT INTO song_mood (song_id, mood_id)
VALUES (28,1),(29,2), (30,3), (31,4), (32,5), (33,6), (34,7), (35,8), (36,9);