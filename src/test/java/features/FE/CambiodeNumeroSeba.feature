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
  #@browser
  Scenario: Hacer un cambio de número con numero generado
    Given Se busca el billing number "3512072567"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    When  Se hace click en el boton guardar nim
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido
    Then  Se debe visualizar el mensaje de confirmacion




#Seba
  #@browser
  Scenario: Hacer un cambio de número con numero especial del combo
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And     El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se selecciona una opcion del combo
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido
    Then  Se debe visualizar el mensaje de confirmacion





    #Seba
  @browser
  Scenario: Hacer un cambio de número con numero elegido manualmente
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And     El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se setea un numero especial "1123934090"
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then  Se debe visualizar el mensaje de confirmacion
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido


    #Seba
  @browser
  Scenario: Hacer un cambio de número con numero elegido manualmete y que no este disponible
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se setea un numero especial "9999999999"
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then  Se debe visualizar el mensaje de error



    #Seba
  @browser
  Scenario: Hacer un cambio de número con numero no habilitado por reglas de negocio
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se setea un numero especial "9999999999"
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then  Se debe visualizar el mensaje de error

