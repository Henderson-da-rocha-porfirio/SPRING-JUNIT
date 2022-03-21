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
