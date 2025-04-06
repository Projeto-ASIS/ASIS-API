package com.Asis.api.domain.usuario.entity;

import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.usuario.entity.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
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

    @Column(name = "nis", length = 14)
    private String nis;

    @Column(name = "cadunico", length = 12)
    private String cadunico;

    @Column(name = "deficiencia")
    private TipoDeficienciaEnum deficiencia;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

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