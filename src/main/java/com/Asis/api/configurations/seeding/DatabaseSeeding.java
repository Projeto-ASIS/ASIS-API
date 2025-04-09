package com.Asis.api.configurations.seeding;

import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.agendamento.repository.AgendamentoRepository;
import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.servico.entity.ServicoEntity;
import com.Asis.api.domain.servico.repository.ServicoRepository;
import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;
import com.Asis.api.domain.unidade.repository.UnidadeSUASRepository;
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
    private final UnidadeSUASRepository unidadeSUASRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

        // CADASTANDO USUÁRIOS COMUNS NO SISTEMA
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCpf("15436537213");
        usuario.setNomeCompleto("Huann Vicente");
        usuario.setSenha(encoder.encode("Azxc123@"));
        usuario.setEmail("huannvicente14@outlook.com");
        usuario.setDataNascimento(LocalDate.of(2004, 03, 23));

        UsuarioEntity usuario2 = new UsuarioEntity();
        usuario2.setCpf("15328539512");
        usuario2.setNomeCompleto("Alisson Lima");
        usuario2.setSenha(encoder.encode("12345678"));
        usuario2.setEmail("Alisson@gmail.com");
        usuario2.setDataNascimento(LocalDate.of(2004, 03, 23));

        UsuarioEntity usuario3 = new UsuarioEntity();
        usuario3.setCpf("16302938412");
        usuario3.setNomeCompleto("Letícia Alcântara");
        usuario3.setSenha(encoder.encode("12345678"));
        usuario3.setEmail("leticia@gmail.com");
        usuario3.setDataNascimento(LocalDate.of(2004, 03, 23));

        UsuarioEntity usuario4 = new UsuarioEntity();
        usuario4.setCpf("16302938413");
        usuario4.setNomeCompleto("José Gabriel");
        usuario4.setSenha(encoder.encode("12345678"));
        usuario4.setEmail("jose@gmail.com");
        usuario4.setDataNascimento(LocalDate.of(2004, 03, 23));

        usuarioRepository.saveAll(List.of(usuario, usuario2, usuario3, usuario4));



        // CADASTRANDO FUNCIONÁRIOS
        UsuarioEntity funcionario1 = new UsuarioEntity();
        funcionario1.setCpf("12312312312");
        funcionario1.setNomeCompleto("Maria do Socorro Moreira Gonçalves");
        funcionario1.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario1.setSenha(encoder.encode("funcionario"));
        funcionario1.setEmail("funcionario1@gmail.com");
        funcionario1.setDataNascimento(LocalDate.now().minusYears(30));
        
        UsuarioEntity funcionario2 = new UsuarioEntity();
        funcionario2.setCpf("12312312313");
        funcionario2.setNomeCompleto("Vanessa Mendes do Monte de França");
        funcionario2.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario2.setSenha(encoder.encode("funcionario"));
        funcionario2.setEmail("funcionario2@gmail.com");
        funcionario2.setDataNascimento(LocalDate.now().minusYears(35));
        
        UsuarioEntity funcionario3 = new UsuarioEntity();
        funcionario3.setCpf("12312312314");
        funcionario3.setNomeCompleto("Andresa de Fátima Salvador Barbose");
        funcionario3.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario3.setSenha(encoder.encode("funcionario"));
        funcionario3.setEmail("funcionario3@gmail.com");
        funcionario3.setDataNascimento(LocalDate.now().minusYears(40));
        
        UsuarioEntity funcionario4 = new UsuarioEntity();
        funcionario4.setCpf("12312312315");
        funcionario4.setNomeCompleto("Cláudia Rejane da Silva Braga");
        funcionario4.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario4.setSenha(encoder.encode("funcionario"));
        funcionario4.setEmail("funcionario4@gmail.com");
        funcionario4.setDataNascimento(LocalDate.now().minusYears(45));
        
        UsuarioEntity funcionario5 = new UsuarioEntity();
        funcionario5.setCpf("12312312316");
        funcionario5.setNomeCompleto("Bianca Pereira Barbose");
        funcionario5.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario5.setSenha(encoder.encode("funcionario"));
        funcionario5.setEmail("funcionario5@gmail.com");
        funcionario5.setDataNascimento(LocalDate.now().minusYears(38));
        
        UsuarioEntity funcionario6 = new UsuarioEntity();
        funcionario6.setCpf("12312312317");
        funcionario6.setNomeCompleto("Tatiana Figueiredo da Luna Madeira");
        funcionario6.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario6.setSenha(encoder.encode("funcionario"));
        funcionario6.setEmail("funcionario6@gmail.com");
        funcionario6.setDataNascimento(LocalDate.now().minusYears(42));
        
        UsuarioEntity funcionario7 = new UsuarioEntity();
        funcionario7.setCpf("12312312318");
        funcionario7.setNomeCompleto("Simone Santana dos Santos");
        funcionario7.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario7.setSenha(encoder.encode("funcionario"));
        funcionario7.setEmail("funcionario7@gmail.com");
        funcionario7.setDataNascimento(LocalDate.now().minusYears(37));
        
        UsuarioEntity funcionario8 = new UsuarioEntity();
        funcionario8.setCpf("12312312319");
        funcionario8.setNomeCompleto("Renata Barbose do Nascimento Silva");
        funcionario8.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario8.setSenha(encoder.encode("funcionario"));
        funcionario8.setEmail("funcionario8@gmail.com");
        funcionario8.setDataNascimento(LocalDate.now().minusYears(39));
        
        UsuarioEntity funcionario9 = new UsuarioEntity();
        funcionario9.setCpf("12312312320");
        funcionario9.setNomeCompleto("Synara Stênia de Melo Moura");
        funcionario9.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario9.setSenha(encoder.encode("funcionario"));
        funcionario9.setEmail("funcionario9@gmail.com");
        funcionario9.setDataNascimento(LocalDate.now().minusYears(41));
        
        UsuarioEntity funcionario10 = new UsuarioEntity();
        funcionario10.setCpf("12312312321");
        funcionario10.setNomeCompleto("Elayne Barbosa dos Santos Gomes");
        funcionario10.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario10.setSenha(encoder.encode("funcionario"));
        funcionario10.setEmail("funcionario10@gmail.com");
        funcionario10.setDataNascimento(LocalDate.now().minusYears(36));
        
        UsuarioEntity funcionario11 = new UsuarioEntity();
        funcionario11.setCpf("12312312322");
        funcionario11.setNomeCompleto("Solange Tavares da Silva Ferreira");
        funcionario11.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario11.setSenha(encoder.encode("funcionario"));
        funcionario11.setEmail("funcionario11@gmail.com");
        funcionario11.setDataNascimento(LocalDate.now().minusYears(43));
        
        UsuarioEntity funcionario12 = new UsuarioEntity();
        funcionario12.setCpf("12312312323");
        funcionario12.setNomeCompleto("Reivan de Castro Sá Barreto");
        funcionario12.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario12.setSenha(encoder.encode("funcionario"));
        funcionario12.setEmail("funcionario12@gmail.com");
        funcionario12.setDataNascimento(LocalDate.now().minusYears(34));
        
        UsuarioEntity funcionario13 = new UsuarioEntity();
        funcionario13.setCpf("12312312324");
        funcionario13.setNomeCompleto("Lorena Almeida Perruci do Nascimento");
        funcionario13.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario13.setSenha(encoder.encode("funcionario"));
        funcionario13.setEmail("funcionario13@gmail.com");
        funcionario13.setDataNascimento(LocalDate.now().minusYears(32));
        
        UsuarioEntity funcionario14 = new UsuarioEntity();
        funcionario14.setCpf("12312312325");
        funcionario14.setNomeCompleto("Daysi de Barros Correira Salgues");
        funcionario14.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario14.setSenha(encoder.encode("funcionario"));
        funcionario14.setEmail("funcionario14@gmail.com");
        funcionario14.setDataNascimento(LocalDate.now().minusYears(29));

        UsuarioEntity funcionario15 = new UsuarioEntity();
        funcionario15.setCpf("55655655655");
        funcionario15.setNomeCompleto("Brunna Rayane Carvalho de Amorin");
        funcionario15.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario15.setSenha(encoder.encode("funcionario"));
        funcionario15.setEmail("funcionario15@gmail.com");
        funcionario15.setDataNascimento(LocalDate.now().minusYears(26));

        UsuarioEntity funcionario16 = new UsuarioEntity();
        funcionario16.setCpf("55655695405");
        funcionario16.setNomeCompleto("Edson Carvalho Amorin");
        funcionario16.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario16.setSenha(encoder.encode("funcionario"));
        funcionario16.setEmail("funcionario16@gmail.com");
        funcionario16.setDataNascimento(LocalDate.now().minusYears(36));

        UsuarioEntity funcionario17 = new UsuarioEntity();
        funcionario17.setCpf("55655652405");
        funcionario17.setNomeCompleto("Edson Carvalho Amorin");
        funcionario17.setRole(RoleEnum.ROLE_FUNCIONARIO);
        funcionario17.setSenha(encoder.encode("funcionario"));
        funcionario17.setEmail("funcionario17@gmail.com");
        funcionario17.setDataNascimento(LocalDate.now().minusYears(36));
        

        usuarioRepository.saveAll(List.of(
            funcionario1, funcionario2, funcionario3, funcionario4, funcionario5, 
            funcionario6, funcionario7, funcionario8, funcionario9, funcionario10, 
            funcionario11, funcionario12, funcionario13, funcionario14, funcionario15,
            funcionario16, funcionario17
        ));



        // CADASTRANDO UNIDADES DO CRAS
        UnidadeSUASEntity unidade1 = new UnidadeSUASEntity();
        unidade1.setCadsuas("26116004476");
        unidade1.setNome("CRAS Alto Santa Terezinha");
        unidade1.setGestor(funcionario1);
        unidade1.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-517", 7, "RUA"));

        UnidadeSUASEntity unidade2 = new UnidadeSUASEntity();
        unidade2.setCadsuas("26116004478");
        unidade2.setNome("CRAS Campina do Barreto");
        unidade2.setGestor(funcionario2);
        unidade2.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-518", 8, "RUA"));

        UnidadeSUASEntity unidade3 = new UnidadeSUASEntity();
        unidade3.setCadsuas("26116004480");
        unidade3.setNome("CRAS Alto do Mandú");
        unidade3.setGestor(funcionario3);
        unidade3.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-519", 9, "RUA"));

        UnidadeSUASEntity unidade4 = new UnidadeSUASEntity();
        unidade4.setCadsuas("26116004482");
        unidade4.setNome("CRAS Dois Irmãos");
        unidade4.setGestor(funcionario4);
        unidade4.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-520", 10, "RUA"));

        UnidadeSUASEntity unidade5 = new UnidadeSUASEntity();
        unidade5.setCadsuas("26116004490");
        unidade5.setNome("CRAS Ibura de Baixo");
        unidade5.setGestor(funcionario5);
        unidade5.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-521", 11, "RUA"));

        UnidadeSUASEntity unidade6 = new UnidadeSUASEntity();
        unidade6.setCadsuas("26116004488");
        unidade6.setNome("CRAS Pina");
        unidade6.setGestor(funcionario6);
        unidade6.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-522", 12, "RUA"));

        UnidadeSUASEntity unidade7 = new UnidadeSUASEntity();
        unidade7.setCadsuas("26116004483");
        unidade7.setNome("CRAS Cordeiro");
        unidade7.setGestor(funcionario7);
        unidade7.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-523", 13, "RUA"));

        UnidadeSUASEntity unidade8 = new UnidadeSUASEntity();
        unidade8.setCadsuas("26116004479");
        unidade8.setNome("CRAS Santo Amaro");
        unidade8.setGestor(funcionario8);
        unidade8.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-524", 14, "RUA"));

        UnidadeSUASEntity unidade9 = new UnidadeSUASEntity();
        unidade9.setCadsuas("26116004484");
        unidade9.setNome("CRAS Torrões");
        unidade9.setGestor(funcionario9);
        unidade9.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-525", 15, "RUA"));

        UnidadeSUASEntity unidade10 = new UnidadeSUASEntity();
        unidade10.setCadsuas("26116038748");
        unidade10.setNome("CRAS Ibura de Cima/COHAB");
        unidade10.setGestor(funcionario10);
        unidade10.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-526", 16, "RUA"));

        UnidadeSUASEntity unidade11 = new UnidadeSUASEntity();
        unidade11.setCadsuas("26116038750");
        unidade11.setNome("CRAS Bongi");
        unidade11.setGestor(funcionario11);
        unidade11.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-527", 17, "RUA"));

        UnidadeSUASEntity unidade12 = new UnidadeSUASEntity();
        unidade12.setCadsuas("26116039419");
        unidade12.setNome("CRAS Rosilda Alves Mendes");
        unidade12.setGestor(funcionario12);
        unidade12.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-528", 18, "RUA"));

        UnidadeSUASEntity unidade13 = new UnidadeSUASEntity();
        unidade13.setCadsuas("26116039465");
        unidade13.setNome("CRAS Joana Bezerra/Coque");
        unidade13.setGestor(funcionario13);
        unidade13.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-529", 19, "RUA"));

        UnidadeSUASEntity unidade14 = new UnidadeSUASEntity();
        unidade14.setCadsuas("26116040273");
        unidade14.setNome("CRAS Dom Hélder Câmara");
        unidade14.setGestor(funcionario14);
        unidade14.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-530", 20, "RUA"));

        UnidadeSUASEntity unidade15 = new UnidadeSUASEntity();
        unidade15.setCadsuas("26116040241");
        unidade15.setNome("CRAS Mustardinha");
        unidade15.setGestor(funcionario15);
        unidade15.setEnderecoUnidade(new EnderecoEntity("PE", "RECIFE", "23123-530", 20, "RUA"));


        unidadeSUASRepository.saveAll(List.of(
            unidade1, unidade2, unidade3, unidade4, unidade5, 
            unidade6, unidade7, unidade8, unidade9, unidade10, 
            unidade11, unidade12, unidade13, unidade14, unidade15
        ));


        
        

        // CADASTRANDO SERVIÇOS
        ServicoEntity servico1 = new ServicoEntity();
        servico1.setNome("Cadastrar CadUnico");
        servico1.setComoAcessar(
                "Você pode acessar o CadÚnico pelo site oficial, no app Meu CadÚnico ou em um CRAS da sua cidade");
        servico1.setDescricao(
                "O Cadastro Único (CadÚnico) é um sistema do governo brasileiro que reúne informações socioeconômicas de famílias de baixa renda para acesso a programas sociais, como Bolsa Família e Tarifa Social de Energia.");
        servico1.setLinkAcesso("https://cadunico.dataprev.gov.br");

        ServicoEntity servico2 = new ServicoEntity();
        servico2.setNome("Bolsa família");
        servico2.setComoAcessar("Você pode acessar pelo app Bolsa Família, site oficial ou em um CRAS.");
        servico2.setDescricao(
                "O Bolsa Família é um programa do governo brasileiro que oferece transferência de renda para famílias em situação de pobreza e extrema pobreza, visando a redução da desigualdade.");
        servico2.setLinkAcesso("");

        ServicoEntity servico3 = new ServicoEntity();
        servico3.setNome("Consultar INSS");
        servico3.setComoAcessar(
                "Você pode acessar o INSS pelo site oficial, no app Meu INSS ou em uma agência do INSS.");
        servico3.setDescricao(
                "O INSS (Instituto Nacional do Seguro Social) é responsável pelo pagamento de benefícios previdenciários, como aposentadoria, auxílio-doença e pensão por morte, garantindo a seguridade social dos trabalhadores.");
        servico3.setLinkAcesso("https://meu.inss.gov.br");

        ServicoEntity servico4 = new ServicoEntity();
        servico4.setNome("Atualizar CadUnico");
        servico4.setComoAcessar(
                "Você pode acessar o CadÚnico pelo site oficial, no app Meu CadÚnico ou em um CRAS da sua cidade");
        servico4.setDescricao(
                "O Cadastro Único (CadÚnico) é um sistema do governo brasileiro que reúne informações socioeconômicas de famílias de baixa renda para acesso a programas sociais, como Bolsa Família e Tarifa Social de Energia.");
        servico4.setLinkAcesso("https://cadunico.dataprev.gov.br");

        servicoRepository.saveAll(List.of(servico1, servico2, servico3, servico4));



        //CADASTRANDO AGENDAMENTOS NO BANCO
        AgendamentoEntity agendamento1 = new AgendamentoEntity();
        agendamento1.setDataAtendimento(LocalDate.now().plusDays(2L));
        agendamento1.setServico(servico1);
        agendamento1.setUsuario(usuario);
        agendamento1.setUnidade(unidade1);

        AgendamentoEntity agendamento2 = new AgendamentoEntity();
        agendamento2.setDataAtendimento(LocalDate.now().plusDays(1L));
        agendamento2.setServico(servico4);
        agendamento2.setUsuario(usuario2);
        agendamento2.setUnidade(unidade2);

        AgendamentoEntity agendamento3 = new AgendamentoEntity();
        agendamento3.setDataAtendimento(LocalDate.now().plusDays(1L));
        agendamento3.setServico(servico4);
        agendamento3.setUsuario(usuario3);
        agendamento3.setUnidade(unidade2);

        AgendamentoEntity agendamento4 = new AgendamentoEntity();
        agendamento4.setDataAtendimento(LocalDate.now().plusDays(1L));
        agendamento4.setServico(servico4);
        agendamento4.setUsuario(usuario4);
        agendamento4.setUnidade(unidade2);


        agendamentoRepository.saveAll(List.of(agendamento1, agendamento2, agendamento3, agendamento4));
    }
}
