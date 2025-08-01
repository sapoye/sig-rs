package com.example.santepub.controller;

import com.example.santepub.model.CasMaladie;
import com.example.santepub.service.CasMaladieService;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cas-maladies")
public class CasMaladieController {
    private final CasMaladieService service;
    private final GeometryFactory geometryFactory = new GeometryFactory();

    public CasMaladieController(CasMaladieService service) {
        this.service = service;
    }

    @GetMapping
    public List<CasMaladie> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasMaladie> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CasMaladie create(@RequestBody CasMaladieDto dto) {
        Point localisation = geometryFactory.createPoint(new org.locationtech.jts.geom.Coordinate(dto.longitude, dto.latitude));
        localisation.setSRID(4326);
        CasMaladie casMaladie = new CasMaladie(dto.nom, dto.description, localisation);
        return service.save(casMaladie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Endpoint spatial : recherche par distance (en mètres)
    @GetMapping("/search")
    public List<CasMaladie> searchByDistance(
            @RequestParam double longitude,
            @RequestParam double latitude,
            @RequestParam double distanceMeters
    ) {
        return service.searchByDistance(longitude, latitude, distanceMeters);
    }

    // DTO pour création (évite les soucis de désérialisation JTS depuis JSON)
    public static class CasMaladieDto {
        public String nom;
        public String description;
        public double longitude;
        public double latitude;
    }
}