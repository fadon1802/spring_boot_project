package com.example.project.controllers;

import com.example.project.model.Notebook;
import com.example.project.service.NotebookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/notebooks")
public class NotebookController {

    private NotebookService notebookService;

    @GetMapping
    public List<Notebook> getAllNotebooks() {
        return notebookService.getAllNotebooks();
    }

    @PostMapping("/addNotebook")
    public Notebook createNotebook(@RequestBody Notebook notebook) {
        return notebookService.saveNotebook(notebook);
    }
}
