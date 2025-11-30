Create table aluno
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(120) not null,
email varchar(80) not null,
matricula varchar(20) not null,
keycloak_id integer not null,
delete_at timestamp default null
)

create table professor
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(120) not null,
keycloak_id integer not null
)

create table coordenador
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(120) not null,
keycloak_id integer not null
)

create table curso
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(60) not null
qtdsemestres integer not null,
delete_at timestamp default null
)

create table curso_disciplina
(
id serial not null primary key,
datacadastro date not null,
horacadastro time note null,
id_curso integer not null,
diciplina varchar(60) not null,
numsemestre integer not null,

foreign key id_curso REFERENCES curso(id) on delete cascade
)

create table semestre
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
numsemestre integer not null,
ano integer not null,
id_coorenador integer not null
)

create table semestre_aluno
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
id_semestre integer not null,
id_aluno integer not null,
id_professor integer not null,
cod_status integer not null,
nota numeric(3,1) default null,
faltas integer default null,

foreign key id_semestre REFERENCES semestre(id),
foreign key id_aluno REFERENCES aluno(id),
foreign key id_professor REFERENCES professor(id)
)


