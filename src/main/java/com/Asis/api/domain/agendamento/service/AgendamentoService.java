package com.Asis.api.domain.agendamento.service;

import org.springframework.stereotype.Service;

import com.Asis.api.domain.agendamento.controller.DTOs.request.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.agendamento.exception.businessException.AgendamentoJaExisteException;
import com.Asis.api.domain.agendamento.exception.businessException.UnidadeNaoExisteException;
import com.Asis.api.domain.agendamento.repository.AgendamentoRepository;
import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.servico.repository.ServicoRepository;
import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;
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

    public List<AgendamentoEntity> buscaAgendamentos(LocalDate dataAgendamento, Integer idUnidade) {
        System.out.println("O ID ESTÁ CHEANDO AQUI: " + idUnidade);


        unidadeSUASRepository.findById(idUnidade).orElseThrow(
            ()-> new UnidadeNaoExisteException("Unidade do CRAS não existe"));

        
        return agendamentoRepository.findByDataAtendimentoAndUnidade_id(dataAgendamento, idUnidade);
    }

    }



