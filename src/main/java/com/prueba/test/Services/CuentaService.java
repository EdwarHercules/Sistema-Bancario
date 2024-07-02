package com.prueba.test.Services;

import com.prueba.test.Entity.Cliente;
import com.prueba.test.Entity.Cuenta;
import com.prueba.test.Repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public void actualizarCuentasPorCliente(Cliente cliente){
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(cliente.getId());

        for (Cuenta cuenta : cuentas){
            cuenta.setEstado(cliente.isEstado());
            cuentaRepository.save(cuenta);
        }
    }

    // Metodo para crear una cuenta
    public Cuenta crearCuenta(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    // Metodo para obtener todas las cuentas
    public List<Cuenta> obtenerTodasCuentas(){
        return cuentaRepository.findAll();
    }

    // Método para obtener una cuenta por su ID
    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    // Metodo para actualizar una cuenta
    public Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada){
        if (cuentaRepository.existsById(id)){
            cuentaActualizada.setId(id);
            return cuentaRepository.save(cuentaActualizada);
        }
        return null;
    }

    // Metodo para eliminar una cuenta
    public void eliminarCuenta(Long id){
        cuentaRepository.deleteById(id);
    }
}
