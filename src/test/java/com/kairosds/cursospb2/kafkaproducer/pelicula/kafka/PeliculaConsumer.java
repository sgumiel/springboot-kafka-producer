package com.kairosds.cursospb2.kafkaproducer.pelicula.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairosds.cursospb2.kafkaproducer.pelicula.Pelicula;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PeliculaConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${topics.pelicula}", groupId = "${kafka.consumer.group-id}")
    public void peliculaListener(String peliculaJson) throws JsonProcessingException {

        final var pelicula = this.objectMapper.readValue(peliculaJson, new TypeReference<Pelicula>() {});
        System.out.println("Pelicula recibida: " + pelicula.toString());
    }
}
