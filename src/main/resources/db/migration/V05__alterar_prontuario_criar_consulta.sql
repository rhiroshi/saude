alter table prontuario drop column data;

create table consulta (
	id serial primary key,
	codigo_prontuario integer not null,
	codigo_medico integer not null
	
);

alter table consulta add constraint consulta_medico_fk foreign key(codigo_medico) references medico(crm);
alter table consulta add constraint consulta_prontuario_fk foreign key(codigo_prontuario) references prontuario(id);