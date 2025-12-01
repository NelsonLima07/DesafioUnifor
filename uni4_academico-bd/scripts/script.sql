create table aluno
(
id serial not null primary key,
datacadastro date not null default current_date,
horacadastro time not null default current_time,
nome varchar(120) not null,
email varchar(80) not null,
keycloak_id integer not null,
delete_at timestamp default null
)

create table professor
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(120) not null,
email varchar(80) not null,
keycloak_id integer not null
)

create table coordenador
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(120) not null,
email varchar(80) not null,
keycloak_id integer not null
)

create table curso
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
nome varchar(60) not null,
qtdsemestres integer not null,
delete_at timestamp default null
)

create table curso_disciplina
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
id_curso integer not null,
disciplina varchar(60) not null,
numsemestre integer not null,

foreign KEY (id_curso) REFERENCES curso(id) ON DELETE CASCADE
)

create table aluno_curso
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
id_aluno integer not null,
id_curso integer not null,
matricula integer not null,
numsemestre integer not null default 1,

foreign key (id_aluno) REFERENCES aluno(id),
foreign key (id_curso) REFERENCES curso(id)
)

create table semestre
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
numsemestre integer not null,
ano integer not null,
id_coordenador integer not null,

foreign key (id_coordenador) REFERENCES coordenador(id)
)

create table semestre_aluno
(
id serial not null primary key,
datacadastro date not null,
horacadastro time not null,
id_semestre integer not null,
id_alunocurso integer not NULL,
id_disciplina INTEGER NOT NULL,
id_professor integer not null,
cod_status integer not null,
nota numeric(3,1) default null,
faltas integer default null,

foreign key (id_semestre) REFERENCES semestre(id),
foreign key (id_alunocurso) REFERENCES aluno_curso(id),
foreign key (id_disciplina) REFERENCES curso_disciplina(id),
foreign key (id_professor) REFERENCES professor(id)
)


