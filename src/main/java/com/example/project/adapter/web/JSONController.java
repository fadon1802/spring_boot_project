package com.example.project.adapter.web;

import com.example.project.dto.JsonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {
    private static int id;

    @PostMapping("/addId")
    public ResponseEntity<JsonDto> addIdtoJSON(@RequestBody JsonDto inputObj) {
        inputObj.getInfo().setId(id++);
        return ResponseEntity.ok().body(inputObj);
    }
}
