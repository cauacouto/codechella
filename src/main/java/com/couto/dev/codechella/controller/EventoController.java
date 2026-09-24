package com.couto.dev.codechella.controller;

import com.couto.dev.codechella.dto.EventoDto;
import com.couto.dev.codechella.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;


    @GetMapping//(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterTodos(){
       return service.obeterTodos();

    }

    @GetMapping("{id}")
    public Mono<EventoDto> obterPorId(@PathVariable Long id){
        return service.obterPorId(id);

    }

    @PostMapping
    public Mono<EventoDto> cadastrar(@RequestBody EventoDto dto){
        return service.cadastrar(dto);
    }


    @DeleteMapping("/{id}")
    public Mono<Void> deletarPorId(@PathVariable Long id){
        return service.delete(id);
    }


    @PutMapping("/{id}")
    public Mono<EventoDto> atualizarPorId(@PathVariable Long id,@RequestBody EventoDto dto){
        return service.atualizar(id,dto);
    }
}
