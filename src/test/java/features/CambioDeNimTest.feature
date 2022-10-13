@functional
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  @browser
  Scenario: Ingresar a cambio de Nim
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se completan los campos
      | numeroActual | codArea | bloque  | nuevoNumero |
      |  3512598560  |   011   |  ABC123 | 15-6504-6985|
    And Se hace click en el boton guardar nim
    Then Se debe visualizar el mensaje de confirmacion
    #And Se deben visualizar los cambios realizados

