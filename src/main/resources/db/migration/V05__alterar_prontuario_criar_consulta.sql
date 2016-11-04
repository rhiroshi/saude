alter table prontuario drop column prescricao;
alter table prontuario add column codigo_paciente integer;
alter table prontuario add constraint prontuario_paciente_fk foreign key(codigo_paciente) references paciente(cpf);

create table consulta (
	id serial primary key,
	codigo_prontuario integer not null,
	codigo_medico integer not null,
	prescricao TEXT
);

alter table consulta add constraint consulta_medico_fk foreign key(codigo_medico) references medico(crm);
alter table consulta add constraint consulta_prontuario_fk foreign key(codigo_prontuario) references prontuario(id);