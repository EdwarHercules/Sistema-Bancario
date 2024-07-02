package com.prueba.test.Controllers;

import com.prueba.test.Entity.Cuenta;
import com.prueba.test.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Endpoint para obtener todas las cuentas
    @GetMapping
    public ResponseEntity<List<Cuenta>> obtenerTodasCuentas(){
        List<Cuenta> cuentas = cuentaService.obtenerTodasCuentas();
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

    // Endpoint para obtener una cuenta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable("id") Long id){
        Optional<Cuenta> cuenta = cuentaService.obtenerCuentaPorId(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear una nueva cuenta
    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta){
        Cuenta nuevaCuenta = cuentaService.crearCuenta(cuenta);
        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una cuenta existente
    @PutMapping("/{id}")
    public  ResponseEntity<Cuenta> actualizarCuanta(@PathVariable("id") Long id, @RequestBody Cuenta cuentaActualizada){
        Cuenta cuentaActualizadaResult = cuentaService.actualizarCuenta(id, cuentaActualizada);
        return cuentaActualizadaResult != null ?
                ResponseEntity.ok(cuentaActualizadaResult) :
                ResponseEntity.notFound().build();
    }

    // Endpoint para eliminar una cuenta por su Id
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable("id") Long id){
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }

}
