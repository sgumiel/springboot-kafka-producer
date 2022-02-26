package com.kairosds.cursospb2.kafkaproducer.pelicula.controller;

import com.kairosds.cursospb2.kafkaproducer.pelicula.Pelicula;
import com.kairosds.cursospb2.kafkaproducer.pelicula.productor.PeliculaProductor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("pelicula")
public class PeliculaController {

    private final PeliculaProductor peliculaProductor;

    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {

        final var peliculaEnviada = this.peliculaProductor.publicarPelicula(pelicula);

        return ResponseEntity.ok(peliculaEnviada);


    }
}
