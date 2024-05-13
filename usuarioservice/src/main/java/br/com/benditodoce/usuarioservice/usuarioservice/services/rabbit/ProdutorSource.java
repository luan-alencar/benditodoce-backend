package br.com.benditodoce.usuarioservice.usuarioservice.services.rabbit;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProdutorSource {

    String BINDING_MAILER = "mailer";

    @Output(ProdutorSource.BINDING_MAILER)
    MessageChannel enviarEmail();

}