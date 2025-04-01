-- Criando tabela de serviços

CREATE TABLE tb_servico(
    id UUID NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    comoAcessar VARCHAR(500) NOT NULL,
    linkAcesso VARCHAR(100) NULL
);