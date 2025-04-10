package com.Asis.api.domain.usuario.controller;

import com.Asis.api.domain.usuario.controller.DTO.request.UsuarioCadastroRequestDTO;
import com.Asis.api.domain.usuario.controller.DTO.request.UsuarioLoginRequestDTO;
import com.Asis.api.domain.usuario.controller.DTO.response.UsuarioDetalhesResponseDTO;
import com.Asis.api.domain.usuario.controller.DTO.response.UsuarioLoginResponseDTO;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.service.UsuarioService;
import com.Asis.api.infra.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("cadastro")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioCadastroRequestDTO usuario) {

        UsuarioEntity user = UsuarioCadastroRequestDTO.toEntity(usuario);

        usuarioService.registrarUsuario(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso");
    }

    @PostMapping("login")
    public ResponseEntity<UsuarioLoginResponseDTO> login(@RequestBody UsuarioLoginRequestDTO loginRequestDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.cpf(), loginRequestDTO.senha());
        var auth = authenticationManager.authenticate(usernamePassword);
        var usuario = (UsuarioEntity) auth.getPrincipal();
        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

        UsuarioLoginResponseDTO response = new UsuarioLoginResponseDTO(usuario, token);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDetalhesResponseDTO> buscarUsuario(@PathVariable String id) {

        UsuarioEntity usuario = usuarioService.buscarUsuario(id);

        var response = new UsuarioDetalhesResponseDTO(usuario);

        return ResponseEntity.ok(response);
    }
}
