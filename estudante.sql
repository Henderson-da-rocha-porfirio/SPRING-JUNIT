create table estudante(
id SERIAL PRIMARY KEY,
lname varchar(20),
fname varchar(20),
score int
)

SELECT * FROM estudante_id_seq

SELECT * FROM estudante

TRUNCATE estudante RESTART IDENTITY;

ALTER SEQUENCE estudante_id_seq RESTART WITH 1;

UPDATE estudante SET id=nextval('estudante_id_seq');

drop table estudante


-- Exemplo de Correcao de erro em postgresql onde não se consegue salvar novos ID's: Erro: duplicate key value violates unique constraint

SELECT * FROM paciente

select setval('paciente_id_seq', (select max(id) from paciente))

SELECT * FROM paciente_id_seq
