@EndToEnd
Feature: Principal Page
  Como QA automation quiero ingresar a la pantalla principal para testear su correcto funcionamiento


  Background:
    Given   El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"

  @browser
  Scenario: Ingresar a cambio de Nim desde la pantalla principal
    Given   El usuario se encuentra en la pantalla principal
    When    Se hace click en el boton cambio de nim
    Then    Se debe redirigir a la pantalla Cambio de nim