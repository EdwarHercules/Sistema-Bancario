package com.prueba.test.Controllers;

import com.prueba.test.Entity.Cuenta;
import com.prueba.test.Exceptions.CuentaNoEncontradaException;
import com.prueba.test.Objects.CuentaDTO;
import com.prueba.test.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Endpoint para obtener todas las cuentas
    @GetMapping
    public ResponseEntity<List<CuentaDTO>> obtenerTodasCuentas(){
        List<CuentaDTO> cuentas = cuentaService.obtenerTodasCuentas();
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

    // Endpoint para obtener una cuenta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> obtenerCuentaPorId(@PathVariable("id") Long id){
        Optional<CuentaDTO> cuenta = cuentaService.obtenerCuentaPorId(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear una nueva cuenta
    @PostMapping
    public ResponseEntity<CuentaDTO> crearNuevaCuenta(@RequestParam Long clienteId,@RequestBody CuentaDTO cuentaDTO){
        try {
            CuentaDTO nuevaCuenta = cuentaService.crearCuentaParaCliente(clienteId, cuentaDTO);
            return new ResponseEntity<>(nuevaCuenta, HttpStatus.OK);
        } catch (CuentaNoEncontradaException e){
            return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint para actualizar una cuenta existente
    @PutMapping("/{id}")
    public  ResponseEntity<CuentaDTO> actualizarCuanta(@PathVariable("id") Long id, @RequestBody CuentaDTO cuentaDTO){
        try {
            CuentaDTO cuentaActualizada = cuentaService.actualizarCuenta(id, cuentaDTO);
            return new ResponseEntity<>(cuentaActualizada, HttpStatus.OK);
        } catch (CuentaNoEncontradaException e){
            return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint para eliminar una cuenta por su Id
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable("id") Long id){
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }

}
