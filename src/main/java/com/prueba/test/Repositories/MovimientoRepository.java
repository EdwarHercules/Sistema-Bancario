package com.prueba.test.Repositories;

import com.prueba.test.Entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaBetweenAndCuentaClienteClienteId(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId);

    List<Movimiento> findByFechaBetweenAndCuentaId(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId);
}
