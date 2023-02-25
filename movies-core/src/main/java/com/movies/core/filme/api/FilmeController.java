package com.movies.core.filme.api;

import com.movies.core.filme.api.dto.FilmeDto;
import com.movies.core.filme.application.FilmeApplicationService;
import com.movies.core.filme.application.commands.CriarFilmeCommand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping(path = "filme")
public class FilmeController {

    @Autowired
    private FilmeApplicationService service;

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody @Valid FilmeDto dto) {
        String filme = service.criarFilme(CriarFilmeCommand.builder()
                .dataLancamento(dto.getDataLancamento())
                .duracao(Duration.ofSeconds(dto.getDuracao()))
                .elenco(dto.getElenco())
                .generos(dto.getGeneros())
                .like(dto.getLike())
                .subtitulo(dto.getSubtitulo())
                .titulo(dto.getTitulo())
                .build());

        return ResponseEntity.ok(filme);
    }
}
