@functional
Feature: Principal Page
  Como QAautomation quiero ingresar a la pantalla principal para testear su correcto funcionamiento

  @browser
  Scenario: Ingresar a cambio de Nim desde la pantalla principal
    Given   El usuario se encuentra en la pantalla principal
    When    Se hace click en el boton cambio de nim
    Then    Se debe redirigir a la pantalla Cambio de nim