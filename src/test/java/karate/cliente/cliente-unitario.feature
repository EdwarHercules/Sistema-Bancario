Feature: Pruebas Unitarias de Cliente API

  Scenario: Obtener Cliente por ID
    Given url 'http://localhost:8080/api/cliente/1'
    When method get
    Then status 200
    And match response.clienteId == 1
    And match response.persona.nombre == 'Carlos Alberto'
    * print 'Prueba unitaria de obtener cliente por ID pasó exitosamente'
