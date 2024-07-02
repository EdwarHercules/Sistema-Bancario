package com.prueba.test.Controllers;

import com.prueba.test.Entity.Cliente;
import com.prueba.test.Services.ClientePublisher;
import com.prueba.test.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientePublisher clientePublisher;

    // Endpoint para obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosClientes(){
        List<Cliente> clientes = clienteService.obtenerTodosclientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo cliente
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        clientePublisher.enviarClienteActualizado(nuevoCliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteActualizado){
        Cliente clienteActualizadoresult = clienteService.actualizarCliente(id, clienteActualizado);
        if (clienteActualizadoresult != null){
            clientePublisher.enviarClienteActualizado(clienteActualizado);
            return  ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un cliente por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
