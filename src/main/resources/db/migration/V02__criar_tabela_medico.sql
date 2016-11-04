CREATE TABLE medico(
	crm INTEGER PRIMARY KEY,
	especialidade VARCHAR(255),
	nome VARCHAR(255),
	cpf INTEGER,
	endereco VARCHAR(255),
	numero_casa INTEGER,
	bairro VARCHAR(255),
	data_nascimento DATE
);