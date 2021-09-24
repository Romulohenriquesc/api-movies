CREATE TABLE actor (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE movie (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	director varchar(255) NOT NULL,
	genre varchar(255) NOT NULL,
	description varchar(550) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE movie_actors (
	movie_id bigint NOT NULL,
	actor_id bigint NOT NULL,
	KEY movie_key (`movie_id`),
  	KEY actor_key (`actor_id`),
  	CONSTRAINT movie_key FOREIGN KEY (movie_id) REFERENCES movie (id),
  	CONSTRAINT actor_key FOREIGN KEY (actor_id) REFERENCES actor (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into movie (id, name, genre, director, description) values (1,'Forrest Gump','Comédia','Robert Zemeckis','Mesmo com o raciocínio lento, Forrest Gump nunca se sentiu desfavorecido. Graças ao apoio da mãe, ele teve uma vida normal. Seja no campo de futebol como um astro do esporte, lutando no Vietnã ou como capitão de um barco de pesca de camarão, Forrest inspira a todos com seu otimismo. Mas a pessoa que Forrest mais ama pode ser a mais difícil de salvar: seu amor de infância, a doce e perturbada Jenny.');
insert into movie (id, name, genre, director, description) values (2,'A Origem','Ação','Christopher Nolan','Dom Cobb é um ladrão com a rara habilidade de roubar segredos do inconsciente, obtidos durante o estado de sono. Impedido de retornar para sua família, ele recebe a oportunidade de se redimir ao realizar uma tarefa aparentemente impossível: plantar uma ideia na mente do herdeiro de um império. Para realizar o crime perfeito, ele conta com a ajuda do parceiro Arthur, o discreto Eames e a arquiteta de sonhos Ariadne. Juntos, eles correm para que o inimigo não antecipe seus passos.');
insert into movie (id, name, genre, director, description) values (3,'Interestelar','Ficção científica','Christopher Nolan','As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand, Jenkins e Doyle, ele seguirá em busca de um novo lar.');
insert into movie (id, name, genre, director, description) values (4,'Simplesmente Acontece','Romance','Christian Ditter','Alex e Rosie são amigos inseparáveis que cresceram juntos em Londres, compartilhando entre si suas melhores experiências. Tudo muda quando Alex ganha uma bolsa de estudos e passa a morar nos EUA. Separados, seus caminhos agora são outros. Mas nos tempos de hoje é impossível não se conectar. E, em se tratando de amor, o difícil é fazer as escolhas certas.');
insert into movie (id, name, genre, director, description) values (5,'Invocação do Mal','Terror','James Wan','Os investigadores paranormais Ed e Lorraine Warren trabalham para ajudar a família aterrorizada por uma entidade demoníaca em sua fazenda.');

insert into actor (id, name) values (1, 'Tom Hanks');
insert into actor (id, name) values (2, 'Leonardo DiCaprio');
insert into actor (id, name) values (3, 'Matthew McConaughey');
insert into actor (id, name) values (4, 'Anne Hathaway');
insert into actor (id, name) values (5, 'Lily Collins');
insert into actor (id, name) values (6, 'Vera Farmiga');
insert into actor (id, name) values (7, 'Patrick Wilson');

insert into movie_actors (movie_id, actor_id) values ('1', '1');
insert into movie_actors (movie_id, actor_id) values ('2', '2');
insert into movie_actors (movie_id, actor_id) values ('3', '3');
insert into movie_actors (movie_id, actor_id) values ('3', '4');
insert into movie_actors (movie_id, actor_id) values ('4', '5');
insert into movie_actors (movie_id, actor_id) values ('5', '6');
insert into movie_actors (movie_id, actor_id) values ('5', '7');