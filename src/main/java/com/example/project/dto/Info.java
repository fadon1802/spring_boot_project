package com.example.project.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor(access=AccessLevel.PUBLIC)
public class Info {
    private int id;
    private String date;
}
