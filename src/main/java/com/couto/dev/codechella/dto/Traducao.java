package com.couto.dev.codechella.dto;

import java.util.List;

public record Traducao(List<Texto> translations) {

    public String getTexto(){
       return translations.getFirst().text();
    }
}
