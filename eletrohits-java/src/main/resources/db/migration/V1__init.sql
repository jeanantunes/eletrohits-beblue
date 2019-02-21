DROP TABLE IF EXISTS discos;
CREATE TABLE discos(
  id INT PRIMARY KEY,
  genero VARCHAR (50) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  valor BIGINT NOT NULL
);

INSERT INTO discos VALUES (1,'Rock','Raul Seixas',19.90);
INSERT INTO discos VALUES (2,'Rock','Nirvana',59.99);
INSERT INTO discos VALUES (3,'Rock','Sepultura',19.90);
INSERT INTO discos VALUES (4,'Rock','Beatles',20.0);
INSERT INTO discos VALUES (5,'Rock','Paranauê',9.99);