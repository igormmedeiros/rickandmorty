package com.rickandmortyapi.service;

import com.rickandmortyapi.client.RickAndMortyClient;
import com.rickandmortyapi.dto.CharacterDTO;
import com.rickandmortyapi.dto.RickAndMortyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RickAndMortyService {

    @Autowired
    private RickAndMortyClient rickAndMortyClient;

    @Cacheable(value = "rickAndMortyCache", key = "#page")
    public RickAndMortyResponseDTO getCharacters(int page) {
            return rickAndMortyClient.getCharacters(page);
    }

    @Cacheable(value = "rickAndMortyCache", key = "#name")
    public CharacterDTO getCharactersByName(String name) {
        RickAndMortyResponseDTO response = rickAndMortyClient.getCharactersByName(name);

        if (response != null && response.getResults() != null) {
            return response.getResults().stream()
                    .findFirst()
                    .map(character -> {
                        CharacterDTO characterSpecie = new CharacterDTO();
                        characterSpecie.setId(character.getId());
                        characterSpecie.setName(character.getName());
                        characterSpecie.setSpecies(character.getSpecies());
                        return character;
                    })
                    .orElseThrow(() -> new RuntimeException("Character not found"));
        }
        throw new RuntimeException("Character not found");
    }
}
