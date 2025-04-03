-- Criando tabela de funcionários

CREATE TABLE tb_funcionario(
    id VARCHAR(36) PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);