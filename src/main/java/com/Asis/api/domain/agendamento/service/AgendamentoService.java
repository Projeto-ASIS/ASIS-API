package com.Asis.api.domain.agendamento.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.Asis.api.domain.agendamento.controller.DTO.request.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.agendamento.exception.businessException.AgendamentoJaExisteException;
import com.Asis.api.domain.agendamento.exception.businessException.DataAtendimentoInvalidoException;
import com.Asis.api.domain.agendamento.repository.AgendamentoRepository;
import com.Asis.api.domain.servico.repository.ServicoRepository;
import com.Asis.api.domain.unidade.repository.UnidadeSUASRepository;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;
    private final UnidadeSUASRepository unidadeSUASRepository;

    @Transactional
    public AgendamentoEntity registraAgendamento(AgendamentoRequestDTO request, String id) {

        var usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado"));

        var servico = servicoRepository.findById(request.servicoId()).orElseThrow(
                () -> new EntityNotFoundException("Serviço indicado não existe"));

        var unidade = unidadeSUASRepository.findById(request.unidadeId()).orElseThrow(
                () -> new EntityNotFoundException("Unidade do CRAS não existe"));


        if (request.dataAtendimento().isBefore(LocalDate.now())) {
            throw new DataAtendimentoInvalidoException("A data do atendimento não pode ser anterior a data atual");
        }

        if (agendamentoRepository.existsByDataAtendimentoAndFuncionario_id(request.dataAtendimento(),
                usuario.getId())) {
            throw new AgendamentoJaExisteException("Já existe um atendimento agendado para esta data");
        }

        var agendamento = new AgendamentoEntity();
        agendamento.setDataAtendimento(request.dataAtendimento());
        agendamento.setUsuario(usuario);
        agendamento.setServico(servico);
        agendamento.setUnidade(unidade);

        usuario.setCadunico(request.cadunico());
        usuario.setNis(request.nis());
        usuario.setNomeMae(request.nomeMae());
        usuario.setTelefone1(request.telefone1());
        usuario.setTelefone2(request.telefone2());
        usuario.setNomeMae(request.nomeMae());

        usuarioRepository.save(usuario);

        return agendamentoRepository.save(agendamento);

    }

    public List<AgendamentoEntity> buscaAgendamentos(LocalDate dataAgendamento, Integer idUnidade) {
        unidadeSUASRepository.findById(idUnidade).orElseThrow(
                () -> new EntityNotFoundException("Unidade do CRAS não existe"));

        return agendamentoRepository.findByDataAtendimentoAndUnidade_id(dataAgendamento, idUnidade);
    }

}
