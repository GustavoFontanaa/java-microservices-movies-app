package com.movies.core.ator.api;

import com.movies.core.ator.api.dto.AtorDto;
import com.movies.core.ator.application.AtorApplicationService;
import com.movies.core.ator.application.commands.CriarAtorCommand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ator")
public class AtorController {

    @Autowired
    private AtorApplicationService service;

    @PostMapping
    public ResponseEntity<String> criarAtor(@RequestBody @Valid AtorDto dto) {
        String id = service.criarAtor(CriarAtorCommand.builder()
                .nome(dto.getNome())
                .build());
        return ResponseEntity.ok(id);
    }
}
