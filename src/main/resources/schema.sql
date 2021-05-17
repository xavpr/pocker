DROP TABLE IF EXISTS card CASCADE;
DROP TABLE IF EXISTS deck CASCADE;
DROP TABLE IF EXISTS player CASCADE;
DROP TABLE IF EXISTS game CASCADE;
DROP TABLE IF EXISTS game_player CASCADE;


CREATE TABLE game (
    id_game INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE deck (
    id_deck INT AUTO_INCREMENT PRIMARY KEY,
    fk_game INT,
    foreign key (fk_game) references game(id_game)
);

CREATE TABLE player (
    id_player INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR (50),
    last_name VARCHAR (50)
);


CREATE TABLE card (
    id_card INT AUTO_INCREMENT PRIMARY KEY,
    suit INT,
    face INT,
    position INT,
    fk_deck INT,
    fk_player INT,
    foreign key (fk_deck) references deck(id_deck),
    foreign key (fk_player) references player(id_player)
);



CREATE TABLE game_player (
    id_player INT,
    id_game INT,
    foreign key (id_player) references player(id_player),
    foreign key (id_game) references game(id_game)
);
