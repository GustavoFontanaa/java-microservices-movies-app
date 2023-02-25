package com.movies.core.genero.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "generos")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

    @Id
    private String id;
    @NotEmpty
    private String titulo;

}
