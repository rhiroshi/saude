CREATE TABLE usuario (
	email VARCHAR(100) primary key,
	senha varchar(255) not null,
	codigo_grupo BIGINT
);

alter table farmaceutico add column email_usuario VARCHAR(100) not null;
alter table farmaceutico add constraint email_fk foreign key(email_usuario) references usuario(email);