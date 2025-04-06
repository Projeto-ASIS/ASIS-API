package com.Asis.api.configurations.seeding;

import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.agendamento.repository.AgendamentoRepository;
import com.Asis.api.domain.servico.entity.ServicoEntity;
import com.Asis.api.domain.servico.repository.ServicoRepository;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.Asis.api.domain.usuario.entity.enums.RoleEnum;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class DatabaseSeeding implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;
    private final AgendamentoRepository agendamentoRepository;
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

        ServicoEntity servico1 = new ServicoEntity();
        servico1.setNome("CadÚnico");
        servico1.setComoAcessar("Vá no CRAS mais próximo da sua residência");
        servico1.setDescricao("Programa do governo para cadastrar família carentes");
        servico1.setLinkAcesso("http://cadunico.gov.br");

        servicoRepository.save(servico1);

        AgendamentoEntity agendamento1 = new AgendamentoEntity();
        agendamento1.setDataAtendimento(LocalDate.now().plusDays(3L));
        agendamento1.setServico(servico1);
        agendamento1.setUsuario(usuario);

        agendamentoRepository.save(agendamento1);
    }
}
