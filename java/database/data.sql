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
INSERT INTO song(title, artist)
    VALUES ('Comic Sans', 'Audrey Nuna'), ('You Got Me','The Roots'), ('Close Your Eyes','Run The Jewels'),('Ego','Lucky Daye'),
    ('White and Nerdy','Weird Al Yankovic'), ('Bar Breaker','Prof'), ('Forgiveless','SZA'), ('Enecs Eht No Kcab','One Be Lo'), ('Ziggy Starfish','Open Mic Eagle');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (37,3), (38,3), (39,3), (40,3), (41,3), (42,3), (43,3), (44,3), (45,3);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (37,1), (38,2), (39,3), (40,4), (41,5), (42,6), (43,7), (44,8), (45,9);
INSERT INTO song(title, artist)
    VALUES ('Pop It', 'Anamanaguchi'), ('Oceans Away','A R I Z O N A'), ('Techno','Destructo'), ('Into Your Eyes 1985','Kiile'),
    ('A Thousand Miles','DJ Speedo'), ('Strangeprogram','DJ Sharpnel'), ('Zion','Savant'), ('Epoch','Tycho'), ('Tom Tom','Holy Fuck');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (46,5), (47,5), (48,5), (49,5), (50,5), (51,5), (52,5), (53,5), (54,5);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (46,1), (47,2), (48,3), (49,4), (50,5), (51,6), (52,7), (53,8), (54,9);
INSERT INTO song(title, artist)
    VALUES ('When I Get Low I Get High', 'Ella Fitzgerald'), ('Stormy Weather','Etta James'), ('Attention!','Kyotaro & Rikuo'), ('All Of Me','Billie Holiday'),
    ('Little Spanish Flea','Herp Albert and the Tijuana Brass'), ('Mii Channel','The OneUps'),
    ('Seven Minute Mind','The Bad Plus'), ('In A Sentimental Mood','Duke Ellington & John Coltrane'), ('Talkin Bout','Too Many Zooz');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (55,6), (56,6), (57,6), (58,6), (59,6), (60,6), (61,6), (62,6), (63,6);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (55,1), (56,2), (57,3), (58,4), (59,5), (60,6), (61,7), (62,8), (63,9);
INSERT INTO song(title, artist)
    VALUES ('Juke Box Mama', 'Link Wray'), ('Hurt','Johnny Cash'), ('Graves','Whisky Shivers'), ('Deep Love','Lady Lamb'),
    ('Too Fat To Fly','Roger Alan Wade'), ('Methhead','Ian Noe'), ('Snake Song','Isobel Campbell'),
    ('Big Boss Man','Whitehorse'), ('Sleeping on the Blacktop','Colter Wall');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (64,7), (65,7), (66,7), (67,7), (68,7), (69,7), (70,7), (71,7), (72,7);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (64,1), (65,2), (66,3), (67,4), (68,5), (69,6), (70,7), (71,8), (72,9);
INSERT INTO song(title, artist)
    VALUES ('Outskirts of Heaven', 'Warren Zeiders'), ('Youre Gonna Miss This','Trace Adkins'), ('He Went To Jared','Morgan Wallen'),
    ('Die A Happy Man','Thomas Rhett'), ('Fuck You Bitch','Wheeler Walker Jr.'), ('February 28, 2016','Koe Wetzel'),
    ('The Railroad','Goodnight, Texas'), ('Hope Again','Zach Bryan'), ('Hard Row To Hoe','Brother Dege');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (73,8), (74,8), (75,8), (76,8), (77,8), (78,8), (79,8), (80,8), (81,8);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (73,1), (74,2), (75,3), (76,4), (77,5), (78,6), (79,7), (80,8), (81,9);
