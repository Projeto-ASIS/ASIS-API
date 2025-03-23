-- Criando tabela de agendamento

CREATE TABLE tb_agendamento(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_solicitado DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_resolvido DATETIME NULL,
    descricao VARCHAR(200) NULL,
    status_agendamento TINYINT NOT NULL DEFAULT 1,
    servico_id INTEGER NOT NULL,
    usuario_id BIGINT NOT NULL,
    funcionario_id BIGINT NULL,
    FOREIGN KEY(servico_id) REFERENCES tb_servico(id),
    FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id),
    FOREIGN KEY(funcionario_id) REFERENCES tb_funcionario(id)
);