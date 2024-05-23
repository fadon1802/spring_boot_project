package com.example.project.adapter.web;

import com.example.project.dto.JsonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JSONController {
    private static final AtomicLong longId = new AtomicLong();

    @PostMapping("/addId")
    public JsonDto addIdToJSON(@RequestBody JsonDto inputObj) {
        inputObj.getInfo().setId(longId.getAndIncrement());
        return inputObj;
    }
}
