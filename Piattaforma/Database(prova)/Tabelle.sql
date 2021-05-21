drop database if exists GestionePrenotazioni;
create database GestionePRenotazioni;

use GestionePrenotazioni;


CREATE TABLE Utente (
	Email VARCHAR(55) PRIMARY KEY,
    Password VARCHAR(32) NOT NULL,
    Nome  VARCHAR(30) NOT NULL,
    Cognome VARCHAR(30) NOT NULL,
    TipoUtente int NOT NULL
    );
    
CREATE TABLE Dipartimento (
	
	Nome VARCHAR(30) PRIMARY KEY ,
    AmmDip VARCHAR(55),
      FOREIGN KEY(AmmDip) References Utente(Email) 
     on delete cascade
     on update cascade
  
);

CREATE TABLE Corso (
	
    NomeCorso VARCHAR(30) PRIMARY KEY,
    Tutor VARCHAR(55),
    NomeDip  VARCHAR(30),
    FOREIGN KEY(NomeDip) References Dipartimento(Nome) 
     on delete cascade
     on update cascade
);

CREATE TABLE Struttura (
  Edificio varchar(55) not null,
	Aula varchar(55) not null,
    tipo int not null,
    Descrizione varchar(255),
    Dipartimento  varchar(55),
   primary Key(Aula,Edificio),
    FOREIGN KEY(Dipartimento) References Dipartimento(Nome)
     ON UPDATE CASCADE 
    on delete cascade
  
   
);

CREATE TABLE Prenotazione (
	IDprenotazione INT NOT NULL AUTO_INCREMENT,
    Titolo VARCHAR(20) NOT NULL,
    Data char(10) NOT NULL  ,
    OraInizio int NOT NULL,
    OraFine int NOT NULL,
    Descrizione varchar(255) NOT NULL,
    NomeUtente  varchar(55) NOT null,
    Aula varchar(55) not null,
    Edificio varchar(55) not null,
    Accettata int not null default 0,
    FOREIGN KEY(NomeUtente) References Utente(Email) 
    ON UPDATE CASCADE 
    on delete cascade,
     FOREIGN KEY(Aula,Edificio) References Struttura(Aula,Edificio) 
    ON UPDATE CASCADE 
    on delete cascade,
    PRIMARY KEY (IDprenotazione)
);