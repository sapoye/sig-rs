package com.example.santepub.repository;

import com.example.santepub.model.CasMaladie;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CasMaladieRepository extends JpaRepository<CasMaladie, Long> {

    // Recherche spatiale : tous les cas dans un rayon (en mètres) autour d'un point
    @Query(value = "SELECT c.* FROM cas_maladie c WHERE ST_DWithin(c.localisation, ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326), :distance)", nativeQuery = true)
    List<CasMaladie> findWithinDistance(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("distance") double distance);
}