package com.Asis.api.configurations.seeding;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.entity.enums.RoleEnum;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import com.Asis.api.utils.UtilsConverter;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Configuration
public class DatabaseSeeding implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        UsuarioEntity funcionario = new UsuarioEntity();
        funcionario.setCpf("12312312312");
        funcionario.setNomeCompleto("Elizarde Ferreira da Costa");
        funcionario.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario.setSenha(encoder.encode("funcionario"));
        funcionario.setEmail("funcionario@gmail.com");
        funcionario.setDataNascimento(LocalDate.now().minusYears(10));

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCpf("70766299414");
        usuario.setNomeCompleto("Huann Vicente");
        usuario.setSenha(encoder.encode("Azxc123@"));
        usuario.setEmail("huannvicente14@outlook.com");
        usuario.setDataNascimento(LocalDate.of(2004,03,23));

        usuarioRepository.saveAll(List.of(funcionario,usuario));
    }
}
