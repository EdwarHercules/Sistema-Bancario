package com.prueba.test.Controllers;

import com.prueba.test.Entity.Movimiento;
import com.prueba.test.Services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    // Endpoint para obtener todos los movimientos
    @GetMapping
    public ResponseEntity<List<Movimiento>> obtenerTodosMovimientos(){
        List<Movimiento> movimientos = movimientoService.obtenerTodosmovimientos();
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo movimiento
    @PostMapping
    public ResponseEntity<Movimiento> crearMovimiento(@RequestBody Movimiento movimiento){
        Movimiento nuevoMovimiento = movimientoService.crearMovimiento(movimiento);
        return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
    }

    // Endpoint para obtener un movimiento por su ID
    @GetMapping("/{id}")
    public  ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable("id") Long id){
        Optional<Movimiento> movimiento = movimientoService.obtenerMovimientoPorId(id);
        return movimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para actualizar un movimiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable("id") Long id){
        movimientoService.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}
