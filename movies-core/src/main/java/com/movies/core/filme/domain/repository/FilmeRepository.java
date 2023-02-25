package com.movies.core.filme.domain.repository;

import com.movies.core.filme.domain.Filme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmeRepository extends MongoRepository<Filme, String> {

}
