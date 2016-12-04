CREATE TABLE receita(
	codigo BIGINT PRIMARY KEY,
	consulta BIGINT,
	FOREIGN KEY(consulta) REFERENCES consulta(id)
);


CREATE TABLE pedido_medicamento(
	codigo SERIAL PRIMARY KEY,
	produto BIGINT,
	receita BIGINT,
	quantidade INT,
	FOREIGN KEY(produto) REFERENCES produto(codigo),
	FOREIGN KEY(receita) REFERENCES receita(codigo)
);