package com.prueba.test.Services;

import com.prueba.test.Entity.Cliente;
import com.prueba.test.Entity.Persona;
import com.prueba.test.Repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTests {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testObtenerClientePorId() {
        Long clienteId = 1L;

        // Creación de una Persona de prueba
        Persona mockPersona = new Persona();
        mockPersona.setId(1L);
        mockPersona.setNombre("Carlos Alberto");
        mockPersona.setGenero("Masculino");
        mockPersona.setEdad(21);
        mockPersona.setIdentificacion("555555555");
        mockPersona.setDireccion("2 avenida 3 calle");
        mockPersona.setTelefono("111-111-111");

        // Creación de un Cliente de prueba
        Cliente mockCliente = new Cliente();
        mockCliente.setId(clienteId);
        mockCliente.setPassword("password");
        mockCliente.setEstado(true);
        mockCliente.setPersona(mockPersona);

        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(mockCliente));

        Optional<Cliente> clienteOptional = clienteService.obtenerClientePorId(clienteId);

        assertNotNull(clienteOptional);

        clienteOptional.ifPresent(cliente -> {
            assertEquals(clienteId, cliente.getId());
            assertEquals("password", cliente.getPassword());
            assertEquals(true, cliente.getEstado());
            assertNotNull(cliente.getPersona());
            assertEquals("Carlos Alberto", cliente.getPersona().getNombre());
            assertEquals("Masculino", cliente.getPersona().getGenero());
            assertEquals(21, cliente.getPersona().getEdad());
            assertEquals("555555555", cliente.getPersona().getIdentificacion());
            assertEquals("2 avenida 3 calle", cliente.getPersona().getDireccion());
            assertEquals("111-111-111", cliente.getPersona().getTelefono());
        });
    }
}

