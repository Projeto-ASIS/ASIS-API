package com.Asis.api.domain.usuario.service;

import java.util.Optional;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
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


    public UsuarioEntity registrarUsuario(UsuarioEntity usuario){
        
        if(usuarioRepository.findByCpf(usuario.getCpf()) != null){
            throw new DuplicateKeyException("CPF já cadastrado");
        }

        usuario.setSenha(encoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }



    public UsuarioEntity buscarUsuario(String id){

        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);

        if(!usuario.isPresent()) throw new EntityNotFoundException("Usuario não encontrado");        
        
        return usuario.get();
    }



    public UsuarioEntity buscaUsuarioPeloEmail(String email){
        return usuarioRepository.findByEmail(email);
    }


    
    public UsuarioEntity atualizarSenha(UsuarioEntity entity){
        return usuarioRepository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return usuarioRepository.findByCpf(cpf);
    }
}
