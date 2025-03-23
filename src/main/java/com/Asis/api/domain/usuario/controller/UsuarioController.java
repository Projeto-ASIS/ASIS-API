package com.Asis.api.domain.usuario.controller;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioCadastroRequestDTO;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioCadastroResponseDTO;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioLoginRequestDTO;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioLoginResponseDTO;
import com.Asis.api.domain.usuario.controller.mapper.UsuarioMapper;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.service.UsuarioService;
import com.Asis.api.infra.security.TokenService;
import com.Asis.api.utils.LocalDateTimeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioMapper usuarioMapper;
    private final TokenService tokenService;


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
    public ResponseEntity<UsuarioLoginResponseDTO> login(@RequestBody UsuarioLoginRequestDTO loginRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.cpf(), loginRequestDTO.senha());
        var auth = authenticationManager.authenticate(usernamePassword);
        var usuario = (UsuarioEntity) auth.getPrincipal();
        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());


        UsuarioLoginResponseDTO response = new UsuarioLoginResponseDTO(usuario,token);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("testeUsuario")
    public ResponseEntity<HashMap<String,String>> teste(){
        var response = new HashMap<String,String>();
        response.put("RESPOSTA","PEGOU, USUARIO!");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("testeFuncionario")
    public ResponseEntity<HashMap<String,String>> testeFuncionario(){
        var response = new HashMap<String,String>();
        response.put("RESPOSTA","PEGOU, FUNCIONARIO!");
        return ResponseEntity.ok().body(response);
    }

}
