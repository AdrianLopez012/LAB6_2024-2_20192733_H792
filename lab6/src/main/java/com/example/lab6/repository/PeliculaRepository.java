package com.example.lab6.repository;

import com.example.lab6.entity.Director;
import com.example.lab6.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository  extends JpaRepository<Pelicula,Integer> {
}
