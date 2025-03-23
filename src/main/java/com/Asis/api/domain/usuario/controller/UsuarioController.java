package com.Asis.api.domain.usuario.controller;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioCadastroRequestDTO;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioCadastroResponseDTO;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioLoginRequestDTO;
import com.Asis.api.domain.usuario.controller.mapper.UsuarioMapper;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.service.UsuarioService;
import com.Asis.api.utils.LocalDateTimeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioMapper usuarioMapper;


    @PostMapping("cadastro")
    public ResponseEntity<UsuarioCadastroResponseDTO> save(@RequestBody UsuarioCadastroRequestDTO usuario){
        UsuarioEntity user = usuarioMapper.dtoToEntity(usuario);
        usuarioService.save(user);

        var response = new UsuarioCadastroResponseDTO(
                HttpStatus.CREATED.name(),
                LocalDateTimeConverter.dateTimeConverter(LocalDateTime.now())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody UsuarioLoginRequestDTO loginRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.getCpf(), loginRequestDTO.getSenha());
        System.out.println("A SENHA AQUI" + loginRequestDTO.getSenha());
        var auth = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

}
