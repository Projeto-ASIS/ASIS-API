package com.Asis.api.domain.funcionario.entity;

import com.Asis.api.domain.unidade.entity.UnidadeFuncionarioEntity;
import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @OneToMany(mappedBy = "funcionario_id")
    private List<UnidadeFuncionarioEntity> funcionarioUnidade;

}
