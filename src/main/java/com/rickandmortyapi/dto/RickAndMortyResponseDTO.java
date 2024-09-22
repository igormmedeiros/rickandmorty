package com.rickandmortyapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.List;

@Data
public class RickAndMortyResponseDTO {

    @JsonProperty("results")
    @JsonView(Views.Characters.class)
    private List<CharacterDTO> results;

    @JsonProperty("info")
    @JsonView(Views.Characters.class)
    private InfoDTO info;
}
