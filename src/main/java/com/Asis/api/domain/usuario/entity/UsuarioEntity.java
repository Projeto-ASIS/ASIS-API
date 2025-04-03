package com.Asis.api.domain.usuario.entity;

import com.Asis.api.domain.familia.entity.FamiliaEntity;
import com.Asis.api.domain.usuario.entity.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.ROLE_USUARIO;

    @Column(name = "nome_completo", length = 100, nullable = false)
    private String nomeCompleto;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

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

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "cor_raca")
    private CorRacaENUM corRaca;

    @Column(name = "possui_deficiencia")
    private Boolean possuiDeficiencia;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "cursoMaisElevadoQueFrequentou")
    private CursoMaisElevadoQueFrequentouENUM cursoMaisElevadoQueFrequentou;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "ultimoAnoSerieNoCursoQueFrequentou")
    private UltimoAnoSerieNoCursoQueFrequentouENUM ultimoAnoSerieNoCursoQueFrequentou;

    @Column(name = "concluiuOCursoQueFrequentou")
    private  Boolean concluiuOCursoQueFrequentou;

    @Column(name = "sabeLerEEscrever")
    private Boolean sabeLerEEscrever;

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

    @Column(name = "valorAposentadoriaPensaoBpcLoas")
    private Integer valorAposentadoriaPensaoBpcLoas;

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

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "tipoRelacaoParentescoRF")
    private TipoRelacaoParentescoRFENUM tipoRelacaoParentescoRF;

    @Column
    private Boolean responsavelFamiliar;

    @ManyToOne
    @JoinColumn(name="familia_id")
    private FamiliaEntity familiaId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == RoleEnum.ROLE_USUARIO){
            return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
        }
        if(role == RoleEnum.ROLE_FUNCIONARIO){
            return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"), new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
        }
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public String getUsername() {
        return this.getCpf();
    }
}