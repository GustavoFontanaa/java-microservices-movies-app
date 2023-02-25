package com.movies.core.genero.application;

import com.movies.core.genero.application.commands.CriarGeneroCommand;
import com.movies.core.genero.domain.Genero;
import com.movies.core.genero.domain.repository.GeneroRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.movies.core.config.AMQPConstants.GENERO_QUEUE;

@Service

public class GeneroApplicationService {

    @Autowired
    private GeneroRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String criarGenero(CriarGeneroCommand command) {
       Genero genero = repository.save(Genero.builder()
                .titulo(command.getTitulo())
                .build());

        rabbitTemplate.convertAndSend(GENERO_QUEUE, genero);
        return genero.getId();
    }

}
