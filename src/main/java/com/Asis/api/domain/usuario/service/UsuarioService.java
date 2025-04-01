package com.Asis.api.domain.usuario.service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.exception.businessException.UsuarioNotFoundException;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import com.Asis.api.utils.UtilsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public UsuarioEntity save(UsuarioEntity usuario){
        usuario.setSenha(
                encoder.encode(usuario.getPassword())
        );
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity findAuthenticateUser(UUID id){
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        System.out.println("ID PRESENTE: " + id.toString());
        if(!usuario.isPresent()) throw new UsuarioNotFoundException("Usuario não encontrado");        
        
        return usuario.get();
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return usuarioRepository
            .findByCpf(cpf);
    }
}
