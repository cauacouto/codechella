package com.couto.dev.codechella.dto;

import com.couto.dev.codechella.Enums.TipoEvento;
import com.couto.dev.codechella.domin.Evento;

import java.time.LocalDate;

public record EventoDto(Long id,
                        String nome,
                        TipoEvento tipo,
                        LocalDate data,
                        String descricao) {

    public static EventoDto toDto(Evento evento){
        return new EventoDto(
                evento.getId(),
                evento.getNome(),
                evento.getTipo(),
                evento.getData(),
                evento.getDescricao()
        );
    }

    public Evento toEntity(){
        Evento evento = new Evento();
        evento.setId(this.id);
        evento.setNome(this.nome);
        evento.setTipo(this.tipo);
        evento.setData(this.data);
        evento.setDescricao(this.descricao);
        return evento;
    }
}
