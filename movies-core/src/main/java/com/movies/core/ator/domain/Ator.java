package com.movies.core.ator.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "atores")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Ator {
    @Id
    private String id;
    @NotEmpty
    private String nome;
}
