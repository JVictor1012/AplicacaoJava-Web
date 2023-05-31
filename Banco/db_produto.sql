CREATE DATABASE db_produto;

USE db_produto;

CREATE TABLE produto (
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(255) NOT NULL CHECK (LENGTH(descricao) >= 20)
);

INSERT INTO produto (descricao) VALUES ('teclado - um dispositivo de entrada para computadores');
INSERT INTO produto (descricao) VALUES ('mouse - um dispositivo de controle para o cursor do computador');

select * from produto