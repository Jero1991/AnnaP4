-- PELICULA
CREATE TABLE Pelicula (
    id INTEGER PRIMARY KEY,
    titol VARCHAR(255),
    descripcio TEXT,
    imatge TEXT,
    anyPrimeraEmissio VARCHAR(32),
    idioma VARCHAR(255),
    durada INTEGER,
    valoracio FLOAT
);

-- SERIE
CREATE TABLE Serie (
    id INTEGER PRIMARY KEY,
    titol VARCHAR(255),
    descripcio TEXT,
    imatge TEXT,
    anyPrimeraEmissio VARCHAR(32),
    idioma VARCHAR(255),
    durada INTEGER,
    valoracio FLOAT
);

-- TEMPORADA
CREATE TABLE Temporada (
    id INTEGER PRIMARY KEY,
    serie_id INTEGER REFERENCES Serie(id),
    numTemporada INTEGER,
    anyEstrena VARCHAR(32),
    valoracio FLOAT
);

-- EPISODI
CREATE TABLE Episodi (
    id INTEGER PRIMARY KEY,
    temporada_id INTEGER REFERENCES Temporada(id),
    numEpisodi INTEGER,
    nom VARCHAR(255),
    anyEstrena VARCHAR(32),
    duracio INTEGER,
    idioma VARCHAR(255),
    descripcio TEXT,
    url VARCHAR(255),
    valoracio FLOAT
);

-- TEMATICA
CREATE TABLE Tematica (
    id INTEGER PRIMARY KEY,
    nomTematica VARCHAR(255)
);

-- PERSONA
CREATE TABLE Persona (
    id INTEGER PRIMARY KEY,
    correuElectronic VARCHAR(255),
    contrasenya VARCHAR(255),
    identificador VARCHAR(255),
    mobil VARCHAR(255),
    icona VARCHAR(255),
    nomPerfil VARCHAR(255)
);

-- GRUP INTERES
CREATE TABLE GrupInteres (
    id         INTEGER PRIMARY KEY,
    nomGrup    VARCHAR(255),
    descripcio VARCHAR(255)
);

---- ############################################################
---- RELATIONS
---- ############################################################

-- Many-to-many relationship between Pelicula/Serie/GrupInteres -> Tematica
CREATE TABLE Pelicula_Tematica (
   id INTEGER PRIMARY KEY,
   pelicula_id INTEGER REFERENCES Pelicula(id),
   tematica_id INTEGER REFERENCES Tematica(id)
);

CREATE TABLE Serie_Tematica (
    id INTEGER PRIMARY KEY,
    serie_id INTEGER REFERENCES Serie(id),
    tematica_id INTEGER REFERENCES Tematica(id)
);

CREATE TABLE GrupInteres_Tematica (
      id INTEGER PRIMARY KEY,
      grup_id INTEGER REFERENCES GrupInteres(id),
      tematica_id INTEGER REFERENCES Tematica(id)
);

-- Membership relationship between Persona/Serie/Pelicula ->  GrupInteres
CREATE TABLE Persona_Membre_GrupInteres (
    id         INTEGER PRIMARY KEY,
    persona_id INTEGER REFERENCES Persona (id),
    grup_id    INTEGER REFERENCES GrupInteres (id),
    data       VARCHAR(255),
    punts      INTEGER
);

CREATE TABLE Serie_GrupInteres (
    id INTEGER PRIMARY KEY,
    grup_id INTEGER REFERENCES GrupInteres (id),
    serie_id INTEGER REFERENCES Serie(id)
);

CREATE TABLE Pelicula_GrupInteres (
   id INTEGER PRIMARY KEY,
   grup_id INTEGER REFERENCES GrupInteres (id),
   pelicula_id INTEGER REFERENCES Pelicula(id)
);

-- Followers
CREATE TABLE Persona_Follower_GrupInteres (
    id         INTEGER PRIMARY KEY,
    persona_id INTEGER REFERENCES Persona (id),
    grup_id    INTEGER REFERENCES GrupInteres (id),
    data       VARCHAR(255)
);

-- Watched

CREATE TABLE Watched_Pelicula (
    id         INTEGER PRIMARY KEY,
    persona_id INTEGER REFERENCES Persona (id),
    pelicula_id INTEGER REFERENCES Pelicula (id),
    data    VARCHAR(255)
);

