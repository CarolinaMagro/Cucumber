@functional
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

#Seba
  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"
    And    El usuario se encuentra en la pantalla Cambio de Nim

#Seba
  @browser
  Scenario:  Hacer un cambio de número con numero generado
    Given Se busca el billing number "3512072567"
    And   Se setea el codigo de area con "11"
    And   Se obtiene el nuevo numero de linea
    When  Se hace click en el boton guardar nim
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido
    Then  Se debe visualizar el mensaje de exito




    #Seba
  @browser
  Scenario:  Hacer un cambio de número con numero especial del combo
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And   Se habilita el check especial
    And   Se selecciona una opcion del combo
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido
    Then  Se debe visualizar el mensaje de exito




