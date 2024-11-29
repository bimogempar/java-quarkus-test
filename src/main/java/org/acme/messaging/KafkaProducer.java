package org.acme.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaProducer {

    @Channel("my-out-topic")
    Emitter<String> emitter;

    public void sendMessage(String message) {
        emitter.send(message);
    }
}