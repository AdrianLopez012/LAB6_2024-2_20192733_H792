package com.example.lab6.controller;

import com.example.lab6.entity.Pelicula;
import com.example.lab6.repository.PeliculaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaRepository peliculaRepository;

    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping
    public String listarPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        model.addAttribute("peliculas", peliculas);
        return "pelicula-list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula_", new Pelicula());
        return "pelicula-form";
    }

    @PostMapping("/save")
    public String guardarPelicula(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult result) {
        if (result.hasErrors()) {
            return "pelicula-form";
        }
        peliculaRepository.save(pelicula);
        return "redirect:/peliculas";
    }


    @GetMapping("/edit/{id}")
    public String editarPelicula(@PathVariable Integer id, Model model) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        model.addAttribute("pelicula", pelicula);
        return "pelicula-form";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPelicula(@PathVariable Integer id) {
        peliculaRepository.deleteById(id);
        return "redirect:/peliculas";
    }
}
