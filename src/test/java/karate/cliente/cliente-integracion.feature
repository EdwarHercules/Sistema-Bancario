Feature: Pruebas de Integración de Cliente API

  Background:
    * url 'http://localhost:8080/api'

  Scenario: Crear un Cliente
    Given path 'cliente'
    And request { "password": "password", "estado": true, "persona": { "nombre": "Carlos Alberto", "genero": "Masculino", "edad": 21, "identificacion": "555555555", "direccion": "2 avenida 3 calle", "telefono": "111-111-111" } }
    When method post
    Then status 201
    And match response.clienteId == 1
    * print 'Prueba de integración de creación de cliente pasó exitosamente'

  Scenario: Obtener Cliente por ID
    Given path 'cliente/1'
    When method get
    Then status 200
    And match response.clienteId == 1
    And match response.persona.nombre == 'Carlos Alberto'
    * print 'Prueba de integración de obtener cliente por ID pasó exitosamente'
