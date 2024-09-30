package com.rickandmortyapi.service;

import com.rickandmortyapi.dto.CharacterDTO;
import com.rickandmortyapi.dto.RickAndMortyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class RickAndMortyService {

    @Autowired
    private WebClient webClient;

    @Cacheable(value = "rickAndMortyCache", key = "#page")
    public RickAndMortyResponseDTO getCharacters(int page) {
        Mono<RickAndMortyResponseDTO> response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/character")
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(RickAndMortyResponseDTO.class);

        return response.block();
    }

    @Cacheable(value = "rickAndMortyCache", key = "#name")
    public CharacterDTO getCharactersByName(String name) {
        Mono<RickAndMortyResponseDTO> response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/character")
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(RickAndMortyResponseDTO.class);

        RickAndMortyResponseDTO dto = response.block();
        return Objects.requireNonNull(dto).getResults().stream().findFirst().orElse(null);
    }
}
