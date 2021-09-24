CREATE TABLE evaluation (
	id bigint NOT NULL AUTO_INCREMENT,
	grade integer NOT NULL,
	movie_id bigint NOT NULL,
	user_id bigint NOT NULL,
    PRIMARY KEY (id),
	KEY FK_MOVIE_EVALUATE_KEY (movie_id),
  	KEY FK_USER_EVALUATE_KEY (user_id),
  	CONSTRAINT FK_MOVIE_EVALUATE_KEY FOREIGN KEY (movie_id) REFERENCES movie (id),
  	CONSTRAINT FK_USER_EVALUATE_KEY FOREIGN KEY (user_id) REFERENCES user (id)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into evaluation (id, grade, movie_id, user_id) values ('1', '4', '1', '1');
insert into evaluation (id, grade, movie_id, user_id) values ('2', '2', '1', '3');

insert into evaluation (id, grade, movie_id, user_id) values ('3', '4', '2', '1');
insert into evaluation (id, grade, movie_id, user_id) values ('4', '4', '2', '3');

insert into evaluation (id, grade, movie_id, user_id) values ('5', '2', '3', '1');
insert into evaluation (id, grade, movie_id, user_id) values ('6', '3', '3', '3');

insert into evaluation (id, grade, movie_id, user_id) values ('7', '0', '4', '1');
insert into evaluation (id, grade, movie_id, user_id) values ('8', '4', '4', '3');

insert into evaluation (id, grade, movie_id, user_id) values ('9', '0', '5', '1');
insert into evaluation (id, grade, movie_id, user_id) values ('10', '0', '5', '3');