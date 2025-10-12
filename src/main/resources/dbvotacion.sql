DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS voter;
DROP TABLE IF EXISTS candidate;

CREATE TABLE voter(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    has_voted BIT DEFAULT 0 NOT NULL,
    CONSTRAINT pk_voter_id PRIMARY KEY (id),
    CONSTRAINT uq_voter_email UNIQUE (email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE candidate(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    party VARCHAR(255),
    votes INT DEFAULT 0 NOT NULL,
    CONSTRAINT pk_candidate_id PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE vote(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    voter_id INTEGER,
    candidate_id INTEGER,
    CONSTRAINT fk_vote_voter FOREIGN KEY (voter_id) REFERENCES voter(id) ON DELETE CASCADE,
    CONSTRAINT fk_vote_candidate FOREIGN KEY (candidate_id) REFERENCES candidate(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO voter (name, email) VALUES ('Omar Fonseca', 'omarfonsecamontes@hotmail.com'),
                                       ("Juan Andres Martínez", "juanamartinez1998@hotmail.com"),
                                       ("Andrea Londoño", "andrealondono25@outlook.com");

INSERT INTO candidate (name, party) VALUES ('Juan Manuel Santos', 'Partido Liberal'),
                                           ('Oscar Iván Zuluaga', 'Centro democrático'),
                                           ('Federico Gutiérrez', null)