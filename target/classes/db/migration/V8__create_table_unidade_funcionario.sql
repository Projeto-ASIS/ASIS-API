-- Criando tabela intermédiaria entre unidade e funcionário

CREATE TABLE tb_unidade_Funcionario(
    funcao VARCHAR(45) NOT NULL,
    unidade_id BIGINT NOT NULL,
    funcionario_id BIGINT NOT NULL,
    PRIMARY KEY(unidade_id, funcionario_id),
    FOREIGN KEY(unidade_id) REFERENCES tb_unidadeSUAS(id),
    FOREIGN KEY(funcionario_id) REFERENCES tb_funcionario(id)
);