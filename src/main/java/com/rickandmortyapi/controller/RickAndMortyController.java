package com.rickandmortyapi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rickandmortyapi.dto.CharacterDTO;
import com.rickandmortyapi.dto.RickAndMortyResponseDTO;
import com.rickandmortyapi.dto.Views;
import com.rickandmortyapi.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagens")
public class RickAndMortyController {

    @Autowired
    private RickAndMortyService rickAndMortyService;


    @JsonView(Views.Characters.class)
    @GetMapping(params = "page")
    public RickAndMortyResponseDTO getCharacters(@RequestParam(defaultValue = "1") int page) {
        return rickAndMortyService.getCharacters(page);
    }

    @JsonView(Views.CharactersSpecies.class)
    @GetMapping(params = "name")
    public CharacterDTO getCharactersByName(@RequestParam String name) {
        return rickAndMortyService.getCharactersByName(name);
    }
}
