-- Criando tabela de endereço

CREATE TABLE tb_endereco (
    id UUID NOT NULL PRIMARY KEY,
    UF VARCHAR(2) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    CEP VARCHAR(9),
    numero INT NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100) NOT NULL
);
