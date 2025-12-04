insert into curso(nome, qtdsemestres) values('Direito', 10);
insert into curso(nome, qtdsemestres) values('Informmática', 8);
insert into curso(nome, qtdsemestres) values('Medicina', 10);

insert into professor(nome, email, keycloak_id) values('Jesus Cristo', 'jesus.cristo@uni4.com', gen_random_uuid());
insert into professor(nome, email, keycloak_id) values('Albert Einstein', 'albert.einstein@uni4.com', gen_random_uuid());
insert into professor(nome, email, keycloak_id) values('Isaac Newton', 'isaac.newton@uni4.com', gen_random_uuid());
insert into professor(nome, email, keycloak_id) values('Raimundo Nonato', 'albert.einstein@uni4.com', gen_random_uuid());
insert into professor(nome, email, keycloak_id) values('Marcelo Gleiser', 'marcelo.gleiser@uni4.com', gen_random_uuid());
insert into professor(nome, email, keycloak_id) values('Clóvis de Barros', 'clovis.barros@uni4.com',gen_random_uuid());
insert into professor(nome, email, keycloak_id) values('Charles Darwin', 'charles.darwin@uni4.com',gen_random_uuid());
 
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('História', 1, 1, 4);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Literatura', 1, 2, 5);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Filosofia', 1, 3, 6);

insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Matemática', 2, 1, 2);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Algoritmo', 2, 2, 3);

insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Biologia', 3, 1, 7);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Filosofia', 3, 2, 6);