INSERT INTO song(title, artist)
    VALUES ('Party in the USA', 'Miley Cyrus'), ('Heartbreak on the Dancefloor','SG Lewis'), ('Needed Me','Rihanna'),
    ('Electric','Alina Baraz'), ('Light a Roman Candle with Me','fun.'), ('Aint Shit','Doja Cat'), ('Hot Girl Summer','Megan Thee Stallion & Nicki Minaj'),
    ('All My Friends','Snakehips'), ('Work Bitch','Britney Spears');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (82,9), (83,9), (84,9), (85,9), (86,9), (87,9), (88,9), (89,9), (90,9);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (82,1), (83,2), (84,3), (85,4), (86,5), (87,6), (88,7), (89,8), (90,9);
INSERT INTO song(title, artist)
    VALUES ('lost in Paradise', 'ALI'), ('Struggle of Sadness','Hakusho'), ('Come Forth','Negatone'), ('Log Horizon','Leisiel'),
    ('TRASH CANDY','GRANRODEO'), ('Makimas Theme','Kensuke Yoneszu'), ('Kaikai Kitan','Eve'),
    ('Believe','Soushi Sakiyama'), ('Kick Back','Kensuke Yoneszu');
INSERT INTO song_genre (song_id, genre_id)
    VALUES (91,11), (92,11), (93,11), (94,11), (95,11), (96,11), (97,11), (98,11), (99,11);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (91,1), (92,2), (93,3), (94,4), (95,5), (96,6), (97,7), (98,8), (99,9);
INSERT INTO song(title, artist)
    VALUES ('Sparkle', 'Tetsuro Yamashita'), ('Colors','Black Pumas'), ('In Plain Sight','Kraak & Smaak'), ('Beauty and Essence','Free Nationals'),
    ('Aint Nobody Like You','Yung Bae'), ('Brick House','Commodores'), ('People Get Up and Drive Your Funky Soul','James Brown'),
    ('The Rubber Band Man','The Spinners'), ('Jungle Boogie','Kool & The Gang');
	
INSERT INTO song_genre (song_id, genre_id)
    VALUES (100,12), (101,12), (102,12), (103,12), (104,12), (105,12), (106,12), (107,12), (108,12);
INSERT INTO song_mood (song_id, mood_id)
    VALUES (100,1), (101,2), (102,3), (103,4), (104,5), (105,6), (106,7), (107,8), (108,9);
INSERT INTO playlist (playlist_name,playlist_url)
VALUES ('Angry','https://open.spotify.com/embed/playlist/37i9dQZF1EIhuCNl2WSFYd?utm_source=generator&theme=0'),
('Sad','https://open.spotify.com/embed/playlist/37i9dQZF1EIg6gLNLe52Bd?utm_source=generator&theme=0'),
('Happy','https://open.spotify.com/embed/playlist/37i9dQZF1EIgG2NEOhqsD7?utm_source=generator&theme=0'),
('Workout','https://open.spotify.com/embed/playlist/37i9dQZF1EIgSjgoYBB2M6?utm_source=generator&theme=0'),
('Silly','https://open.spotify.com/embed/playlist/4OEt6ybaV4mNhOaxt95I9y?utm_source=generator&theme=0'),
('Unhinged','https://open.spotify.com/embed/playlist/2Gn3C608EeMG0P1JPgUGAI?utm_source=generator&theme=0'),
('Romantic','https://open.spotify.com/embed/playlist/37i9dQZF1EIfISqpNhcAN8?utm_source=generator&theme=0'),
('Motivated','https://open.spotify.com/embed/playlist/37i9dQZF1EIh4zcdX2LJPS?utm_source=generator&theme=0'),
('Chill','https://open.spotify.com/embed/playlist/37i9dQZF1EIelivQWnxTte?utm_source=generator&theme=0');
INSERT INTO playlist_users (playlist_id, user_id)
VALUES (1,1), (2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1);
INSERT INTO song_playlist (song_id, playlist_id)
 VALUES (100,2), (101,2), (102,2), (103,2), (104,2), (105,2), (106,2), (107,2), (108,2);
 INSERT INTO playlist_mood (playlist_id, mood_id)
    VALUES (1,3), (2,2),(3,1), (4,9), (5, 5), (6, 6),
	(7, 4), (8, 7), (9, 8);