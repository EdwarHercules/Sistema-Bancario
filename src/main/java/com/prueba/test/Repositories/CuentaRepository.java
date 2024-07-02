package com.prueba.test.Repositories;

import com.prueba.test.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findByClienteId(Long clienteId);

    List<Cuenta> findByCliente_ClienteId(Long clienteId);

}
