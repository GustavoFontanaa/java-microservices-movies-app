package com.movies.core.genero.api;

import com.movies.core.genero.api.dto.GeneroDto;
import com.movies.core.genero.application.GeneroApplicationService;
import com.movies.core.genero.application.commands.CriarGeneroCommand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "genero")
public class GeneroController {
    @Autowired
    private GeneroApplicationService service;

    @PostMapping
    public ResponseEntity<String> criarGenero(@RequestBody @Valid GeneroDto dto) {
        String genero = service.criarGenero(CriarGeneroCommand.builder()
                .titulo(dto.getTitulo())
                .build());

        return ResponseEntity.ok(genero);
    }
}
