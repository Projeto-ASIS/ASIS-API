-- Criando tabela de unidade

CREATE TABLE tb_unidade_suas (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cadsuas VARCHAR(11) NOT NULL UNIQUE,
    endereco_unidade_id BIGINT NOT NULL,
    gestor_id VARCHAR(36) NOT NULL,
    UNIQUE(gestor_id),
    FOREIGN KEY (endereco_unidade_id) REFERENCES tb_endereco(id),
    FOREIGN KEY (gestor_id) REFERENCES tb_usuario(id)
);
