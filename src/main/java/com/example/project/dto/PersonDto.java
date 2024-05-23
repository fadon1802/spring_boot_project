package com.example.project.dto;

import com.example.project.validation.annotations.Name;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class PersonDto {

    @Setter
    String id;

    @Name
    final String name;
}
