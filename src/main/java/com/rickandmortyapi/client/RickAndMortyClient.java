package com.rickandmortyapi.client;

import com.rickandmortyapi.dto.RickAndMortyResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rickAndMortyClient", url = "https://rickandmortyapi.com/api")
public interface  RickAndMortyClient {

    @GetMapping("/character")
    RickAndMortyResponseDTO getCharacters(@RequestParam("page") int page);

    @GetMapping("/character")
    RickAndMortyResponseDTO getCharactersByName(@RequestParam("name") String name);
}
