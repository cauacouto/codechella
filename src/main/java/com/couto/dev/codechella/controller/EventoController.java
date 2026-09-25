package com.couto.dev.codechella.controller;

import com.couto.dev.codechella.dto.EventoDto;
import com.couto.dev.codechella.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService service;

    private final Sinks.Many<EventoDto> eventoSink;

    public EventoController(EventoService service) {
        this.service = service;
        this.eventoSink = Sinks.many().multicast().onBackpressureBuffer();
    }


    @GetMapping
    public Flux<EventoDto> obterTodos(){
       return service.obeterTodos();

    }

    @GetMapping("{id}")
    public Mono<EventoDto> obterPorId(@PathVariable Long id){
        return service.obterPorId(id);

    }


    @GetMapping(value = "/categoria/{tipo}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterPorTipo(@PathVariable String tipo){
        return Flux.merge(service.obterPorTipo(tipo),eventoSink.asFlux())
                .delayElements(Duration.ofSeconds(4));
    }

    @PostMapping
    public Mono<EventoDto> cadastrar(@RequestBody EventoDto dto){
        return service.cadastrar(dto)
                .doOnSuccess(e -> eventoSink.tryEmitNext(e));
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
