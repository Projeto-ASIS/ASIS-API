-- Criando tabela de agendamento

CREATE TABLE tb_agendamento(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_solicitado DATE NOT NULL,
    data_atendimento DATE NULL,
    descricao VARCHAR(200) NULL,
    status_agendamento TINYINT NOT NULL DEFAULT 1,
    servico_id INTEGER NOT NULL,
    usuario_id VARCHAR(36) NOT NULL,
    funcionario_id VARCHAR(36) NULL,
    unidade_id INTEGER NOT NULL,
    FOREIGN KEY(servico_id) REFERENCES tb_servico(id),
    FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id),
    FOREIGN KEY(funcionario_id) REFERENCES tb_usuario(id),
    FOREIGN KEY(unidade_id) REFERENCES tb_unidade_suas(id)
);