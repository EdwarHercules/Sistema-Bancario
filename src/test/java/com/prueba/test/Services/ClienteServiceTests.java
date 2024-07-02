package com.prueba.test.Services;

import com.prueba.test.Entity.Cliente;
import com.prueba.test.Repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTests {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testcrearCliente() {
        // Datos de ejemplo para el nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Perez");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setIdentificacion("1234567890");
        cliente.setDireccion("Calle principal 123");
        cliente.setTelefono("0987654321");
        cliente.setClienteId(1L);
        cliente.setPassword("password");
        cliente.setEstado(true);

        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        Cliente nuevoCliente = clienteService.crearCliente(cliente);

        assertNotNull(nuevoCliente);
        assertEquals("Juan Perez", nuevoCliente.getNombre());
    }
}
