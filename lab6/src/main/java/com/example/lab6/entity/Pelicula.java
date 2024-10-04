package com.example.lab6.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.example.lab6.validationgroup.DirectorValidationGroup;
import com.example.lab6.validationgroup.PeliculaValidationGroup;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaId")
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String titulo;

    @Column(name = "fechaEstreno", nullable = false)
    @PastOrPresent(message = "La fecha de estreno debe ser pasada o presente")
    private LocalDate fechaEstreno;

    @Column(name = "duracionMinutos", nullable = false)
    @Positive(message = "La duración debe ser un número positivo")
    private Integer duracionMinutos;
}

