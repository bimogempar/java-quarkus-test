package org.acme.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.DataRecord;
import org.jboss.logging.Logger;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.reactive.messaging.kafka.IncomingKafkaRecord;

@ApplicationScoped
public class KafkaConsumer {

    private static final Logger LOG = Logger.getLogger(KafkaConsumer.class);

    @Blocking
    public void consume(@IncomingKafkaRecord("my-topic") String message) {
        LOG.infof("Received message: %s", message);

        // Simpan ke database
        DataRecord record = new DataRecord("kafka-key", message);
        record.persist();
    }
}