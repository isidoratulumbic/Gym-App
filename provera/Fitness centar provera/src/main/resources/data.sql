INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('joca', 'joca123','Jovan','Jovic','064123456','joca@gmail.com','13/07/1995',true);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('ana', 'ana123','Ana','Savic','064458632','ana@gmail.com','25/07/1995',true);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('sergej', 'sergej123','Sergej','Mihic','069875123','sega@gmail.com','06/07/1995',true);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('sanja', 'sanja123','Sanja','Milosevic','065874964','sanja@gmail.com','08/07/1995',true);

INSERT INTO ADMINISTRATOR (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('isi', 'isi123','Isidora','Tulumbic','064123123','isidora@gmail.com','23/05/2000',true);



INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_telefona_centrale,email) 
VALUES ('Fitness Centar X', 'Bulevar oslobodjenja 112','021555333','fitnesscentar@gmail.com');


INSERT INTO SALA (kapacitet,oznaka) 
VALUES (25,'S1');
INSERT INTO SALA (kapacitet,oznaka) 
VALUES (15,'S2');
INSERT INTO SALA (kapacitet,oznaka) 
VALUES (15,'S3');
INSERT INTO SALA (kapacitet,oznaka) 
VALUES (15,'S4');


INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('pero', 'pero123','Petar','Petrovic','061895647','pero@gmail.com','20/03/1992',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('senka', 'senka123','Senka','Pajic','064789523','senka@gmail.com','17/02/1992',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('marko', 'marko123','Marko','Vasic','069874562','marko@gmail.com','18/02/1995',true);


INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Kondicija', 'Rad na kondiciji','Cardio','90min');
INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Pilates', 'Disanje kroz vezbu','Pilates','60min');
INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Aerobik', 'Treninzi bez dodatnog opterecenja','Aerobik','90min');


INSERT INTO TRENINZI (dan,vreme,cena,broj_rezervacija,rezervisan) 
VALUES ('Utorak', '17:00-21:00',300,3,true);
INSERT INTO TRENINZI (dan,vreme,cena,broj_rezervacija,rezervisan) 
VALUES ('Sreda', '17:00-21:00',300,5,true);
INSERT INTO TRENINZI (dan,vreme,cena,broj_rezervacija,rezervisan) 
VALUES ('Ponedeljak', '12:00-14:00',300,10,true);


INSERT INTO CLAN_OCENJEN_TRENING (clan_id,trening_id) 
VALUES (1,3);
INSERT INTO CLAN_OCENJEN_TRENING (clan_id,trening_id) 
VALUES (2,1);
INSERT INTO CLAN_OCENJEN_TRENING (clan_id,trening_id) 
VALUES (4,2);

INSERT INTO CLAN_REZ_TRENING (clan_id,trening_id) 
VALUES (3,3);
INSERT INTO CLAN_REZ_TRENING (clan_id,trening_id) 
VALUES (4,1);

INSERT INTO CLAN_TRENING (clan_id,trening_id) 
VALUES (1,3);
INSERT INTO CLAN_TRENING (clan_id,trening_id) 
VALUES (2,1);

INSERT INTO FITNESS_CENTAR_TRENINZI (fitness_centar_id,trening_id) 
VALUES (1,2);
INSERT INTO FITNESS_CENTAR_TRENINZI (fitness_centar_id,trening_id) 
VALUES (1,3);

INSERT INTO SALA_TRENINGA (sala_id,treninzi_id) 
VALUES (1,2);
INSERT INTO SALA_TRENINGA (sala_id,treninzi_id) 
VALUES (2,3);
INSERT INTO SALA_TRENINGA (sala_id,treninzi_id) 
VALUES (3,1);

INSERT INTO TRENER_TRENING (trener_id,trening_id) 
VALUES (1,2);
INSERT INTO TRENER_TRENING (trener_id,trening_id) 
VALUES (2,3);
INSERT INTO TRENER_TRENING (trener_id,trening_id) 
VALUES (3,2);