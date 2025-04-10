-- Criando tabela intermédiaria entre unidade e funcionário

CREATE TABLE tb_unidade_funcionario(
    unidade_id INTEGER NOT NULL,
    usuario_id VARCHAR(36) NOT NULL,
    funcao VARCHAR(45),
    PRIMARY KEY(unidade_id, usuario_id),
    FOREIGN KEY(unidade_id) REFERENCES tb_unidade_suas(id),
    FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id)
);