package com.couto.dev.codechella.repository;

import com.couto.dev.codechella.domin.Evento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventoRepository extends ReactiveCrudRepository<Evento,Long> {
}
