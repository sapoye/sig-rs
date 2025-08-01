package com.example.santepub.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
public class CasMaladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point localisation;

    public CasMaladie() {}

    public CasMaladie(String nom, String description, Point localisation) {
        this.nom = nom;
        this.description = description;
        this.localisation = localisation;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public Point getLocalisation() { return localisation; }

    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setLocalisation(Point localisation) { this.localisation = localisation; }
}