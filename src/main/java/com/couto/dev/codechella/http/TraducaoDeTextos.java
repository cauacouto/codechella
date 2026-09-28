package com.couto.dev.codechella.http;

import com.couto.dev.codechella.dto.Traducao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class TraducaoDeTextos {

    @Value("${deepl.api.key}")
    private String apikey;

    public  Mono<String> obterTraducao(String texto,String idioma){

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api-free.deepl.com/v2/translate")
                .build();


        MultiValueMap<String,String> req = new LinkedMultiValueMap<>();

        req.add("text",texto);
        req.add("target_lang",idioma);

       return webClient.post()
                .header("Authorization","DeepL-Auth-Key " + apikey)
                .body(BodyInserters.fromFormData(req))
                .retrieve()
                .bodyToMono(Traducao.class)
                .map(Traducao::getTexto);
    }


}
