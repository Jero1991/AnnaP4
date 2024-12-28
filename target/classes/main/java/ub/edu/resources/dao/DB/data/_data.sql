INSERT INTO Persona (correuElectronic, contrasenya, identificador, mobil, icona, nomPerfil)
VALUES ('client1@example.com', 'password1', 'client123', '+1234567890', 'client1.jpg', 'Joan Cantimpalo');

INSERT INTO Persona (correuElectronic, contrasenya, identificador, mobil, icona, nomPerfil)
VALUES ('client2@example.com', 'password2', 'client456', '+9876543210', 'client2.jpg', 'Maria Martorell');

INSERT INTO Persona (correuElectronic, contrasenya, identificador, mobil, icona, nomPerfil)
VALUES ("ajaleo@gmail.com", "password", "client-1", "+123456678", "client2.jpg", "John Doe");

INSERT INTO Persona (correuElectronic, contrasenya, identificador, mobil, icona, nomPerfil)
VALUES ("dtomacal@yahoo.cat", "password", "client-2", "+123456678", "client2.jpg", "John Doe");

INSERT INTO Persona (correuElectronic, contrasenya, identificador, mobil, icona, nomPerfil)
VALUES ("heisenberg@gmail.com", "password", "client-3", "+123456678", "client2.jpg", "John Doe");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (1, "Sci-Fi Lovers", "For those who love science fiction");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (2, "Action Heroes", "For fans of action-packed movies and series");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (3, "High Drama", "For those who love dramatic stories");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (4, "Thriller Seekers", "For those who love suspense and thrill");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (5, "Fantasy Realm", "For fans of magical and fantastical worlds");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (6, "Horror Fans", "For those who love to be scared");

