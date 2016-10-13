CREATE TABLE paciente(
	cpf LONG PRIMARY KEY,
	rg LONG,
	nome VARCHAR(255),
	endereco VARCHAR(255),
	numero_casa INTEGER,
	bairro VARCHAR(255),
	telefone_residencial VARCHAR(50),
	telefone_celular VARCHAR(50)
)