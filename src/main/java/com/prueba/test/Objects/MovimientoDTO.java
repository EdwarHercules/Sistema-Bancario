package com.prueba.test.Objects;

import com.prueba.test.Entity.Cuenta;
import com.prueba.test.Entity.Movimiento;

import java.time.LocalDate;

public class MovimientoDTO {
    private Long cuentaOrigenId;
    private Long cuentaDestinoId;
    private Double valor;
    private String tipoMovimiento;
    public MovimientoDTO() {

    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Long getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Long cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public Long getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Long cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
