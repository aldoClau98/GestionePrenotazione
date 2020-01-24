insert into  Utente(Email,Password,Nome,Cognome,TipoUtente)
values("aldo.claudini@unisa.it","12345678","aldo","claudini",3),
("veronica.marcantuono@unisa.it","12345678","veronica","marcantuono",2),
("martina.borriello@studenti.unisa.it","12345678","martina","boriello",0),
("andrea.claro@unisa.it","12345678","andrea","claro",1),
("carlo.lerro@unisa.it","12345678","carlo","lerro",2);


insert into  Dipartimento(Nome,AmmDip)
values("informatica","veronica.marcantuono@unisa.it"),
("matematica","carlo.lerro@unisa.it");



insert into Struttura (Aula,Edificio,Tipo,Descrizione,Dipartimento)
values("F1","F2",0,"laboratorio","informatica"),
("F2","F2",1,"laboratorio","informatica"),
("P1","F3",0,"laboratorio","matematica"),
("P2","F3",1,"laboratorio","matematica");

insert into  Prenotazione(Titolo,Data,OraInizio,OraFine,Descrizione,NomeUtente,Aula,Edificio,Accettata)
values("Sistemi operativi",'2019-07-03',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Analisi 1",'2019-07-03',9,11,"Corso  del primo  anno della triennale in matematica","aldo.claudini@unisa.it","P1","F3",0),
("Sistemi operativi",'2019-07-02',11,12,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-07-01',14,15,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-03',16,17,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-04',8,9,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-05',10,11,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-06',12,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-09',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F2","F2",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","F1","F2",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P1","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P1","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P1","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P1","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2020-06-07',11,13,"Corso del secondo  anno della triennale i informatica","veronica.marcantuono@unisa.it","F1","F2",1),
("Sistemi operativi",'2020-06-07',11,13,"Corso del secondo  anno della triennale i informatica","veronica.marcantuono@unisa.it","F1","F2",1),
("Sistemi operativi",'2019-06-07',11,13,"Corso del secondo  anno della triennale i informatica","aldo.claudini@unisa.it","P2","F3",0),
("Sistemi operativi",'2020-06-07',9,10,"Corso del secondo  anno della triennale i informatica","martina.borriello@studenti.unisa.it","F1","F2",0),
("Sistemi operativi",'2020-06-07',10,11,"Corso del secondo  anno della triennale i informatica","martina.borriello@studenti.unisa.it","F1","F2",1);

