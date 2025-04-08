package com.Asis.api.domain.agendamento.controller.DTOs.response;

import java.time.LocalDate;

public class AgendamentoResponseDTO {
    private LocalDate dataAtendimento;
    private int status;
    private String nomeUsuario;

    public AgendamentoResponseDTO(LocalDate dataAtendimento, int status, String nomeUsuario) {
        this.dataAtendimento = dataAtendimento;
        this.status = status;
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public int getStatus() {
        return status;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
