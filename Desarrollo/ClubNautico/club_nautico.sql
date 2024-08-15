SET	NAMES 'latin1';
DROP DATABASE IF EXISTS club_nautico;
CREATE DATABASE IF NOT EXISTS club_nautico DEFAULT CHARACTER SET utf8;

USE club_nautico;

CREATE TABLE socios(
	id_scs						INTEGER NOT NULL AUTO_INCREMENT,
	nombre						VARCHAR(30) NOT NULL,
	ap_paterno					VARCHAR(30) NOT NULL,
	ap_materno					VARCHAR(30) NOT NULL,
	telefono					VARCHAR(20) NOT NULL,
	email						VARCHAR(40) NOT NULL,
	duenhio 					BOOLEAN NOT NULL,
	
	CONSTRAINT email_invalido CHECK (email LIKE '%_@__%.__%'),
	CONSTRAINT telefono_invalido CHECK (telefono REGEXP '^[0-9]+$'),
	PRIMARY KEY(id_scs)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE patrones(
	id_pts						INTEGER NOT NULL AUTO_INCREMENT,
	nombre						VARCHAR(30) NOT NULL,
	ap_paterno					VARCHAR(30) NOT NULL,
	ap_materno					VARCHAR(30) NOT NULL,
	telefono					VARCHAR(20) NOT NULL,
	email						VARCHAR(40) NOT NULL,
	duenhio 					BOOLEAN NOT NULL,
	id_scs						INTEGER,

	CONSTRAINT email_invalido CHECK (email LIKE '%_@__%.__%'),
	CONSTRAINT telefono_invalido CHECK (telefono REGEXP '^[0-9]+$'),
	PRIMARY KEY(id_pts),
	FOREIGN KEY(id_scs) REFERENCES socios(id_scs)
)DEFAULT CHARACTER SET utf8;


CREATE TABLE barcos(
	num_matricula				INTEGER NOT NULL,
	num_amarre					INTEGER NOT NULL,
	fecha_llegada				DATE, 
	nombre						VARCHAR(30) NOT NULL,
	couta						DECIMAL,
	id_scs						INTEGER,
	id_pts						INTEGER,
	
	PRIMARY KEY(num_matricula, num_amarre, fecha_llegada),
	FOREIGN KEY (id_scs) REFERENCES socios(id_scs), 
	FOREIGN KEY (id_pts) REFERENCES patrones(id_pts)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE salidas(
	id_sls						INTEGER NOT NULL AUTO_INCREMENT,
	fecha_hora					DATETIME NOT NULL,
	destino						VARCHAR(40) NOT NULL,
	num_matricula				INTEGER,
	
	PRIMARY KEY(id_sls), 
	FOREIGN KEY (num_matricula) REFERENCES barcos(num_matricula)
)DEFAULT CHARACTER SET utf8;
