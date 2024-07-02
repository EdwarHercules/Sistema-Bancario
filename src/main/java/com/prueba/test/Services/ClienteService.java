package com.prueba.test.Services;


import com.prueba.test.Entity.Cliente;
import com.prueba.test.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // metodo para crear un cliente
    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    // Metodo para obtener todos los clientes
    public List<Cliente> obtenerTodosclientes(){
        return clienteRepository.findAll();
    }

    // Metodo para obtener un cliente por su ID
    public Optional<Cliente> obtenerClientePorId(Long id){
        return clienteRepository.findById(id);
    }

    // Metodo para actualizar un cliente
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado){
        if (clienteRepository.existsById(id)){
            clienteActualizado.setId(id);
            return clienteRepository.save(clienteActualizado);
        }
        return null;
    }

    // Metodo para eliminar un cliente por su ID
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}

