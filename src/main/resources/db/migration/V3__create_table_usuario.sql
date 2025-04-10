-- Criando Tabela Usuario --
CREATE TABLE tb_usuario (
    id VARCHAR(36) PRIMARY KEY,
    role VARCHAR(16) NOT NULL DEFAULT 'ROLE_USUARIO',
    nome_completo VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    nis VARCHAR(14) NULL,
    cadunico VARCHAR(12) NULL,
    deficiencia TINYINT NULL,
    email VARCHAR(100) NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone1 VARCHAR(16),
    telefone2 VARCHAR(16),
    nome_mae VARCHAR(100)
);

