package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "notebook")

public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "notebook_events", joinColumns = @JoinColumn(name = "notebook_id"))
    @Column(name = "event")
    private List<String> events;
}
