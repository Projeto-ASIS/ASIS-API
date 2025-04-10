package com.Asis.api.domain.agendamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.Asis.api.configurations.exceptions.ErrorMesage;
import com.Asis.api.domain.agendamento.exception.businessException.AgendamentoJaExisteException;
import com.Asis.api.domain.agendamento.exception.businessException.DataAtendimentoInvalidoException;

@RestControllerAdvice
public class AgendamentoExceptionHandler {

    @ExceptionHandler(exception = DataAtendimentoInvalidoException.class)
    public ResponseEntity<ErrorMesage> dataInvalida(DataAtendimentoInvalidoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMesage(ex.getMessage()));
    }

    @ExceptionHandler(exception = AgendamentoJaExisteException.class)
    public ResponseEntity<ErrorMesage> agendamentoExistente(AgendamentoJaExisteException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorMesage(ex.getMessage()));
    }

}
