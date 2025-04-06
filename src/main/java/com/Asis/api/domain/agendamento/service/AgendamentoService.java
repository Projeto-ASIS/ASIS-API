package com.Asis.api.domain.agendamento.service;

import org.springframework.stereotype.Service;

import com.Asis.api.domain.agendamento.controller.DTOs.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.agendamento.exception.businessException.AgendamentoJaExisteException;
import com.Asis.api.domain.agendamento.repository.AgendamentoRepository;
import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.servico.repository.ServicoRepository;
import com.Asis.api.domain.usuario.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;

    @Transactional
    public AgendamentoEntity save(AgendamentoRequestDTO request, String id) {
        System.out.println();
        System.out.println();
        System.out.println("ID DO USUARIO CHEGANDO NO SERVICE: " + id);
        System.out.println("ID DO SERVICO CHEGANDO NO SERVICE: " + request.servicoId());
        System.out.println();
        System.out.println();

        var entity = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado"));

        var servico = servicoRepository.findById(request.servicoId()).orElseThrow(
                () -> new EntityNotFoundException("Serviço indicado não existe"));

        if (agendamentoRepository.existsByDataAtendimentoAndUsuario_id(request.dataAtendimento(), entity.getId())) {
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
        agendamento.setUsuario(entity);
        agendamento.setServico(servico);

        usuarioRepository.save(entity);

        return agendamentoRepository.save(agendamento);

    }

}
