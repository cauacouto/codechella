package com.couto.dev.codechella.repository;

import com.couto.dev.codechella.Enums.TipoEvento;
import com.couto.dev.codechella.domin.Evento;
import com.couto.dev.codechella.dto.EventoDto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<Evento,Long> {
    Flux<Evento> findByTipo(TipoEvento tipoEvento);
}
