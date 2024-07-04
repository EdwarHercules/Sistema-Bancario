package com.prueba.test.Components;

import org.springframework.stereotype.Component;

@Component
public class MyReceiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
