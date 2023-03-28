Feature: Dummy
Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "GDL"
    And    El usuario se encuentra en la pantalla Paquetes

  @Dummy
  Scenario: scenario de prueba
    Given Se busca el billing number "1121619069"
    And quiero hacer un test
    When asdfasd
    Then  dfgdsf

