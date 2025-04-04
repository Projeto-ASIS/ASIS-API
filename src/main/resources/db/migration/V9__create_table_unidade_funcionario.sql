-- Criando tabela intermédiaria entre unidade e funcionário

CREATE TABLE tb_unidade_funcionario(
    unidade_id BIGINT NOT NULL,
    funcionario_id VARCHAR(36) NOT NULL,
    funcao VARCHAR(45),
    PRIMARY KEY(unidade_id, funcionario_id),
    FOREIGN KEY(unidade_id) REFERENCES tb_unidade_suas(id),
    FOREIGN KEY(funcionario_id) REFERENCES tb_funcionario(id)
);