DROP TABLE IF EXISTS card CASCADE ;
DROP TABLE IF EXISTS deck CASCADE ;

CREATE TABLE deck (
    id_deck INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE card (
    id_card INT AUTO_INCREMENT PRIMARY KEY,
    suit INT,
    face INT,
    fk_deck INT,
    foreign key (fk_deck) references deck(id_deck)
);

CREATE TABLE player (
    id_player INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR (50),
    last_name VARCHAR (50)
);



