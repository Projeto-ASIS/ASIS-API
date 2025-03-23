package com.Asis.api.infra.security;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.token}")
    private String secret;

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));
    }

    public String generateToken(UsuarioEntity user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("asis-pi")
                    .withSubject(user.getCpf())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);

            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token");
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e) {
            return "";
        }
    }
}
