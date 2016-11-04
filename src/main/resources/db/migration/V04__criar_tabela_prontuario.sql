CREATE TABLE prontuario(
	id INTEGER PRIMARY KEY,
	pressao VARCHAR(10),
	data DATE,
	prescricao VARCHAR(512),
	altura DECIMAL,
	peso DECIMAL,
	status VARCHAR(255)
);
