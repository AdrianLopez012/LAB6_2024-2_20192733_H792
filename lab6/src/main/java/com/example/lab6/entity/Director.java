package com.example.lab6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "directores")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directorId")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @Column(name = "telefono", nullable = false, length = 9)
    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 9, max = 9, message = "El teléfono debe tener exactamente 9 dígitos")
    @Pattern(regexp = "\\d+", message = "El teléfono debe contener solo dígitos")
    private String telefono;

    @Column(name = "nacionalidad", nullable = false, length = 50)
    @NotBlank(message = "Debe seleccionar una nacionalidad")
    private String nacionalidad;
}

