package com.Asis.api.domain.agendamento.entity.enums;

public enum StatusAgendamento {
    PENDENTE(1),
    EM_ATENDIMENTO(2),
    FINALIZADO(3);

    private int code;

    private StatusAgendamento(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public StatusAgendamento valueOf(int code){
        for(StatusAgendamento value: StatusAgendamento.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid FormaEscoamentoDomicilio code: " + code);
    }
}
