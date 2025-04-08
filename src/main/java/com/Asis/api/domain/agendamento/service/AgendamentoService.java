package com.Asis.api.domain.agendamento.service;

import org.springframework.stereotype.Service;

import com.Asis.api.domain.agendamento.controller.DTOs.request.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.controller.DTOs.response.AgendamentoResponseDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.agendamento.exception.businessException.AgendamentoJaExisteException;
import com.Asis.api.domain.agendamento.repository.AgendamentoRepository;
import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.servico.repository.ServicoRepository;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;

    @Transactional
    public AgendamentoEntity save(AgendamentoRequestDTO request, String id) {
        var entity = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado"));

        var servico = servicoRepository.findById(request.servicoId()).orElseThrow(
                () -> new EntityNotFoundException("Serviço indicado não existe"));

        if (agendamentoRepository.existsByDataAtendimentoAndFuncionario_id(request.dataAtendimento(), entity.getId())) {
            throw new AgendamentoJaExisteException("Já existe um atendimento pendente para esta data");
        }

        var endereco = new EnderecoEntity();
        endereco.setCEP(request.endereco().CEP());
        endereco.setCidade(request.endereco().cidade());
        endereco.setComplemento(request.endereco().CEP());
        endereco.setUF(request.endereco().UF());
        endereco.setNumero(request.endereco().numero());
        endereco.setLogradouro(request.endereco().logradouro());
        entity.setEndereco(endereco);

        var agendamento = new AgendamentoEntity();
        agendamento.setDataAtendimento(request.dataAtendimento());
        agendamento.setFuncionario(entity);
        agendamento.setServico(servico);

        usuarioRepository.save(entity);

        return agendamentoRepository.save(agendamento);

    }

    public List<AgendamentoResponseDTO> buscarTodos() {
        return agendamentoRepository.findAll().stream()
                .map(agendamento -> new AgendamentoResponseDTO(
                        agendamento.getDataAtendimento(),
                        mapearStatusParaNumero(String.valueOf(agendamento.getStatusAgendamento())),
                        agendamento.getFuncionario().getNomeCompleto()
                ))
                .collect(Collectors.toList());
    }

    private int mapearStatusParaNumero(String status) {
        return switch (status) {
            case "1" -> 1;
            case "2" -> 2;
            default -> 0;
        };
    }

    }



