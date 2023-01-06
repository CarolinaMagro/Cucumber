@EndToEnd
Feature: Login Page
  Como QA automation quiero ingresar a la pantalla Login para testear su correcto funcionamiento


  Scenario: Ingresar a pantalla login
    Given   El usuario se encuentra en la pantalla Login
    When    setea credenciales e ingresa a la app
    Then    Se debe dirigir a la pantalla con titulo "PGLS"



