package com.prueba.test.Repositories;

import com.prueba.test.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByNombre(String nombre);
}
