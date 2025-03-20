package com.Asis.api.domain.usuario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_completo", length = 100, nullable = false)
    private String nomeCompleto;

    @Column(name = "data_nascimento", nullable = false)
    private java.sql.Date dataNascimento;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "telefone1", length = 16)
    private String telefone1;

    @Column(name = "telefone2", length = 16)
    private String telefone2;

    @Column(name = "nome_mae", length = 100)
    private String nomeMae;

    @Column(name = "cor_raca")
    private Byte corRaca;

    @Column(name = "possui_deficiencia")
    private Boolean possuiDeficiencia;

    @Column(name = "cursoMaisElevadoQueFrequentou")
    private Byte cursoMaisElevadoQueFrequentou;

    @Column(name = "ultimoAnoSerieNoCursoQueFrequentou")
    private Byte ultimoAnoSerieNoCursoQueFrequentou;

    @Column(name = "concluiuOCursoQueFrequentou")
    private Boolean concluiuOCursoQueFrequentou;

    @Column(name = "sabeLerEscrever")
    private Boolean sabeLerEscrever;

    @Column(name = "trabalhouSemanaAnteriorAEntrevista")
    private Boolean trabalhouSemanaAnteriorAEntrevista;

    @Column(name = "estavaAfastadoTrabalhoSemanaAnteriorEntrevista")
    private Boolean estavaAfastadoTrabalhoSemanaAnteriorEntrevista;

    @Column(name = "remuneracaoTrabalhoMesAnteriorEntrevista")
    private Boolean remuneracaoTrabalhoMesAnteriorEntrevista;

    @Column(name = "teveTrabalhoRemunerado12MesesAnterioresEntrevista")
    private Boolean teveTrabalhoRemunerado12MesesAnterioresEntrevista;

    @Column(name = "valorRecebidoAjudaOuDoacao")
    private Integer valorRecebidoAjudaOuDoacao;

    @Column(name = "valorAposentadoriaPensaoPessoas")
    private Integer valorAposentadoriaPensaoPessoas;

    @Column(name = "valorSeguroDesemprego")
    private Integer valorSeguroDesemprego;

    @Column(name = "valorPensaoAlimenticia")
    private Integer valorPensaoAlimenticia;

    @Column(name = "outrasRendas")
    private Integer outrasRendas;

    @Column(name = "identidade", length = 200)
    private String identidade;

    @Column(name = "tituloDeEleitor", length = 200)
    private String tituloDeEleitor;

    @Column(name = "certidaoDeNascimento", length = 200)
    private String certidaoDeNascimento;

    @Column(name = "carteiraDeTrabalho", length = 200)
    private String carteiraDeTrabalho;

    @Column(name = "responsavelFamiliar")
    private Boolean responsavelFamiliar;

    @Column(name = "tipoRelacaoParentescoRF")
    private Byte tipoRelacaoParentescoRF;

    @Column(name = "familia_id", nullable = false)
    private Integer familiaId;
    }