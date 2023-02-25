package com.movies.core.ator.domain.repository;


import com.movies.core.ator.domain.Ator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AtorRepository extends MongoRepository<Ator, String> {

}
