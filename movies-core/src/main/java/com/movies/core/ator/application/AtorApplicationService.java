package com.movies.core.ator.application;

import com.movies.core.ator.application.commands.CriarAtorCommand;
import com.movies.core.ator.domain.Ator;
import com.movies.core.ator.domain.repository.AtorRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.movies.core.config.AMQPConstants.ATOR_QUEUE;

@Service
public class AtorApplicationService {

    @Autowired
    private AtorRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String criarAtor(CriarAtorCommand command) {
        Ator ator = repository.save(Ator.builder()
                .nome(command.getNome())
                .build());

        rabbitTemplate.convertAndSend(ATOR_QUEUE, ator);
        return ator.getId();

    }
}
