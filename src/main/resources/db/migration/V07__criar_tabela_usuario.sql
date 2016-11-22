CREATE TABLE usuario (
	email VARCHAR(100) primary key,
	senha varchar(255) not null,
	codigo_grupo BIGINT,
	cpf_funcionario BIGINT
);

alter table usuario add constraint user_func_fk foreign key(cpf_funcionario) references farmaceutico(cpf); 
