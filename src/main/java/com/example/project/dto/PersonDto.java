package com.example.project.dto;

import com.example.project.validation.annotations.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
public final class PersonDto {

    @Setter
    private String id;

    @Name
    private final String name;
    public PersonDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
