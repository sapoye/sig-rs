package com.example.santepub.model;

import java.time.LocalDate;

public class CasMaladie {
    private Long id;
    private String nom;
    private LocalDate date;
    private String position; // Ex: "latitude,longitude"

    public CasMaladie(Long id, String nom, LocalDate date, String position) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.position = position;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public LocalDate getDate() { return date; }
    public String getPosition() { return position; }
}