-- Criando tabela de unidade

CREATE TABLE tb_unidadeSUAS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cadSuas INT NOT NULL UNIQUE,
    enderecoUnidade_id BIGINT NOT NULL,
    FOREIGN KEY (enderecoUnidade_id) REFERENCES tb_endereco(id)
);
