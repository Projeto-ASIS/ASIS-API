package com.Asis.api.configurations.seeding;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.entity.enums.RoleEnum;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@RequiredArgsConstructor
@Configuration
public class DatabaseSeeding implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        UsuarioEntity funcionario = new UsuarioEntity();
        funcionario.setCpf("123");
        funcionario.setNomeCompleto("Elizarde Ferreira da Costa");
        funcionario.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario.setSenha(encoder.encode("funcionario"));
        funcionario.setEmail("email");
        funcionario.setDataNascimento(LocalDate.now().minusYears(10));

        usuarioRepository.save(funcionario);
    }
}
