-- Criando tabela de funcionários

CREATE TABLE tb_funcionario(
    id UUID NOT NULL PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);