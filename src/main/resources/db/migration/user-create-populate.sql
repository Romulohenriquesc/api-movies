	CREATE TABLE user (
	id bigint NOT NULL AUTO_INCREMENT,
	email varchar(50) NOT NULL,
	name varchar(60) NOT NULL,
	password varchar(255) NOT NULL,
	enabled bit default 1,
	admin bit default 0,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user (id, admin, email, name, password, enabled) values (1, false, 'romulocavalcante@gmail.com', 'Romulo', '$2a$10$C3tNZaAUdh2qJFQYVZ5yTeis5UGO.33F6Z5ewcQBve9YyTlS9AOXO', true);
insert into user (id, admin, email, name, password, enabled) values (2, true, 'ingrid@gmail.com', 'Ingrid', '$2a$10$C3tNZaAUdh2qJFQYVZ5yTeis5UGO.33F6Z5ewcQBve9YyTlS9AOXO', true);
insert into user (id, admin, email, name, password, enabled) values (3, false, 'manu@gmail.com', 'Manu', '$2a$10$C3tNZaAUdh2qJFQYVZ5yTeis5UGO.33F6Z5ewcQBve9YyTlS9AOXO', true);
