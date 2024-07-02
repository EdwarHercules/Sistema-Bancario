package com.prueba.test.Services;


import com.prueba.test.Entity.Cliente;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientePublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarClienteActualizado(Cliente cliente){
        rabbitTemplate.convertAndSend("clienteQueue", cliente);
    }
}
