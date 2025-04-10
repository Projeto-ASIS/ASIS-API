package com.Asis.api.domain.recuperarSenha.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void enviarEmailRedefinicaoSenha(String destinatario, String codigo) {

        String assunto = "Redefinição de Senha";
        String mensagem = "Seu código para recuperação de senha: " + codigo;

        SimpleMailMessage email = new SimpleMailMessage();
        
        email.setTo(destinatario);
        email.setSubject(assunto);
        email.setText(mensagem);

        mailSender.send(email);
    }
}