INSERT INTO GrupInteres (id, nomGrup, descripcio)
VALUES (7, "Romantic Souls", "For those who love a good love story");

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (1, 'Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.', 'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg', 2010, 'English, Japanese, French', 148, 88.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (2, 'Interstellar', 'When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.', 'https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg', 2014, 'English', 169, 87.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (3, 'The Matrix', 'When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.', 'https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg', 1999, 'English', 136, 87.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (4, 'The Shawshank Redemption', 'Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.', 'https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_SX300.jpg', 1994, 'English', 142, 93.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (5, 'The Godfather', 'Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.', 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg', 1972, 'English, Italian, Latin', 175, 92.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (6, 'The Dark Knight', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg', 2008, 'English, Mandarin', 152, 90.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (7, 'Avengers: Endgame', 'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos'' actions and restore balance to the universe.', 'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg', 2019, 'English, Japanese, Xhosa, German', 181, 84.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (8, 'Avatar', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.', 'https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzRiXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg', 2009, 'English, Spanish', 162, 79.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (9, 'Parasite', 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.', 'https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg', 2019, 'Korean, English', 132, 85.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (10, 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster, and his wife intertwine in four tales of violence and redemption.', 'https://m.media-amazon.com/images/M/MV5BMTM2OTk5NTY2Nl5BMl5BanBnXkFtZTcwNTM0OTM0NQ@@._V1_SX300.jpg', 1994, 'English, French', 154, 94.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (11, 'Joker', 'In Gothams fractured society, a man disregarded by everyone transforms into the criminal mastermind known as Joker.', 'https://m.media-amazon.com/images/M/MV5BMzM0YWI2YTUtN2E1NC00MTRjLWEwNzEtMzhiNmQ0MTY3OTFhXkEyXkFqcGdeQXVyMTEzMTI2NzIz._V1_SX300.jpg', 2019, 'English', 122, 85.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (12, 'The Lord of the Rings: The Fellowship of the Ring', 'A young hobbit, Frodo, who has found the One Ring that belongs to the Dark Lord Sauron, begins his journey to Mount Doom to destroy the ring and save Middle-earth.', 'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg', 2001, 'English', 178, 91.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (13, 'Forrest Gump', 'Forrest Gump, a man with a low I.Q., joins the army for service in Vietnam, where he wins medals, creates a famous shrimp fishing fleet, inspires people to jog, and more.', 'https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWI5YzctMzYxYThmMzU4MmMwXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 1994, 'English', 142, 88.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (14, 'The Silence of the Lambs', 'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.', 'https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmYtZGNkMmU1ZDUxZjA2XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg', 1991, 'English', 118, 86.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (15, 'The Shining', 'A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future.', 'https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjktZjIwM2QwOTU4YzJkXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg', 1980, 'English', 146, 84.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (16, 'The Departed', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.', 'https://m.media-amazon.com/images/M/MV5BMTI1MTY2OTIxNV5BMl5BanBnXkFtZTYwNjQ4NjY3._V1_SX300.jpg', 2006, 'English', 151, 91.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (17, 'The Green Mile', 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.', 'https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwNjQ4NjY3._V1_SX300.jpg', 1999, 'English', 189, 86.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (18, 'The Prestige', 'After a tragic accident, two stage magicians engage in a battle to create the ultimate illusion while sacrificing everything they have to outwit each other.', 'https://picsum.photos/200/200/', 2006, 'English', 130, 85.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (19, 'The Social Network', 'As Harvard student Mark Zuckerberg creates the social networking site that would become known as Facebook, he is sued by the twins who claimed he stole their idea, and by the co-founder who was later squeezed out of the business.', 'https://picsum.photos/200/200/', 2010, 'English', 120, 78.0);

INSERT INTO Pelicula (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (20, 'The Grand Budapest Hotel', 'A writer encounters the owner of an aging high-class hotel, who tells him of his early years serving as a lobby boy in the hotel''s glorious years under an exceptional concierge.', 'https://picsum.photos/200/200/', 2014, 'English, French', 99, 87.0);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (1, "Stranger Things", "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces and one strange little girl.", "https://picsum.photos/200/200/", 2016, "English", 2142, 8.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (2, "Game of Thrones", "A series about the fight for the Iron Throne", "https://picsum.photos/200/200/", 2011, "English", 4161, 10);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (3, "The Crown", "The reign of Queen Elizabeth II", "https://picsum.photos/200/200/", 2016, "English", 3480, 3.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (4, "The Mandalorian", "A lone gunfighter makes his way through the galaxy", "https://picsum.photos/200/200/", 2019, "English", 960, 8.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (5, "The Witcher", "The tale of Geralt of Rivia, a solitary monster hunter", "https://picsum.photos/200/200/", 2019, "English", 1500, 8.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (6, "Breaking Bad", "A high school teacher turned methamphetamine manufacturer", "https://picsum.photos/200/200/", 2008, "English", 3038, 8.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (7, "The Office", "A mockumentary on a group of office workers", "https://picsum.photos/200/200/", 2005, "English", 4136, 9);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (8, "Friends", "Follows the lives of six friends living in Manhattan", "https://picsum.photos/200/200/", 1994, "English", 5148, 3.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (9, "The Big Bang Theory", "A group of nerds and their interactions with a waitress", "https://picsum.photos/200/200/", 2007, "English", 6160, 8.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (10, "Chernobyl", "A series about the Chernobyl nuclear disaster", "https://picsum.photos/200/200/", 2019, "English", 330, 1.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (11, "Peaky Blinders", "A gangster family in Birmingham, England, in 1919", "https://picsum.photos/200/200/", 2013, "English", 2160, 4.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (12, "Westworld", "A futuristic theme park allows visitors to live out fantasies with android hosts.", "https://picsum.photos/200/200/", 2016, "English", 2400, 7.5);

INSERT INTO Serie (id, titol, descripcio, imatge, anyPrimeraEmissio, idioma, durada, valoracio)
VALUES (13, "Black Mirror", "An anthology series exploring a twisted, high-tech multiverse.", "https://picsum.photos/200/200/", 2011, "English", 1200, 8.8);

-- Stranger Things (Season 1 continuation)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (21, 1, 9, "Chapter Nine: The Return", 2016, 52, "English", "The group deals with the aftermath of their Upside Down journey.", "https://picsum.photos/200/200/", 76.0);

-- Game of Thrones (Season 1 continuation)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (22, 6, 2, "The Kingsroad", 2011, 56, "English", "Ned Stark travels to King's Landing to serve as the Hand of the King.", "https://picsum.photos/200/200/", 80.0);

-- The Crown (New Season for The Crown)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (13, 3, 2, 2017, 8.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (23, 13, 1, "Misadventure", 2017, 58, "English", "Queen Elizabeth navigates political scandals.", "https://picsum.photos/200/200/", 75.0),
       (24, 13, 2, "A Company of Men", 2017, 60, "English", "The crown's power is questioned in turbulent times.", "https://picsum.photos/200/200/", 74.0);

-- The Witcher (New Episodes for Season 1)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (25, 8, 2, "The Last Wish", 2019, 58, "English", "Geralt meets Yennefer while hunting a Djinn.", "https://picsum.photos/200/200/", 80.0),
       (26, 8, 3, "Betrayer Moon", 2019, 55, "English", "Geralt faces a striga curse in Temeria.", "https://picsum.photos/200/200/", 82.0);

-- Black Mirror (Additional Season 2 Episodes)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (27, 12, 4, "Nosedive", 2016, 60, "English", "A woman obsessed with her social rating faces a series of challenges.", "https://picsum.photos/200/200/", 87.0),
       (28, 12, 5, "Playtest", 2016, 55, "English", "A traveler volunteers for an experimental augmented reality game.", "https://picsum.photos/200/200/", 86.0);

-- Westworld (Additional Season 1 Episodes)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (29, 9, 2, "Chestnut", 2016, 60, "English", "A new guest arrives at Westworld seeking adventure.", "https://picsum.photos/200/200/", 81.0),
       (30, 9, 3, "The Stray", 2016, 59, "English", "Tensions rise as a host strays from its narrative.", "https://picsum.photos/200/200/", 82.0);

-- Peaky Blinders (New Episodes for Season 1)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (31, 8, 2, "Episode 2", 2013, 57, "English", "Tommy Shelby expands his influence in Birmingham.", "https://picsum.photos/200/200/", 79.0),
       (32, 8, 3, "Episode 3", 2013, 56, "English", "Tommy faces threats from rival gangs.", "https://picsum.photos/200/200/", 80.0);

-- Breaking Bad (Additional Episodes for Season 1)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (33, 6, 2, "Cat's in the Bag...", 2008, 48, "English", "Walt and Jesse deal with the aftermath of their first cook.", "https://picsum.photos/200/200/", 83.0),
       (34, 6, 3, "...And the Bag's in the River", 2008, 47, "English", "Walt faces the consequences of his choices.", "https://picsum.photos/200/200/", 84.0);

-- Friends (Extra Episode for Fun)
INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (35, 1, 10, "The One with the Extra Episode", 1994, 23, "English", "The gang gets caught up in a misunderstanding.", "https://picsum.photos/200/200/", 74.0);

-- Adding Temporadas and Episodes for series without them

-- The Mandalorian (Adding Season 1 and Episodes)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (14, 4, 1, 2019, 8.5);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (36, 14, 1, "Chapter One: The Mandalorian", 2019, 39, "English", "A bounty hunter tracks a valuable asset.", "https://picsum.photos/200/200/", 85.0),
       (37, 14, 2, "Chapter Two: The Child", 2019, 32, "English", "The Mandalorian protects a mysterious infant.", "https://picsum.photos/200/200/", 87.0),
       (38, 14, 3, "Chapter Three: The Sin", 2019, 38, "English", "The Mandalorian faces a moral dilemma.", "https://picsum.photos/200/200/", 88.0);

-- The Witcher (Adding a new season, Season 2)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (15, 5, 2, 2021, 8.7);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (39, 15, 1, "A Grain of Truth", 2021, 58, "English", "Geralt encounters a cursed nobleman and his secrets.", "https://picsum.photos/200/200/", 90.0),
       (40, 15, 2, "Kaer Morhen", 2021, 59, "English", "Geralt takes Ciri to his witcher stronghold.", "https://picsum.photos/200/200/", 89.0);

-- The Office (Adding Season 1 and Episodes)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (16, 7, 1, 2005, 9.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (41, 16, 1, "Pilot", 2005, 22, "English", "Michael Scott welcomes a documentary crew to Dunder Mifflin.", "https://picsum.photos/200/200/", 82.0),
       (42, 16, 2, "Diversity Day", 2005, 22, "English", "Michael's insensitive behavior prompts a diversity seminar.", "https://picsum.photos/200/200/", 84.0),
       (43, 16, 3, "Health Care", 2005, 22, "English", "Michael delegates a tough task to Dwight.", "https://picsum.photos/200/200/", 85.0);

-- Friends (Adding Season 1 for completeness)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (17, 8, 1, 1994, 9.5);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (44, 17, 1, "The One Where Monica Gets a Roommate", 1994, 22, "English", "The friends navigate their lives in New York City.", "https://picsum.photos/200/200/", 88.0),
       (45, 17, 2, "The One with the Sonogram at the End", 1994, 22, "English", "Ross finds out his ex-wife is pregnant.", "https://picsum.photos/200/200/", 87.0);

-- The Big Bang Theory (Adding Season 1 and Episodes)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (18, 9, 1, 2007, 8.8);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (46, 18, 1, "Pilot", 2007, 22, "English", "Leonard and Sheldon meet their new neighbor, Penny.", "https://picsum.photos/200/200/", 90.0),
       (47, 18, 2, "The Big Bran Hypothesis", 2007, 21, "English", "Sheldon violates Penny's privacy with good intentions.", "https://picsum.photos/200/200/", 89.0);

-- Chernobyl (Adding Season 1 Episodes)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (19, 10, 1, 2019, 9.7);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (48, 19, 1, "1:23:45", 2019, 60, "English", "The Chernobyl disaster begins.", "https://picsum.photos/200/200/", 92.0),
       (49, 19, 2, "Please Remain Calm", 2019, 61, "English", "Authorities deal with the fallout of the explosion.", "https://picsum.photos/200/200/", 94.0);

-- Peaky Blinders (Adding Season 1 Episodes)
INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (20, 11, 1, 2013, 8.5);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (50, 20, 1, "Episode 1", 2013, 55, "English", "Tommy Shelby returns from war to lead his family business.", "https://picsum.photos/200/200/", 85.0),
       (51, 20, 2, "Episode 2", 2013, 56, "English", "Tommy starts to expand his power.", "https://picsum.photos/200/200/", 87.0);


INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (1, 1, 1, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (2, 1, 2, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (3, 1, 3, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (4, 1, 4, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (5, 1, 5, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (6, 2, 1, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (7, 2, 2, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (8, 3, 1, 2005, 10);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (9, 12, 1, 2016, 8.2);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (10, 12, 2, 2018, 7.8);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (11, 13, 1, 2011, 9.0);

INSERT INTO Temporada (id, serie_id, numTemporada, anyEstrena, valoracio)
VALUES (12, 13, 2, 2016, 8.9);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (1, 1, 1, "Chapter One: The Vanishing of Will Byers", 2016, 47, "English", "Will Byers disappears and his friends investigate.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (2, 1, 2, "Chapter Two: The Weirdo on Maple Street", 2016, 50, "English", "Eleven helps Mike and his friends search for Will.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (3, 1, 3, "Chapter Three: Holly, Jolly", 2016, 51, "English", "Joyce discovers strange occurrences with her lights.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (4, 1, 4, "Chapter Four: The Body", 2016, 48, "English", "The boys suspect a cover-up after finding Wills body.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (5, 1, 5, "Chapter Five: The Flea and the Acrobat", 2016, 49, "English", "The group learns about alternate dimensions.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (6, 1, 6, "Chapter Six: The Monster", 2016, 50, "English", "The boys face off against a Demogorgon.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (7, 1, 7, "Chapter Seven: The Bathtub", 2016, 51, "English", "Eleven uses her powers to locate Will.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (8, 1, 8, "Chapter Eight: The Upside Down", 2016, 53, "English", "The group ventures into the Upside Down.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (9, 6, 1, "Winter Is Coming", 2011, 62, "English", "The Stark family faces new challenges in Winterfell.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (10, 7, 1, "The North Remembers", 2012, 53, "English", "Tensions rise as Robb Stark leads his army.", "https://picsum.photos/200/200/", 75.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (11, 9, 1, "The Original", 2016, 68, "English", "Visitors arrive at Westworld for their first day of adventure.", "https://picsum.photos/200/200/", 80.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (12, 11, 1, "The National Anthem", 2011, 44, "English", "A controversial blackmail scandal grips the UK.", "https://picsum.photos/200/200/", 85.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (13, 12, 1, "The Entire History of You", 2011, 49, "English", "In the near future, everyone has access to a memory implant that records everything they do, see and hear.", "https://picsum.photos/200/200/", 85.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (14, 12, 2, "Be Right Back", 2013, 55, "English", "Martha connects with her recently deceased boyfriend through a new technology.", "https://picsum.photos/200/200/", 85.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (15, 12, 3, "White Christmas", 2014, 73, "English", "In a remote cabin, Matt and Joe, former friends, share stories about how technology has evolved to change the way people interact.", "https://picsum.photos/200/200/", 90.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (16, 10, 1, "The Waldo Moment", 2013, 44, "English", "Jamie is a depressed, struggling comedian who uses a cartoon bear, Waldo, to enter politics.", "https://picsum.photos/200/200/", 85.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (17, 10, 2, "White Bear", 2013, 41, "English", "Victoria wakes up and cannot remember anything about her life. Everyone she encounters refuses to communicate with her.", "https://picsum.photos/200/200/", 85.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (18, 10, 3, "Shut Up and Dance", 2016, 52, "English", "When withdrawn Kenny stumbles headlong into an online trap, he is quickly forced into an uneasy alliance with shifty Hector, both at the mercy of persons unknown.", "https://picsum.photos/200/200/", 90.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (19, 11, 1, "San Junipero", 2016, 61, "English", "In a seaside town in 1987, a shy young woman and an outgoing party girl strike up a powerful bond that seems to defy the laws of space and time.", "https://picsum.photos/200/200/", 95.0);

INSERT INTO Episodi (id, temporada_id, numEpisodi, nom, anyEstrena, duracio, idioma, descripcio, url, valoracio)
VALUES (20, 12, 1, "USS Callister", 2017, 76, "English", "A woman wakes up on a Star Trek-esque ship where the crew praise their all-knowing and fearless captain.", "https://picsum.photos/200/200/", 92.0);

INSERT INTO Tematica (id, nomTematica)
VALUES (1, "Sci-Fi");

INSERT INTO Tematica (id, nomTematica)
VALUES (2, "Drama");

INSERT INTO Tematica (id, nomTematica)
VALUES (3, "Comedy");

INSERT INTO Tematica (id, nomTematica)
VALUES (4, "Action");

INSERT INTO Tematica (id, nomTematica)
VALUES (5, "Horror");

INSERT INTO Tematica (id, nomTematica)
VALUES (6, "Thriller");

INSERT INTO Tematica (id, nomTematica)
VALUES (7, "Romance");

INSERT INTO Tematica (id, nomTematica)
VALUES (8, "Mystery");

INSERT INTO Tematica (id, nomTematica)
VALUES (9, "Crime");

INSERT INTO Tematica (id, nomTematica)
VALUES (10, "Animation");

INSERT INTO Tematica (id, nomTematica)
VALUES (11, "Fantasy");

INSERT INTO Tematica (id, nomTematica)
VALUES (12, "Historical");

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (1, 1);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (2, 1);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (3, 2);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (4, 3);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (5, 4);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (6, 5);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (7, 6);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (8, 7);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (9, 8);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (10, 9);

INSERT INTO Pelicula_Tematica (pelicula_id, tematica_id)
VALUES (11, 6);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (1, 1);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (2, 2);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (3, 2);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (4, 1);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (5, 8);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (6, 6);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (7, 3);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (8, 3);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (9, 3);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (10, 2);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (11, 9);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (12, 1);

INSERT INTO Serie_Tematica (serie_id, tematica_id)
VALUES (13, 6);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (1, 1);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (1, 4);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (2, 4);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (3, 2);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (4, 6);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (4, 4);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (5, 10);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (5, 3);

INSERT INTO GrupInteres_Tematica (grup_id, tematica_id)
VALUES (5, 4);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (1, 1);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (2, 1);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (3, 1);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (4, 2);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (5, 3);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (6, 3);

INSERT INTO Serie_GrupInteres (serie_id, grup_id)
VALUES (7, 1);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (1, 1);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (2, 1);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (3, 1);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (4, 2);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (5, 3);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (6, 3);

INSERT INTO Pelicula_GrupInteres (pelicula_id, grup_id)
VALUES (7, 1);


INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (1, 3,"2024-11-11" );
INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (1, 1, "2024-11-11");
INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (2, 1, "2024-11-11");
INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (2, 3, "2024-11-11");
INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (3, 1, "2024-11-11");
INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (3, 2, "2024-11-11");
INSERT INTO Persona_Follower_GrupInteres (persona_id, grup_id, data)
VALUES (4, 3, "2024-11-11");

INSERT INTO Persona_Membre_GrupInteres (persona_id, grup_id, data, punts)
VALUES (1, 3, "2024-11-11", 90);

INSERT INTO Persona_Membre_GrupInteres (persona_id, grup_id, data, punts)
VALUES (2, 1, "2024-11-19", 78);

INSERT INTO Persona_Membre_GrupInteres (persona_id, grup_id, data, punts)
VALUES (3, 1, "2024-11-10", 10);

INSERT INTO Persona_Membre_GrupInteres (persona_id, grup_id, data, punts)
VALUES (4, 3, "2024-11-01", 100);


INSERT INTO Watched_Pelicula (persona_id, pelicula_id, data)
VALUES (3, 1, "01-09-2023 12:00:00");

INSERT INTO Watched_Pelicula (persona_id, pelicula_id, data)
VALUES (4, 1, "02-09-2023 12:32:00");

INSERT INTO Watched_Pelicula (persona_id, pelicula_id, data)
VALUES (5, 7, "03-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (3, 1, "01-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (4, 2, "11-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (5, 3, "11-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (3, 4, "11-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (4, 5, "11-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (5, 6, "11-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (3, 7, "01-10-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (4, 8, "28-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (5, 9, "28-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (3, 10, "15-09-2023 12:00:00");

INSERT INTO Watched_Serie (persona_id, serie_id, data)
VALUES (4, 11, "15-09-2023 12:00:00");

INSERT INTO Watched_Temporada (persona_id, temporada_id, data)
VALUES (4, 1, "28-09-2023 12:00:00");

INSERT INTO Watched_Temporada (persona_id, temporada_id, data)
VALUES (5, 3, "28-09-2023 12:00:00");

INSERT INTO Watched_Temporada (persona_id, temporada_id, data)
VALUES (3, 4, "15-09-2023 12:00:00");

INSERT INTO Watched_Temporada (persona_id, temporada_id, data)
VALUES (4, 2, "15-09-2023 12:00:00");

INSERT INTO Watched_Episodi (persona_id, episodi_id, data)
VALUES (4, 1, "28-09-2023 12:00:00");

INSERT INTO Watched_Episodi (persona_id, episodi_id, data)
VALUES (5, 3, "28-09-2023 12:00:00");

INSERT INTO Watched_Episodi (persona_id, episodi_id, data)
VALUES (3, 4, "15-09-2023 12:00:00");

INSERT INTO Watched_Episodi (persona_id, episodi_id, data)
VALUES (4, 2, "15-09-2023 12:00:00");



INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (1, 1.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (2, 2.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (3, 3.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (4, 4.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (5, 5.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (6, 6.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (7, 7.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (8, 8.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (9, 9.0);

INSERT INTO ValoracioPunts (id, puntuacio)
VALUES (10, 10.0);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (1, 1);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (2, 2);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (3, 3);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (4, 4);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (5, 5);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (6, 6);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (7, 7);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (8, 8);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (9, 9);

INSERT INTO ValoracioEstrelles (id, puntuacio)
VALUES (10, 10);

INSERT INTO ValoracioLikes (id, puntuacio)
VALUES (1, False);

INSERT INTO ValoracioLikes (id, puntuacio)
VALUES (2, True);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (6, 1, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (6, 2, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (6, 3, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (6, 4, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (6, 5, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (3, 6, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (3, 7, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (3, 8, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (3, 9, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (3, 10, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (9, 10, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (9, 9, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (9, 8, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (9, 7, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (9, 6, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (8, 5, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (8, 4, 2);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (8, 3, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (8, 2, 1);

INSERT INTO Pelicula_ValoracioPunts (pelicula_id, valoracio_id, persona_id)
VALUES (8, 1, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (1, 1, 1);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (2, 1, 1);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (3, 3, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (4, 3, 1);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (5, 5, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (6, 3, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (7, 3, 1);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (8, 3, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (9, 2, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (10, 1, 1);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (11, 2, 2);

INSERT INTO Pelicula_ValoracioEstrelles (pelicula_id, valoracio_id, persona_id)
VALUES (12, 4, 2);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (6, 1, 1);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (6, 2, 2);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (3, 1, 3);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (3, 2, 1);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (4, 1, 2);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (9, 1, 3);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (9, 2, 4);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (8, 1, 1);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (8, 2, 2);

INSERT INTO Pelicula_ValoracioLikes (pelicula_id, valoracio_id, persona_id)
VALUES (10, 2, 3);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (6, 1, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (6, 2, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (6, 3, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (6, 4, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (6, 5, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (3, 6, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (3, 7, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (3, 8, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (3, 9, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (3, 10, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (9, 10, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (9, 9, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (9, 8, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (9, 7, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (9, 6, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (8, 5, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (8, 4, 2);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (8, 3, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (8, 2, 1);

INSERT INTO Episodi_ValoracioPunts (episodi_id, valoracio_id, persona_id)
VALUES (8, 1, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (1, 1, 1);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (2, 1, 1);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (3, 3, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (4, 3, 1);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (5, 5, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (6, 3, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (7, 3, 1);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (8, 3, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (9, 2, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (10, 1, 1);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (4, 2, 2);

INSERT INTO Episodi_ValoracioEstrelles (episodi_id, valoracio_id, persona_id)
VALUES (2, 4, 2);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (6, 1, 1);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (6, 2, 2);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (3, 1, 3);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (3, 2, 1);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (4, 1, 2);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (9, 1, 3);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (9, 2, 4);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (8, 1, 1);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (8, 2, 2);

INSERT INTO Episodi_ValoracioLikes (episodi_id, valoracio_id, persona_id)
VALUES (10, 2, 3);

-- Data for the Pregunta table
INSERT INTO Pregunta (id, pregunta) VALUES
(1, 'Who directed the movie Inception?'),
(2, 'In which year was the movie The Matrix released?'),
(3, 'What is the name of the fictional continent in Game of Thrones?'),
(4, 'Which city does Spider-Man protect?'),
(5, 'What is the name of the wizarding school in Harry Potter?'),
(6, 'Who painted the Mona Lisa?'),
(9, 'Which planet is known as the Red Planet?'),
(10, 'What is the chemical symbol for water?');

-- Data for the Resposta table
INSERT INTO Resposta (id, pregunta_id, resposta, esCorrecta) VALUES
(1, 1, 'Christopher Nolan', TRUE),
(2, 1, 'Steven Spielberg', FALSE),
(3, 1, 'Quentin Tarantino', FALSE),
(4, 2, '1999', TRUE),
(5, 2, '2000', FALSE),
(6, 2, '1995', FALSE),
(7, 3, 'Westeros', TRUE),
(8, 3, 'Middle-Earth', FALSE),
(9, 3, 'Narnia', FALSE),
(10, 4, 'New York City', TRUE),
(11, 4, 'Metropolis', FALSE),
(12, 4, 'Gotham', FALSE),
(13, 5, 'Hogwarts', TRUE),
(14, 5, 'Durmstrang', FALSE),
(15, 5, 'Beauxbatons', FALSE),
(16, 6, 'Leonardo da Vinci', TRUE),
(17, 6, 'Michelangelo', FALSE),
(18, 6, 'Raphael', FALSE),
(25, 9, 'Mars', TRUE),
(26, 9, 'Jupiter', FALSE),
(27, 9, 'Venus', FALSE),
(28, 10, 'H2O', TRUE),
(29, 10, 'O2', FALSE),
(30, 10, 'CO2', FALSE);

-- Data for the GrupInteres_Categoria_Pregunta table
INSERT INTO GrupInteres_Categoria_Pregunta (grup_id, pregunta_id, categoria) VALUES
(1, 1, 'Movies'),
(1, 2, 'Movies'),
(2, 3, 'TV Shows'),
(2, 4, 'TV Shows'),
(3, 5, 'Books'),
(4, 6, 'Art'),
(6, 6, 'Art'),
(6, 9, 'Science'),
(6, 10, 'Science');
