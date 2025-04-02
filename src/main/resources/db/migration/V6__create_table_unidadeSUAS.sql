-- Criando tabela de unidade

CREATE TABLE tb_unidadeSUAS (
    id UUID NOT NULL PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cadSuas INT NOT NULL UNIQUE,
    enderecoUnidade_id UUID NOT NULL,
    gestor_id UUID NOT NULL,
    UNIQUE(gestor_id),
    FOREIGN KEY (enderecoUnidade_id) REFERENCES tb_endereco(id),
    FOREIGN KEY (gestor_id) REFERENCES tb_funcionario(id)
);
