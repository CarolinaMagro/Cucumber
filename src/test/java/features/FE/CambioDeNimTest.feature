@EndToEnd
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento


  Background:
    Given   El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"

  @browser
  Scenario Outline:  Ingresar a cambio de Nim
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se setea el codigo de area con el numero <codArea>
    Then    Se debe actualizar el bloque con el numero <bloque>

    Examples:
      | codArea | bloque |
      |   011   |  A1234 |


