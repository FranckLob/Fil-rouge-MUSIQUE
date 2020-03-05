insert into type (id, type) values (nextval('type_seq_id'), 'Classique');
insert into type (id, type) values (nextval('type_seq_id'), 'Musique Traditionnelle');
insert into type (id, type) values (nextval('type_seq_id'), 'Musique Contemporaine');
insert into type (id, type) values (nextval('type_seq_id'), 'Musique Populaire');
insert into type (id, type) values (nextval('type_seq_id'), 'Musique Baroque');
insert into type (id, type) values (nextval('type_seq_id'), 'Musique Moderne');

insert into style (id,style) values (nextval('style_seq_id'), 'Disco');
insert into style (id,style) values (nextval('style_seq_id'), 'Blues');
insert into style (id,style) values (nextval('style_seq_id'), 'Funk');
insert into style (id,style) values (nextval('style_seq_id'), 'Jazz');
insert into style (id,style) values (nextval('style_seq_id'), 'Metal');
insert into style (id,style) values (nextval('style_seq_id'), 'Pop');
insert into style (id,style) values (nextval('style_seq_id'), 'Punk');
insert into style (id,style) values (nextval('style_seq_id'), 'Rap');
insert into style (id,style) values (nextval('style_seq_id'), 'Rock’n’roll');
insert into style (id,style) values (nextval('style_seq_id'), 'Country');
insert into style (id,style) values (nextval('style_seq_id'), 'Reggae');
insert into style (id,style) values (nextval('style_seq_id'), 'Afro');
insert into style (id,style) values (nextval('style_seq_id'), 'Raï');
insert into style (id,style) values (nextval('style_seq_id'), 'Ska');
insert into style (id,style) values (nextval('style_seq_id'), 'Gospel');
insert into style (id,style) values (nextval('style_seq_id'), 'Soul');
insert into style (id,style) values (nextval('style_seq_id'), 'Kompa');
insert into style (id,style) values (nextval('style_seq_id'), 'Classique');
insert into style (id,style) values (nextval('style_seq_id'), 'R’n’B');
insert into style (id,style) values (nextval('style_seq_id'), 'Electro');
insert into style (id,style) values (nextval('style_seq_id'), 'K-pop');
insert into style (id,style) values (nextval('style_seq_id'), 'Zouk');
insert into style (id,style) values (nextval('style_seq_id'), 'Makossa');
insert into style (id,style) values (nextval('style_seq_id'), 'Musique Indi');
insert into style (id,style) values (nextval('style_seq_id'), 'Musique Latino');

insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Knockin on heaven s doors',6,9,'Bob Dylan','Bob Dylan');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Where is my mind',6,9,'Francis Black','Francis Black');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'One more time',6,20,'Daft Punk','Daft Punk');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Rockafeller skank',6,20,'Fatboy Slim','Fatboy Slim');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Rigth here right now',6,20,'Fatboy Slim','Fatboy Slim');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Praise you here right now',6,20,'Fatboy Slim','Fatboy Slim');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'a message to you Rudy',6,14,'The Specials','The Specials');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Sally Brown',6,14,'Laurel Aitken','Laurel Aitken');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Skinhead',6,14,'Laurel Aitken','Laurel Aitken');
insert into title (id,name,type_id,style_id,author,composer) values (nextval('title_seq_id'), 'Knockin on heaven s doors',6,9,'Bob Dylan','Gun and Roses');

insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea.jouanin.devweb@gmail.com','Andrea');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'yves.benoit.devweb@gmail.com','Yves');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'franck.lobjois.devweb@gmail.com','Franck');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea1.jouanin.devweb@gmail.com','Bernard');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea2.jouanin.devweb@gmail.com','Jules');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea3.jouanin.devweb@gmail.com','Vincent');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea4.jouanin.devweb@gmail.com','Jean Marc');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea5.jouanin.devweb@gmail.com','Pierre');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea6.jouanin.devweb@gmail.com','Carole');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea7.jouanin.devweb@gmail.com','Philippe');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea8.jouanin.devweb@gmail.com','Fred');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea9.jouanin.devweb@gmail.com','Benoit');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea10.jouanin.devweb@gmail.com','Saya');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea11.jouanin.devweb@gmail.com','Sylvain');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea12.jouanin.devweb@gmail.com','Franck Thery');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea13.jouanin.devweb@gmail.com','Guillaume');
insert into app_user (id,email,nick_name) values (nextval('appuser_seq_id'),'andrea14.jouanin.devweb@gmail.com','Nicolas');

insert into artwork(id,name,editor,producer) values (nextval('artwork_seq_id'), 'You''ve Come a Long Way, Baby','Skint Record','Fat Boy Slim');
insert into artwork(id,name,editor,producer) values (nextval('artwork_seq_id'), 'Surfer Rosa','4AD','Steve Albiny');

insert into artist(id,name) values (nextval('artist_seq_id'), 'Fat Boy Slim');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Laurel Aitken');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Daft Punk');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Pixies');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Bob Dylan');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Avril Lavigne');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Guns and Roses');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Bob Dylan');
insert into artist(id,name) values (nextval('artist_seq_id'), 'The Specials');
insert into artist(id,name) values (nextval('artist_seq_id'), 'Fred Bueno and his Fuckin Fuckers Band from Bdx');

insert into authority(id, authority) values (nextval('authority_seq_id'),'ADMIN');
insert into authority(id, authority) values (nextval('authority_seq_id'),'USER');


insert into appuser_authority(appuser_id, authority_id) values (1,1);
insert into appuser_authority(appuser_id, authority_id) values (2,1);
insert into appuser_authority(appuser_id, authority_id) values (3,1);
insert into appuser_authority(appuser_id, authority_id) values (4,2);
insert into appuser_authority(appuser_id, authority_id) values (5,2);
insert into appuser_authority(appuser_id, authority_id) values (6,2);
insert into appuser_authority(appuser_id, authority_id) values (7,2);
insert into appuser_authority(appuser_id, authority_id) values (8,2);
insert into appuser_authority(appuser_id, authority_id) values (9,2);
insert into appuser_authority(appuser_id, authority_id) values (10,2);
insert into appuser_authority(appuser_id, authority_id) values (11,2);
insert into appuser_authority(appuser_id, authority_id) values (12,2);
insert into appuser_authority(appuser_id, authority_id) values (13,2);
insert into appuser_authority(appuser_id, authority_id) values (14,2);

insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',1,1,NULL ,NULL,NULL);
insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',1,NULL,NULL ,10,NULL);
insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',2,NULL,NULL ,3,NULL);
insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',2,1,NULL ,4,NULL);
insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',2,1,NULL ,5,NULL);
insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',NULL,1,NULL ,5,NULL);
insert into publication(id,date,app_user_id,artist_id,artwork_id,title_id,snippet) values (nextval('publication_seq_id'),'2020-03-05',NULL,NULL,NULL ,5,NULL);

