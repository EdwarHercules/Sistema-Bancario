package com.prueba.test.Services;

import com.prueba.test.Entity.Cliente;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteListener {

    @Autowired
    private CuentaService cuentaService;

    @RabbitListener(queues = "clienteQueue")
    public  void recibirClienteActualizado(Cliente cliente){
        cuentaService.actualizarCuentasPorCliente(cliente);
    }
}
