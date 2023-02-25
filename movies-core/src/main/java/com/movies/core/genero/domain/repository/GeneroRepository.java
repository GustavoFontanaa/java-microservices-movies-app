package com.movies.core.genero.domain.repository;


import com.movies.core.genero.domain.Genero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneroRepository extends MongoRepository<Genero, String> {

}
