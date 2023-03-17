@functional
Feature: Cambio de Estado
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "GDL"
    And    El usuario se encuentra en la pantalla Cambio de estado


  @Dummy
  Scenario: TC_001_Activar_un_estado_cancelado
    Given Se busca el billing number "3513922643"
    And   No se encuentra disponible el estado "CANCELADA"
    And   No se encuentra disponible el estado "SUSPENDIDA"
    And   Se encuentra disponible el estado "ACTIVA"

    And   clickear en la opcion "ACTIVA"
    And   Se selecciona la razon "R2"
    When  Se hace click en el boton guardar cambio de estado
    Then  Se actualiza el estado actual a "ACTIVA"
    Then  Se actualiza la razon actual a "R2"
    Then Se debe visualzar un mensaje de "Éxito"

  @Dummy
  Scenario: TC_002_Suspender_un_estado_activo
    Given Se busca el billing number "3513922643"
    And   No se encuentra disponible el estado "ACTIVA"
    And   Se encuentra disponible el estado "CANCELADA"
    And   Se encuentra disponible el estado "SUSPENDIDA"

    And   clickear en la opcion "SUSPENDIDA"
    And   Se selecciona la razon "R1"
    When  Se hace click en el boton guardar cambio de estado
    Then  Se actualiza el estado actual a "SUSPENDIDA"
    Then  Se actualiza la razon actual a "R1"
    Then Se debe visualzar un mensaje de "Éxito"

  @Dummy
  Scenario: TC_003_cancelar_un_estado_suspendido
    Given Se busca el billing number "3513922643"
    And   No se encuentra disponible el estado "SUSPENDIDA"
    And   Se encuentra disponible el estado "CANCELADA"
    And   Se encuentra disponible el estado "ACTIVA"

    And   clickear en la opcion "CANCELADA"
    And   Se selecciona la razon "COMPET"
    When  Se hace click en el boton guardar cambio de estado
    Then  Se actualiza el estado actual a "CANCELADA"
    Then  Se actualiza la razon actual a "COMPET"
    Then Se debe visualzar un mensaje de "Éxito"

