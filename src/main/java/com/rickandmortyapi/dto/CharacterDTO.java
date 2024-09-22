package com.rickandmortyapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDTO {

    @JsonProperty("id")
    @JsonView(Views.Characters.class)
    private int id;

    @JsonProperty("name")
    @JsonView(Views.Characters.class)
    private String name;

    @JsonProperty("species")
    @JsonView(Views.CharactersSpecies.class)
    private String species;
}
