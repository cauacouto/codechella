package com.couto.dev.codechella.service;

import com.couto.dev.codechella.dto.EventoDto;
import com.couto.dev.codechella.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;


    public Flux<EventoDto> obeterTodos(){
        return repository.findAll()
                .map(EventoDto::toDto);
    }
}
