package com.prueba.test.Integration;

import com.prueba.test.Entity.Movimiento;
import com.prueba.test.Repositories.MovimientoRepository;
import com.prueba.test.Services.MovimientoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MovimientoServiceIntegrationTests {

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Test
    public void testRegistrarMovimiento(){
        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(LocalDate.now());
        movimiento.setTipoMovimiento("Deposito");
        movimiento.setValor(100.0);
        movimiento.setSaldo(100.0);

        Movimiento movimientoGuardado = movimientoService.crearMovimiento(movimiento);

        assertNotNull(movimientoGuardado.getId());
        assertEquals("Deposito", movimientoGuardado.getTipoMovimiento());
    }
}
