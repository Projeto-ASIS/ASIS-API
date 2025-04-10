package com.Asis.api.domain.recuperarSenha.controller;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Asis.api.domain.recuperarSenha.entity.RedefinicaoDeSenhaEntity;
import com.Asis.api.domain.recuperarSenha.repository.TokenRedefinicaoDeSenhaRepository;
import com.Asis.api.domain.recuperarSenha.service.EmailService;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController("redefinicaoDeSenha")
public class RecuperarSenhaController {

    private final UsuarioService usuarioService;

    private final TokenRedefinicaoDeSenhaRepository redefinicaoDeSenhaRepository;

    private final EmailService emailService;

    private final PasswordEncoder encoder;

    private static final SecureRandom random = new SecureRandom();


    @PostMapping("/esqueci-senha")
    public ResponseEntity<?> solicitarRedefinicaoSenha(@RequestParam String email) {

        UsuarioEntity usuario = usuarioService.buscaUsuarioPeloEmail(email);

        if (usuario == null) {
            return ResponseEntity.badRequest().body("E-mail não encontrado");
        }

        String codigo = String.valueOf(100000 + random.nextInt(900000));
        var entity = new RedefinicaoDeSenhaEntity(codigo, usuario);

        redefinicaoDeSenhaRepository.save(entity);

        emailService.enviarEmailRedefinicaoSenha(usuario.getEmail(), codigo);

        return ResponseEntity.ok("E-mail de redefinição enviado, cheque sua caixa de SPAM.");
    }



    @PostMapping("/redefinir-senha")
    public ResponseEntity<?> redefinirSenha(
            @RequestParam String codigo,
            @RequestParam String novaSenha) {

        var resetcodigo = redefinicaoDeSenhaRepository.findByCodigo(codigo);
        if (resetcodigo == null || resetcodigo.getExpirationDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("codigo inválido ou expirado.");
        }

        UsuarioEntity usuario = resetcodigo.getUsuario();
        usuario.setSenha(encoder.encode(novaSenha));
        usuarioService.atualizarSenha(usuario);

        redefinicaoDeSenhaRepository.delete(resetcodigo);

        return ResponseEntity.ok("Senha redefinida com sucesso!");
    }

}
