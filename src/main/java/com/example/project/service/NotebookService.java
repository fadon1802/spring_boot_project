package com.example.project.service;

import com.example.project.model.Notebook;
import com.example.project.repositories.NotebookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotebookService {

    private NotebookRepository notebookRepository;

    public List<Notebook> getAllNotebooks() {
        return notebookRepository.findAll();
    }

    public Notebook saveNotebook(Notebook notebook) {
        return notebookRepository.save(notebook);
    }
}
