package com.prueba.test.Controllers;


import com.prueba.test.Entity.Persona;
import com.prueba.test.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    // Endpoint para obtener todas las personas
    @GetMapping
    public ResponseEntity<List<Persona>> obtenerTodasPersonas(){
        List<Persona> personas = personaService.obtenerTodasPersonas();
        return  new ResponseEntity<>(personas, HttpStatus.OK);
    }


    // Endpoint para obtener una personas por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable("id") Long id){
        Optional<Persona> persona = personaService.obtenerPersonaPorId(id);
        return persona.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    // Endpoint para actualizar una persona existente
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable("id") Long id, @RequestBody Persona personaActualizada){
        Persona personaActualizadaresult = personaService.actualizarPersona(id, personaActualizada);
        return personaActualizadaresult != null ?
                ResponseEntity.ok(personaActualizadaresult) :
                ResponseEntity.notFound().build();
    }

    // Endpoint para eliminar una persona por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable("id") Long id){
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}
