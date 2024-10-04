package com.example.lab6.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lab6.entity.Director;
import com.example.lab6.repository.DirectorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/directores")
public class DirectorController {

    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping
    public String listarDirectores(Model model) {
        List<Director> directores = directorRepository.findAll();
        model.addAttribute("directores", directores);
        return "director-list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("director", new Director());
        return "director-form";
    }

    @PostMapping("/save")
    public String guardarDirector(@Valid @ModelAttribute("director") Director director, BindingResult result) {
        if (result.hasErrors()) {
            return "director-form";
        }
        directorRepository.save(director);
        return "redirect:/directores";
    }

    @GetMapping("/edit/{id}")
    public String editarDirector(@PathVariable Integer id, Model model) {
        Optional<Director> director = directorRepository.findById(id);
        model.addAttribute("director", director);
        return "director-form";
    }

    @GetMapping("/delete/{id}")
    public String eliminarDirector(@PathVariable Integer id) {
        directorRepository.deleteById(id);
        return "redirect:/directores";
    }
}
