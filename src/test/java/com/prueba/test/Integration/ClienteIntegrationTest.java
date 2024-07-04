package com.prueba.test.Integration;


import com.prueba.test.Entity.Cliente;
import com.prueba.test.Repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

public class ClienteIntegrationTest{

    private static final Logger logger = LoggerFactory.getLogger(ClienteIntegrationTest.class);


    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testObtenerClientePorIdIntegration() {
        // Arrange
        Long clienteId = 1L;

        // Act
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);


        logger.info("Ejecutando prueba de integración...");

        // Assert
        assertEquals(true, clienteOptional.isPresent(), "El cliente debería estar presente");
        Cliente cliente = clienteOptional.get();
        assertNotNull(cliente, "El cliente no debería ser nulo");
        assertEquals(clienteId, cliente.getId(), "El ID del cliente debería ser el esperado");
        // Agregar más aserciones según sea necesario para verificar otros atributos del cliente
    }
}
