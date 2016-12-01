create table consulta (
	id serial primary key,
	codigo_prontuario integer not null,
	cpf_medico BIGINT not null,
	prescricao TEXT
);

alter table consulta add constraint consulta_medico_fk foreign key(cpf_medico) references medico(cpf);
alter table consulta add constraint consulta_prontuario_fk foreign key(codigo_prontuario) references prontuario(id);