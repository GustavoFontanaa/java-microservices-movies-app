package com.movies.core.filme.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDto {

    @NotEmpty
    private String titulo;
    private String subtitulo;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;
    private Integer duracao;
    private Collection<String> generos;
    private Collection<String> elenco;
    private Boolean like;
}
