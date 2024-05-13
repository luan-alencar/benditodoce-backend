package br.com.benditodoce.usuarioservice.usuarioservice.services.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumidorTarget {

    String BINDING_MAILER = "mailer";

    @Input(ConsumidorTarget.BINDING_MAILER)
    SubscribableChannel email();

}