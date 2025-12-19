insert into curso(nome, qtdsemestres) values('Direito', 10);
insert into curso(nome, qtdsemestres) values('Informmática', 8);
insert into curso(nome, qtdsemestres) values('Medicina', 10);

insert into coordenador(nome, email, keycloak_id) values('Coordenador', 'coordenador', '6d3a6edc-8df9-478c-972c-ec30cd4d9060');

insert into professor(nome, email, keycloak_id) values('Jesus Cristo', 'jesus.cristo@uni4.com', 'b7ec9716-14a4-48f0-8ec3-9d0d8166f069');
insert into professor(nome, email, keycloak_id) values('Albert Einstein', 'albert.einstein@uni4.com', '5c5b4469-edaa-4aa1-990f-edf0e27c158c');
insert into professor(nome, email, keycloak_id) values('Isaac Newton', 'isaac.newton@uni4.com', 'a0b33473-d78b-414b-8818-9c973a3ee26d');
insert into professor(nome, email, keycloak_id) values('Raimundo Nonato', 'raimundo.nonato@uni4.com', '0a02e888-627d-433a-be7e-00462f74c9e6');
insert into professor(nome, email, keycloak_id) values('Marcelo Gleiser', 'marcelo.gleiser@uni4.com', '95aa3ef3-d7ad-4923-a266-7807231c5bad');
insert into professor(nome, email, keycloak_id) values('Clóvis de Barros', 'clovis.barros@uni4.com','89eb8713-0a58-4a59-9f1e-4aba0a05e3a7');
insert into professor(nome, email, keycloak_id) values('Charles Darwin', 'charles.darwin@uni4.com','282ba469-b333-4fd9-9959-3856b062d30d');
 
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('História', 1, 1, 4);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Literatura', 1, 2, 5);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Filosofia', 1, 3, 6);

insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Matemática', 2, 1, 2);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Algoritmo', 2, 2, 3);

insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Biologia', 3, 1, 7);
insert into curso_disciplina(disciplina, id_curso, numsemestre, id_professor) values('Filosofia', 3, 2, 6);


