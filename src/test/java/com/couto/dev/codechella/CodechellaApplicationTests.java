package com.couto.dev.codechella;

import com.couto.dev.codechella.Enums.TipoEvento;
import com.couto.dev.codechella.dto.EventoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient

class CodechellaApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void cadastrarEvento() {
		EventoDto dto = new EventoDto(
				null,"bk", TipoEvento.SHOW
				, LocalDate.parse("2026-07-20"),"10 anos de castoloes e ruinas"
		);
		webTestClient.post().uri("/eventos").bodyValue(dto)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(EventoDto.class)
				.value(response -> {
					assertNotNull(response.id());
					assertEquals(dto.tipo(),response.tipo());
					assertEquals(dto.nome(),response.nome());
					assertEquals(dto.data(),response.data());
					assertEquals(dto.descricao(),response.descricao());
				});
	}


}
