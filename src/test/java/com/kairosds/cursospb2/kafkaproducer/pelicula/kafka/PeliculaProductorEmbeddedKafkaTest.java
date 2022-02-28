package com.kairosds.cursospb2.kafkaproducer.pelicula.kafka;

import com.kairosds.cursospb2.kafkaproducer.KafkaProducerApplication;
import com.kairosds.cursospb2.kafkaproducer.config.KafkaConsumerConfig;
import com.kairosds.cursospb2.kafkaproducer.pelicula.Pelicula;
import com.kairosds.cursospb2.kafkaproducer.pelicula.productor.PeliculaProductor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CountDownLatch;

@Import(KafkaConsumerConfig.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KafkaProducerApplication.class)
@ActiveProfiles("test")
@EmbeddedKafka(bootstrapServersProperty = "${spring.kafka.bootstrap-servers}", ports = 9092)
public class PeliculaProductorEmbeddedKafkaTest {

    @Autowired
    private EmbeddedKafkaBroker broker;

    @Autowired
    private PeliculaProductor peliculaProductor;

    @Test
    public void test1() {

        System.out.println("Broker: " + broker);

        final var p = Pelicula.builder()
                .autor("Santiago Segura")
                .titulo("Torrente")
                .duracionMinutos(98.89)
                .build();

        peliculaProductor.publicarPelicula(p);

    }
}
