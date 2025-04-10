package com.Asis.api.domain.recuperarSenha.entity;

import java.time.LocalDateTime;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_redefinicao_de_senha")
public class RedefinicaoDeSenhaEntity {
    

    private static final Long EXPIRATION = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "usuario_id")
    private UsuarioEntity usuario;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    public RedefinicaoDeSenhaEntity(String codigo, UsuarioEntity usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.expirationDate = calcularDataExpiracao(EXPIRATION);
    }

    private LocalDateTime calcularDataExpiracao(Long tempoMinutos) {
        return LocalDateTime.now().plusMinutes(tempoMinutos);
    }

}
