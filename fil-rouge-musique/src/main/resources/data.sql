insert into type (id, type) values (type_seq_id.nextval, 'Classique');
insert into type (id, type) values (type_seq_id.nextval, 'Musique Traditionnelle');
insert into type (id, type) values (type_seq_id.nextval, 'Musique Contemporaine');
insert into type (id, type) values (type_seq_id.nextval, 'Musique Populaire');
insert into type (id, type) values (type_seq_id.nextval, 'Musique Baroque');
insert into type (id, type) values (type_seq_id.nextval, 'Musique Moderne');

insert into style (id,style) values (style_seq_id.nextval, 'Disco');
insert into style (id,style) values (style_seq_id.nextval, 'Blues');
insert into style (id,style) values (style_seq_id.nextval, 'Funk');
insert into style (id,style) values (style_seq_id.nextval, 'Jazz');
insert into style (id,style) values (style_seq_id.nextval, 'Metal');
insert into style (id,style) values (style_seq_id.nextval, 'Pop');
insert into style (id,style) values (style_seq_id.nextval, 'Punk');
insert into style (id,style) values (style_seq_id.nextval, 'Rap');
insert into style (id,style) values (style_seq_id.nextval, 'Rock’n’roll');
insert into style (id,style) values (style_seq_id.nextval, 'Country');
insert into style (id,style) values (style_seq_id.nextval, 'Reggae');
insert into style (id,style) values (style_seq_id.nextval, 'Afro');
insert into style (id,style) values (style_seq_id.nextval, 'Raï');
insert into style (id,style) values (style_seq_id.nextval, 'Ska');
insert into style (id,style) values (style_seq_id.nextval, 'Gospel');
insert into style (id,style) values (style_seq_id.nextval, 'Soul');
insert into style (id,style) values (style_seq_id.nextval, 'Kompa');
insert into style (id,style) values (style_seq_id.nextval, 'Classique');
insert into style (id,style) values (style_seq_id.nextval, 'R’n’B');
insert into style (id,style) values (style_seq_id.nextval, 'Electro');
insert into style (id,style) values (style_seq_id.nextval, 'K-pop');
insert into style (id,style) values (style_seq_id.nextval, 'Zouk');
insert into style (id,style) values (style_seq_id.nextval, 'Makossa');
insert into style (id,style) values (style_seq_id.nextval, 'Musique Indi');
insert into style (id,style) values (style_seq_id.nextval, 'Musique Latino');

insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Knockin on heaven's doors",6,9,"Bob Dylan","Bob Dylan");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Where is my mind",6,9,"Francis Black","Francis Black");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "One more time",6,20,"Daft Punk","Daft Punk");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Rockafeller skank",6,20,"Fatboy Slim","Fatboy Slim");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Rigth here right now",6,20,"Fatboy Slim","Fatboy Slim");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Praise you here right now",6,20,"Fatboy Slim","Fatboy Slim");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "a message to you Rudy",6,14,"The Specials","The Specials");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Sally Brown",6,14,"Laurel Aitken","Laurel Aitken");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Skinhead",6,14,"Laurel Aitken","Laurel Aitken");

insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Andrea", true);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Franck", true);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Yves", true);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Jules", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Bernard", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Vincent", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Jean Marc", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Pierre", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Carole", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Philippe", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Fred", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Benoit", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Saya", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Sylvain", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Franck", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Guillaume", false);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Nicolas", false);

insert into artwork(id,name,editor,producer) values (artwork_seq_id.nextval, "You''ve Come a Long Way, Baby","Skint Record","Fat Boy Slim")
insert into artwork(id,name,editor,producer) values (artwork_seq_id.nextval, "Surfer Rosa","4AD","Steve Albiny Boy Slim")

insert into artist(id,name) values (artist_seq_id.nextval, "Fat Boy Slim");
insert into artist(id,name) values (artist_seq_id.nextval, "Laurel Aitken");
insert into artist(id,name) values (artist_seq_id.nextval, "Daft Punk");
insert into artist(id,name) values (artist_seq_id.nextval, "Pixies");
insert into artist(id,name) values (artist_seq_id.nextval, "Bob Dylan");
insert into artist(id,name) values (artist_seq_id.nextval, "Avril Lavigne");
insert into artist(id,name) values (artist_seq_id.nextval, "Guns and Roses");
insert into artist(id,name) values (artist_seq_id.nextval, "Bob Dylan");
insert into artist(id,name) values (artist_seq_id.nextval, "The Specials");
insert into artist(id,name) values (artist_seq_id.nextval, "Fred Bueno and his Fuckin Fuckers Band from Bdx");

insert into publication(id,app_user,artist,date,artwork,title,snippet) values (publication_seq_id.nextval,"Andrea","","2020-03-04","",);