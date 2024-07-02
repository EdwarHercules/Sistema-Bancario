package com.prueba.test.Services;

import com.prueba.test.Entity.Cuenta;
import com.prueba.test.Entity.Movimiento;
import com.prueba.test.Exceptions.CuentaNoEncontradaException;
import com.prueba.test.Exceptions.SaldoInsuficienteException;
import com.prueba.test.Repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaService cuentaService;

    // Metodo para crear un movimiento
    public Movimiento crearMovimiento(Movimiento movimiento){
        Optional<Cuenta> cuentaopt = cuentaService.obtenerCuentaPorId(movimiento.getCuenta().getId());
        if (cuentaopt.isPresent()){
            Cuenta cuenta = cuentaopt.get();
            double nuevoSaldo = cuenta.getsaldo_inicial() + movimiento.getValor();
            if (nuevoSaldo < 0) {
                throw  new SaldoInsuficienteException("Saldo no disponible");
            }
            cuenta.setsaldo_inicial(nuevoSaldo);
            cuentaService.actualizarCuenta(cuenta.getId(),cuenta);
            movimiento.setSaldo(nuevoSaldo);
            return movimientoRepository.save(movimiento);
        } else {
            throw  new CuentaNoEncontradaException("Cuenta no encontrada");
        }

    }

    // Metodo para obtener todos los movimientos
    public List<Movimiento> obtenerTodosmovimientos(){
        return movimientoRepository.findAll();
    }

    // Metodo para obtener un movimiento por su ID
    public Optional<Movimiento> obtenerMovimientoPorId(Long id){
        return movimientoRepository.findById(id);
    }

    // Metodo para actualizar un movimiento
    public Movimiento actualizarMovimiento(Long id, Movimiento movimientoActualizado){
        Optional<Movimiento> movimientoExistente = movimientoRepository.findById(id);
        if(movimientoExistente.isPresent()){
            Movimiento movimiento = movimientoExistente.get();
            movimiento.setFecha(movimientoActualizado.getFecha());
            movimiento.setTipoMovimiento(movimientoActualizado.getTipoMovimiento());
            movimiento.setValor(movimientoActualizado.getValor());
            return movimientoRepository.save(movimiento);
        }
        return null;
    }

    // Metodo para eliminar un movimiento por su ID
    public void eliminarMovimiento(Long id){
        movimientoRepository.deleteById(id);
    }
}
