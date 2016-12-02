CREATE TABLE produto (
	codigo SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT NOT NULL,
	estoque INTEGER,
	reserva INTEGER
);