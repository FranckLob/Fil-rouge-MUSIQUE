insert into type (id, type, titleList) values (type_seq_id.nextval, 'Classique', []);
insert into type (id, type) values (type_seq_id.nextval, 'Musique Traditionnelle');
insert into type (id, type) values (type_seq_id.nextval, 'Musique Contemporaine',[]);
insert into type (id, type) values (type_seq_id.nextval, 'Musique Populaire',[]);
insert into type (id, type) values (type_seq_id.nextval, 'Musique Baroque',[]);
insert into type (id, type) values (type_seq_id.nextval, 'Musique Moderne',[]);

insert into style (id,style) values (style_seq_id.nextval, 'Disco',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Blues',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Funk',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Jazz',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Metal',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Pop',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Punk',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Rap',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Rock’n’roll',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Country',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Reggae',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Afro',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Raï',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Ska',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Gospel',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Soul',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Kompa',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Classique',[]);
insert into style (id,style) values (style_seq_id.nextval, 'R’n’B',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Electro',[]);
insert into style (id,style) values (style_seq_id.nextval, 'K-pop',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Zouk',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Makossa',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Musique Indi',[]);
insert into style (id,style) values (style_seq_id.nextval, 'Musique Latino',[]);

insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Knockin on heaven's doors",6,9,"Bob Dylan","Bob Dylan");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Where is my mind",6,9,"Francis Black","Francis Black");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "One more time",6,20,"Daft Punk","Daft Punk");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Rockafeller skank",6,20,"Fatboy Slim","Fatboy Slim");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Rigth here right now",6,20,"Fatboy Slim","Fatboy Slim");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Praise you here right now",6,20,"Fatboy Slim","Fatboy Slim");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "a message to you Rudy",6,14,"The Specials","The Specials");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Sally Brown",6,14,"Laurel Aitken","Laurel Aitken");
insert into title (id,name,type,style,author,composer) values (title_seq_id.nextval, "Skinhead",6,14,"Laurel Aitken","Laurel Aitken");

insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Andrea", "andrea.jouan@gmail.com",["ADMIN", "USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Franck", "franck.lobj@gmail.com",["ADMIN", "USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Yves", "yves.benoit@gmail.com",["ADMIN", "USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Jules", "jules.grand@gmail.com",["ADMIN", "USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Bernard", "bernard.huguenet@gmail.com",["ADMIN", "USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Vincent", "vincent. @gmail.com",[], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Jean Marc", "jeanmarc. @gmail.com",[], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Pierre", "pierre. @gmail.com",[], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Carole", "carole.ciemy@gmail.com",[], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Philippe", "philippe. @gmail.com",[], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Fred", "fred. @gmail.com",["USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Benoit", "benoit.henry@gmail.com",["USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Saya", "saya.sayavong@gmail.com",["USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Sylvain", "sylvain. @gmail.com",[USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Franck", "franck. @gmail.com",["USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Guillaume", "guillaule. @gmail.com",["USER"], []);
insert into appuser (id,nickname,is_admin) values (appuser_seq_id.nextval, "Nicolas", "nicolas.@gmail.com",["USER"], []);

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
