INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('joca', 'joca123','Jovan','Jovic','064123456','joca@gmail.com','13/07/1995',true);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('sanja', 'sanja123','Sanja','Milosevic','064854782','sanjam@gmail.com','10/04/2000',true);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('sergej', 'sega123','Sergej','Stefanovic','069875454','sega@gmail.com','12/12/1994',true);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('pavle', 'pavle123','Pavle','Pajic','061254796','ppajic@gmail.com','01/05/1996',true);


INSERT INTO ADMINISTRATOR (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('isi', 'isi123','Isidora','Tulumbic','064123123','isidora@gmail.com','23/05/2000',true);



INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_telefona_centrale,email) 
VALUES ('Fitness Centar', 'Bulevar oslobodjenja 112','021555333','fitnesscentar@gmail.com');
INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_telefona_centrale,email) 
VALUES ('E-Fitness Centar Perform', 'Novosadskoj Sajma 11','021444777','eperform@gmail.com');
INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_telefona_centrale,email) 
VALUES ('X-gym', 'Tozin Sokak 8','021777888','xgym@gmail.com');


INSERT INTO SALA (kapacitet,oznaka) 
VALUES (15,'S1');
INSERT INTO SALA (kapacitet,oznaka) 
VALUES (25,'S2');
INSERT INTO SALA (kapacitet,oznaka) 
VALUES (40,'S3');
INSERT INTO SALA (kapacitet,oznaka) 
VALUES (15,'S4');


INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('pero', 'pero123','Petar','Petrovic','061987654','pero@gmail.com','20/02/1992',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('dex', 'dejan123','Dejan','Jovic','064789526','dex@gmail.com','15/05/1991',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('neca1', 'neca123','Nemanja','Rodic','069785125','nemanja@gmail.com','13/03/19928',true);
INSERT INTO TRENER (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,aktivan) 
VALUES ('vanja', 'vanja123','Valentina','Vitic','061754125','vanja@gmail.com','07/07/1992',true);


INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Kondicija', 'Rad na kondiciji','Cardio','90min');
INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('Pilates', 'Pravilno disanje kroz vezbe','Pilates','60min');
INSERT INTO TRENING (naziv,opis,tip_treninga,trajanje) 
VALUES ('CORE 30', 'Vezbe za stomak','Vezbe','120min');


INSERT INTO TRENINZI (dan,vreme,cena,broj_rezervacija,rezervisan) 
VALUES ('Utorak', '17:00-21:00',300,3,true);
INSERT INTO TRENINZI (dan,vreme,cena,broj_rezervacija,rezervisan) 
VALUES ('Ponedeljak', '17:00-21:00',300,10,true);
INSERT INTO TRENINZI (dan,vreme,cena,broj_rezervacija,rezervisan) 
VALUES ('Sreda', '09:00-11:00',450,15,true);



INSERT INTO CLAN_REZ_TRENING(clan_id,trening_id) 
VALUES (4,1);
INSERT INTO CLAN_REZ_TRENING(clan_id,trening_id) 
VALUES (2,2);

INSERT INTO CLAN_OCENJEN_TRENING(clan_id,trening_id) 
VALUES (1,1);
INSERT INTO CLAN_OCENJEN_TRENING(clan_id,trening_id) 
VALUES (3,3);

INSERT INTO CLAN_TRENING(clan_id,trening_id) 
VALUES (1,3);
INSERT INTO CLAN_TRENING(clan_id,trening_id) 
VALUES (3,1);

INSERT INTO FITNESS_CENTAR_TRENINZI(fitness_centar_id,trening_id) 
VALUES (3,1);
INSERT INTO FITNESS_CENTAR_TRENINZI(fitness_centar_id,trening_id) 
VALUES (1,2);
INSERT INTO FITNESS_CENTAR_TRENINZI(fitness_centar_id,trening_id) 
VALUES (3,3);

INSERT INTO SALA_TRENINGA(sala_id,treninzi_id) 
VALUES (2,1);
INSERT INTO SALA_TRENINGA(sala_id,treninzi_id) 
VALUES (4,2);
INSERT INTO SALA_TRENINGA(sala_id,treninzi_id) 
VALUES (2,3);

INSERT INTO TRENER_TRENING(trener_id,trening_id) 
VALUES (1,3);
INSERT INTO TRENER_TRENING(trener_id,trening_id) 
VALUES (2,3);
INSERT INTO TRENER_TRENING(trener_id,trening_id) 
VALUES (3,1);
INSERT INTO TRENER_TRENING(trener_id,trening_id) 
VALUES (4,2);