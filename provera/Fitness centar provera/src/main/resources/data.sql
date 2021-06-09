INSERT INTO CLAN(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('joca', 'joca123','Jovan','Jovic','064123456','joca@gmail.com','13/07/1995','clan',true);
INSERT INTO CLAN(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('ana', 'ana123','Ana','Savic','064458632','ana@gmail.com','25/07/1995','clan',true);
INSERT INTO CLAN(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('sergej', 'sergej123','Sergej','Mihic','069875123','sega@gmail.com','06/07/1995','clan',true);
INSERT INTO CLAN(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('sanja', 'sanja123','Sanja','Milosevic','065874964','sanja@gmail.com','08/07/1995','clan',true);

INSERT INTO ADMINISTRATOR(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan)
VALUES('isi','isi123','Isidora','Tulumbic','0692502122','itulumbic@gmail.com','23.05.2000.','administrator',true);


INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_telefona_centrale,email) 
VALUES ('Fitness Centar X', 'Bulevar oslobodjenja 112','021555333','fitnesscentar@gmail.com');


INSERT INTO SALA (kapacitet,oznaka,fitness_centar_id) 
VALUES (25,'S1',1);
INSERT INTO SALA (kapacitet,oznaka,fitness_centar_id) 
VALUES (15,'S2',1);
INSERT INTO SALA (kapacitet,oznaka,fitness_centar_id) 
VALUES (15,'S3',1);
INSERT INTO SALA (kapacitet,oznaka,fitness_centar_id) 
VALUES (15,'S4',1);

INSERT INTO TERMIN (broj_rezervacija,cena,dan,rezervisan,vreme,sala_treninga_id) 
VALUES (25,450,'Ponedeljak',true,'14-16h',1);
INSERT INTO TERMIN (broj_rezervacija,cena,dan,rezervisan,vreme,sala_treninga_id) 
VALUES (15,350,'Utorak',true,'14-16h',1);
INSERT INTO TERMIN (broj_rezervacija,cena,dan,rezervisan,vreme,sala_treninga_id) 
VALUES (20,400,'Petak',true,'14-16h',1);


INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('pera','pera1234','Pera','Mihic','065478521','pera@gmail.com','15/03/1996','trener',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('senka','senka123','Senka','Pajic','064789523','senka@gmail.com','17/02/1992','trener',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) 
VALUES ('marko','marko123','Marko','Vasic','069874562','marko@gmail.com','18/02/1995','trener',true);


INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Kondicija', 'Rad na kondiciji','Cardio','90min');
INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Pilates', 'Disanje kroz vezbu','Pilates','60min');
INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Aerobik', 'Treninzi bez dodatnog opterecenja','Aerobik','90min');


INSERT INTO CLAN_REZ_TRENING (clan_id,trening_id) 
VALUES (3,3);
INSERT INTO CLAN_REZ_TRENING (clan_id,trening_id) 
VALUES (4,1);

INSERT INTO CLAN_TRENING (clan_id,trening_id) 
VALUES (1,3);
INSERT INTO CLAN_TRENING (clan_id,trening_id) 
VALUES (2,1);


INSERT INTO TRENER_TRENING (trener_id,trening_id) 
VALUES (2,2);
INSERT INTO TRENER_TRENING (trener_id,trening_id) 
VALUES (2,3);
INSERT INTO TRENER_TRENING (trener_id,trening_id) 
VALUES (1,2);

INSERT INTO OCENA(clan_id,trening_id)
VALUES(1,2);
INSERT INTO OCENA(clan_id,trening_id)
VALUES(3,1);

