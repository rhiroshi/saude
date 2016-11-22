CREATE TABLE farmaceutico(
	cpf BIGINT PRIMARY KEY,
	nome VARCHAR(255),
	crf BIGINT,
	endereco VARCHAR(255),
	numero_casa INTEGER,
	bairro VARCHAR(255),
	data_nascimento DATE
);