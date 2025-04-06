package com.Asis.api.domain.agendamento.exception.businessException;

public class AgendamentoJaExisteException extends RuntimeException{

    public AgendamentoJaExisteException(String msg){
        super(msg);
    }

}
