alter table medico add column email_usuario VARCHAR(100) not null;
alter table medico add constraint email_fk foreign key(email_usuario) references usuario(email);

alter table paciente add column email_usuario VARCHAR(100) not null;
alter table paciente add constraint email_fk foreign key(email_usuario) references usuario(email);