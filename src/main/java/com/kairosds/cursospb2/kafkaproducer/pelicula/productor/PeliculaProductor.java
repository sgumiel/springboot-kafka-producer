package com.kairosds.cursospb2.kafkaproducer.pelicula.productor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairosds.cursospb2.kafkaproducer.pelicula.Pelicula;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PeliculaProductor {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public Pelicula publicarPelicula(Pelicula pelicula) {

        final String peliculaString = this.objectMapper.writeValueAsString(pelicula);
        kafkaTemplate.send("pelicula-topic", peliculaString);

        return pelicula;



    }
}
