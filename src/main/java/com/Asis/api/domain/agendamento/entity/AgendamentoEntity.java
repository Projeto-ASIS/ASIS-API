package com.Asis.api.domain.agendamento.entity;

import com.Asis.api.domain.agendamento.entity.enums.StatusAgendamento;
import com.Asis.api.domain.funcionario.entity.FuncionarioEntity;
import com.Asis.api.domain.servico.entity.ServicoEntity;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_agendamento")
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "data_solicitado")
    private LocalDateTime dataSolicitado;

    @Column(name = "data_resolvido")
    private LocalDateTime dataResolvido;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, name = "status_agendamento")
    @Enumerated(EnumType.ORDINAL)
    private StatusAgendamento statusAgendamento;

    @OneToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToOne()
    @JoinColumn(name = "servico_id", nullable = false)
    private ServicoEntity servico;

    @OneToOne()
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity funcionario;
}
