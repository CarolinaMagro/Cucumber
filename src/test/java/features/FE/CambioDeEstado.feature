@functional
Feature: Cambio de Estado
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "GDL"
    And    El usuario se encuentra en la pantalla Cambio de estado


  @Dummy
  Scenario: TC_001_cancelar_un_estado_activo
    Given Se busca el billing number "3513970008"
    And   No se encuentra disponible el estado "cancelada"
    And   Se encuentra disponible el estado "activa"

    And   clickear en la opcion "Activa"
    And   Se selecciona la razon "Robo"
    When  Se hace click en el boton guardar cambio de estado
    Then  Se actualiza el estado actual a "Cancelado"
    And   Se actualiza la razon actual a "Falta de pago"


