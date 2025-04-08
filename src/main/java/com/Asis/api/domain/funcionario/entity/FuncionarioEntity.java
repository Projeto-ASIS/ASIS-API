// package com.Asis.api.domain.funcionario.entity;

// import com.Asis.api.domain.unidade.entity.UnidadeFuncionarioEntity;
// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import java.util.List;

// @Getter
// @Setter
// @Entity
// @Table(name = "tb_funcionario")
// public class FuncionarioEntity {

//     @Id
//     @GeneratedValue(strategy = GenerationType.UUID)
//     private String id;

//     @Column(nullable = false, length = 14)
//     private String cpf;

//     @Column(nullable = false, length = 100)
//     private String nome;

//     @Column(nullable = false, length = 100)
//     private String email;

//     @Column(nullable = false, length = 100)
//     private String senha;

//     @OneToMany(mappedBy = "funcionario_id")
//     private List<UnidadeFuncionarioEntity> funcionarioUnidade;

// }
