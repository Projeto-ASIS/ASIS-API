-- Criando tabela de agendamento

CREATE TABLE tb_agendamento(
    id UUID NOT NULL PRIMARY KEY,
    data_solicitado DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_resolvido DATETIME NULL,
    descricao VARCHAR(200) NULL,
    status_agendamento TINYINT NOT NULL DEFAULT 1,
    servico_id UUID NOT NULL,
    usuario_id UUID NOT NULL,
    funcionario_id UUID NULL,
    FOREIGN KEY(servico_id) REFERENCES tb_servico(id),
    FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id),
    FOREIGN KEY(funcionario_id) REFERENCES tb_funcionario(id)
);