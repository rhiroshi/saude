CREATE TABLE prontuario (
	id SERIAL PRIMARY KEY,
	pressao VARCHAR(10),
	data DATE,
	altura DECIMAL,
	peso DECIMAL,
	status VARCHAR(255),
	codigo_paciente BIGINT
);

alter table prontuario add constraint prontuario_paciente_fk foreign key(codigo_paciente) references paciente(cpf);
