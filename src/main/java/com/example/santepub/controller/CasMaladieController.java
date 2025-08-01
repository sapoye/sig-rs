package com.example.santepub.controller;

import com.example.santepub.model.CasMaladie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class CasMaladieController {

    @GetMapping("/casmaladie")
    public String listeCasMaladies(Model model) {
        // Exemple statique, à remplacer par un appel à un service ou repository
        List<CasMaladie> casMaladies = Arrays.asList(
                new CasMaladie(1L, "Paludisme", LocalDate.of(2025, 7, 30), "14.6928,-17.4467"),
                new CasMaladie(2L, "Dengue", LocalDate.of(2025, 7, 25), "14.7000,-17.4500")
        );
        model.addAttribute("casMaladies", casMaladies);
        return "casmaladie";
    }
}