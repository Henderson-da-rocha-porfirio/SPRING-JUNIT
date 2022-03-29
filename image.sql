 -- BYTEA é o similar ao BLOB (mysql): Binary Large Object. Isso assegura que toda a nossa informação será salva em formato binário.
create TABLE image(
	id BIGINT NOT NULL,
	name varchar(100) NOT NULL,
	data BYTEA NOT NULL,
	PRIMARY KEY(id)
)

SELECT * FROM image

drop table image
