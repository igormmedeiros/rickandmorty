package com.rickandmortyapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoDTO {

    @JsonProperty("count")
    @JsonView(Views.Characters.class)
    private int count;

    @JsonProperty("pages")
    @JsonView(Views.Characters.class)
    private int pages;

    @JsonProperty("next")
    @JsonView(Views.Characters.class)
    private String next;

    @JsonProperty("prev")
    @JsonView(Views.Characters.class)
    private String prev;
}
