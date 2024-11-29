package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.DataRecord;
import org.acme.messaging.KafkaProducer;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class ExternalApiService {

    private static final Logger LOG = Logger.getLogger(ExternalApiService.class);

    @Inject
    KafkaProducer kafkaProducer;

    public void fetchAndProcessData() {
        // Simulate API call
        List<String> data = List.of("Data1", "Data2", "Data3");

        data.forEach(value -> {
            // Save to database
            DataRecord record = new DataRecord("api-key", value);
            record.persist();

            // Send to Kafka
            kafkaProducer.sendMessage(value);

            LOG.infof("Processed data: %s", value);
        });
    }
}