@functional
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"
    And    El usuario se encuentra en la pantalla Cambio de Nim

  @browser
  Scenario: TC_001_cancelar_un_estado_activo
    Given Se busca el billing number "3512072567"
    And   Se hace click en el boton Cancelado
    And   Se selecciona la razon "Falta de pago"
    When  Se hace click en el boton guardar cambio de estado
    Then  Se actualiza el Estado a "Cancelado"
    And   Se actualiza la razon actual a "Falta de pago"

