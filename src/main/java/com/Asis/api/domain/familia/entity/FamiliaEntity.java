package com.Asis.api.domain.familia.entity;

import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.familia.entity.enums.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "tb_familia")
@Entity
public class FamiliaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nomeRF;

    @Column(nullable = false)
    private Integer quantidadeIntegrantes;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private StatusCadastralENUM statusCadastral;

    @Column(nullable = false)
    private LocalDateTime ultimaAtualizacao;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private Integer rendaTotal;

    @Column(nullable = false)
    private Integer rendaPerCapta;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoLocalDomicilioENUM tipoLocalDomicilio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoEspecieDomicilioENUM tipoEspecieDomicilio;

    @Column(nullable = false)
    private Integer quantidadeComodos;

    @Column(nullable = false)
    private Integer quantidadeComodosDormitorio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoMaterialPisoDomicilioENUM tipoMaterialPisoDomicilio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoMaterialParedeDomicilioENUM tipoMaterialParedeDomicilio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoAbastecimentoDomicilioENUM tipoAbastecimentoDomicilio;

    @Column(nullable = false)
    private Boolean temBanheiro;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private FormaEscoamentoDomicilioENUM formaEscoamentoDomicilio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoDestinoLixoDomicilioENUM tipoDestinoLixoDomicilio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoIluminacaoDomicilioENUM tipoIluminacaoDomicilio;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoCalcamentoDomicilioENUM tipoCalcamentoDomicilio;

    @Column(nullable = false)
    private Integer valorDespesasEnergia;

    @Column(nullable = false)
    private Integer valorDespesasAguaEsgoto;

    @Column(nullable = false)
    private Integer valorDespesasGas;

    @Column(nullable = false)
    private Integer valorDespesasAlimentacao;

    @Column(nullable = false)
    private Integer valorDespesasTransporte;

    @Column(nullable = false)
    private Integer valorDespesasAluguel;

    @Column(nullable = false)
    private Integer valorDespesasMedicamentos;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = true)
    private TipoGrupoTradicionalENUM tipoGrupoTradicional;

    @Column(nullable = false)
    private Boolean familiaIndigena;

    @Column(nullable = true)
    private Integer numeroPovoIndigena;

    @Column(nullable = true)
    private Integer numeroReservaIndigena;

    @Column(nullable = false)
    private Boolean familiaQuilombola;

    @Column(nullable = true)
    private Boolean numeroComunidadeQuilombola;

    @Column(nullable = false)
    private Integer quantidadePessoasDomicilio;

    @Column(nullable = false)
    private Integer quantidadeFamiliasDomicilio;

    @Column(length = 100, nullable = true)
    private String nomeEstabelecimentoSaude;

    @Column(nullable = true)
    private Integer cnesEstabelecimentoSaude;

    @Column(length = 100, nullable = true)
    private String nomeCrasCreas;

    @Column(nullable = true)
    private Integer numeroCrasCreas;

    @Column(nullable = false)
    private Integer quantidadeInternados0a17;

    @Column(nullable = false)
    private Integer quantidadeInternados18a59;

    @Column(nullable = false)
    private Integer quantidadeInternadosAcima60;

    @Column(nullable = false)
    private Boolean familiaRiscoInsegurancaAlimentar;

    @Column(nullable = false)
    private Boolean familiaSituacaoRua;

    @ManyToOne
    @JoinColumn(name = "enderecoFamilia_id", nullable = false)
    private EnderecoEntity enderecoFamilia;
}
