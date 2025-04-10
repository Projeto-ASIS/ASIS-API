package com.Asis.api.domain.agendamento.entity;

import com.Asis.api.domain.agendamento.entity.enums.StatusAgendamento;
import com.Asis.api.domain.servico.entity.ServicoEntity;
import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_agendamento")
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "data_solicitado")
    private LocalDate dataSolicitado = LocalDate.now();

    @Column(name = "data_atendimento")
    private LocalDate dataAtendimento;

    @Column(length = 200)
    private String descricao;

    @Column(name = "status_agendamento")
    private byte statusAgendamento = (byte) StatusAgendamento.PENDENTE.getCode();

    @OneToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToOne()
    @JoinColumn(name = "funcionario_id", nullable = false)
    private UsuarioEntity funcionario;

    @OneToOne()
    @JoinColumn(name = "servico_id", nullable = false)
    private ServicoEntity servico;

    @OneToOne()
    @JoinColumn(name = "unidade_id", nullable = false)
    private UnidadeSUASEntity unidade;
}
