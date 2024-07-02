package com.prueba.test.Services;

import com.prueba.test.Entity.Persona;
import com.prueba.test.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public List<Persona> obtenerTodasPersonas(){
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id){
        return personaRepository.findById(id);
    }

    public Persona actualizarPersona(Long id, Persona personaActualizada){
        if (personaRepository.existsById(id)){
            personaActualizada.setId(id);
            return personaRepository.save(personaActualizada);
        }
        return null;
    }

    public void eliminarPersona(Long id){
        personaRepository.deleteById(id);
    }
}