CREATE TABLE Watched_Serie (
    id         INTEGER PRIMARY KEY,
    persona_id INTEGER REFERENCES Persona (id),
    serie_id INTEGER REFERENCES Serie (id),
    data    VARCHAR(255)
);

CREATE TABLE Watched_Temporada (
    id         INTEGER PRIMARY KEY,
    persona_id INTEGER REFERENCES Persona (id),
    temporada_id INTEGER REFERENCES Temporada (id),
    data    VARCHAR(255)
);

CREATE TABLE Watched_Episodi (
   id         INTEGER PRIMARY KEY,
   persona_id INTEGER REFERENCES Persona (id),
   episodi_id INTEGER REFERENCES Episodi (id),
   data    VARCHAR(255)
);

-- VALORACIONS
CREATE TABLE ValoracioLikes (
    id INTEGER PRIMARY KEY,
    puntuacio BOOLEAN
);

CREATE TABLE ValoracioPunts (
    id INTEGER PRIMARY KEY,
    puntuacio FLOAT
);

CREATE TABLE ValoracioEstrelles (
    id INTEGER PRIMARY KEY,
    puntuacio INTEGER
);

CREATE TABLE Pelicula_ValoracioPunts (
    pelicula_id INTEGER NOT NULL REFERENCES Pelicula(id),
    valoracio_id INTEGER NOT NULL REFERENCES ValoracioPunts(id),
    persona_id INTEGER NOT NULL REFERENCES Persona(id),
    PRIMARY KEY (pelicula_id, valoracio_id, persona_id)
);

CREATE TABLE Pelicula_ValoracioEstrelles (
    pelicula_id INTEGER NOT NULL REFERENCES Pelicula(id),
    valoracio_id INTEGER NOT NULL REFERENCES ValoracioEstrelles(id),
    persona_id INTEGER NOT NULL REFERENCES Persona(id),
    PRIMARY KEY (pelicula_id, valoracio_id, persona_id)
);

CREATE TABLE Pelicula_ValoracioLikes (
    pelicula_id INTEGER NOT NULL REFERENCES Pelicula(id),
    persona_id INTEGER NOT NULL REFERENCES Persona(id),
    valoracio_id INTEGER NOT NULL REFERENCES ValoracioLikes(id),
    PRIMARY KEY (pelicula_id, valoracio_id, persona_id)
);


CREATE TABLE Episodi_ValoracioPunts (
    episodi_id INTEGER NOT NULL REFERENCES Episodi(id),
    valoracio_id INTEGER NOT NULL REFERENCES ValoracioPunts(id),
    persona_id INTEGER NOT NULL REFERENCES Persona(id),
    PRIMARY KEY (episodi_id, valoracio_id, persona_id)
);

CREATE TABLE Episodi_ValoracioEstrelles (
    episodi_id INTEGER NOT NULL REFERENCES Episodi(id),
    valoracio_id INTEGER NOT NULL REFERENCES ValoracioEstrelles(id),
    persona_id INTEGER NOT NULL REFERENCES Persona(id),
    PRIMARY KEY (episodi_id, valoracio_id, persona_id)
);

CREATE TABLE Episodi_ValoracioLikes (
    episodi_id INTEGER NOT NULL REFERENCES Episodi(id),
    persona_id INTEGER NOT NULL REFERENCES Persona(id),
    valoracio_id INTEGER NOT NULL REFERENCES ValoracioLikes(id),
    PRIMARY KEY (episodi_id, valoracio_id, persona_id)
);

--- Quizz

CREATE TABLE GrupInteres_Categoria_Pregunta (
    grup_id INTEGER NOT NULL REFERENCES GrupInteres(id),
    pregunta_id INTEGER NOT NULL REFERENCES Pregunta(id),
    categoria VARCHAR(255),
    PRIMARY KEY (grup_id, pregunta_id, categoria)
);

CREATE TABLE Pregunta (
    id INTEGER PRIMARY KEY,
    pregunta VARCHAR(1024)
);

CREATE TABLE Resposta (
    id INTEGER PRIMARY KEY,
    pregunta_id INTEGER REFERENCES Pregunta(id),
    resposta VARCHAR(255),
    esCorrecta BOOLEAN
);
