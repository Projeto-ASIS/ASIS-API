-- Criando tabela para armazenar token de recuperação de senha

CREATE TABLE tb_redefinicao_de_senha(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(6) NOT NULL,
    usuario_id VARCHAR(36) NOT NULL,
    expiration_date TIMESTAMP NOT NULL,
    FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id)
)