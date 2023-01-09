@functional
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"
    And    El usuario se encuentra en la pantalla Cambio de Nim

  @TC_001_Hacer_NIM_con_numero_generado
  Scenario: TC_001_Hacer_NIM_con_numero_generado
    Given Se busca el billing number "3512072567"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    When  Se hace click en el boton guardar nim
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido
    And   Se verifica el mensaje esperado "mensaje_esperado"

  @TC_002_Hacer_NIM_con_numero_especial_del_la_lista_sugerida
  Scenario: TC_002_Hacer_NIM_con_numero_especial_del_la_lista_sugerida
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se selecciona una opcion del combo
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido
    And   Se verifica el mensaje esperado "mensaje_esperado"

  @TC_003_Hacer_NIM_elegido_manualmente
  Scenario: TC_003_Hacer_NIM_elegido_manualmente
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And     El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se setea un numero especial "1123934090"
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado "mensaje_esperado"
    Then  Se debe resetear el campo codArea
    Then  Se debe resetear el campo bloque
    Then Se debe actualizar billing number con nuevo numero de linea obtenido
    Then  Se debe actualizar numero actual con nuevo numero de linea obtenido

  @TC_004_Hacer_NIM_elegido_manualmete_no_diponible
  Scenario: TC_004_Hacer_NIM_elegido_manualmete_no_diponible
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se setea un numero especial "9999999999"
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim
    Then   Se verifica el mensaje esperado "mensaje_esperado"

  @TC_005_Hacer_NIM_con_número_no_habilitado_por_reglas_de_negocio
  Scenario Outline: TC_005_Hacer_NIM_con_número_no_habilitado_por_reglas_de_negocio
    Given Se busca el billing number "<numero>"
    And   Se setea el codigo de area con "<codigoDeArea>"
    And   El campo bloque debe actualizarse con el numero "<bloque>"
    And   Se obtiene el nuevo numero de linea
    When  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado <mensaje_esperado>
    Examples:
      | numero       | codigoDeArea   | bloque     |  tipo_de_linea                                                                                 | mensaje_esperado |
      |  3516858230  | 11           |    AC001     |  "Código de Área inválido"                                                                     | "[Código de Área]: Código de área inválido" |
      |  76632172  |   3327         |    AC015     |  "Nuevo número generado => falla al liberarlo"                                                 | "[Código de Área]: Error al liberar el número generado." |
      |  76632172  |   3327         |    AC015     |  "Endpoint número de bloque devuelve error"                                                    | "[Código de Bloque]: Error al obtener el código de bloque." |
      |  76632172  |   3327         |    AC015     |  "Endpoint nuevo número devuelve error"                                                        | "[Número Nuevo]: Error al obtener un nuevo número disponible." |
      |  76632172  |   3327         |    AC015     |  "Código de Bloque inválido"                                                                   | "[Número Especial]: Código de bloque inválido o vacío." |
      |  76632172  |   3327         |    AC015     |  "número especial desselecionado devuelve error al liberar el número especial"                 | "[Número Especial]: Error al liberar el número especial seleccionado." |
      |  76632172  |   3327         |    AC015     |  "número generado, no responde número especial, devuelve error al liberar el número generado"  | "[Número Especial]: Error al liberar el número generado." |
      |  76632172  |   3327         |    AC015     |  "Endpoint de los números especiales devuelve error"                                           | "[Número Especial] Error en la linea: "|
      |  76632172  |   3327         |    AC015     |  "Endpoint de números especiales devuelve distinto de lista"                                   | "[Número Especial]: Error al obtener números especiales disponibles. No se obtuvo una lista." |
      |  76632172  |   3327         |    AC015     |  "Endpoint de los números especiales devuelve una lista vacía"                                 | "[Número Especial]: No hay números especiales disponibles. Lista vacía."|
      |  76632172  |   3327         |    AC015     |  "Número especial inválido"                                                                    | "[Número Especial]: El número especial seleccionado es inválido."|
      |  76632172  |   3327         |    AC015     |  "Reservar un número especial y el endpoint devuelve error"                                    | "[Número Especial]: Error al reservar el número {número a reservar}" |
      |  76632172  |   3327         |    AC015     |  "Número especial reservado correctamente"                                                     | "[Número Especial]: Se reservó el número correctamente."  |
      |  76632172  |   3327         |    AC015     |  "CDN - número actual es inválido"                                                             | "[Cambio de Número]: El número actual es inválido o vacío." |
      |  76632172  |   3327         |    AC015     |  "CDN - número especial es inválido"                                                           | "[Cambio de Número]: El número especial es inválido o vacío." |
      |  76632172  |   3327         |    AC015     |  "CDN - número generado es inválido"                                                           | "[Cambio de Número]: El nuevo número es inválido o vacío" |
      |  76632172  |   3327         |    AC015     |  "Endpoint de CDN devuelve un error"                                                           | "[Cambio de Número]: Error en el endpoint de cambio de NIM" |
      |  76632172  |   3327         |    AC015     |  "CDN correctamente"                                                                           | "[Cambio de Número]: Se ha cambiado el número exitosamente." |
      |  76632172  |   3327         |    AC015     |  "Endpoint devuelve error al reinicia el formulario de CDN con números reservados"             | "[Cambio de Número]: Error al liberar el/los número/s." |
      |  76632172  |   3327         |    AC015     |  "CDN formulario reiniciado correctamente"                                                     | "[Cambio de Número]: Operación cancelada exitosamente." |
      |  76632172  |   3327         |    AC015     |  "Error desconocido"                                                                           | "[Error Desconocido]: No se reconoce el error" |











  @TC_006_Deshacer_NIM_habilitado
  Scenario: TC_006_Deshacer_NIM_habilitado
    Given Se busca el billing number "<7439874329739>"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    And  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado "mensaje_esperado"
    #terminar

  @TC_007_Deshacer_NIM_con_un_número_no_habilitado
  Scenario: TC_007_Deshacer_NIM_con_un_número_no_habilitado
    Given Se busca el billing number "7439874329739"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    And  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado "mensaje_esperado"
    #terminar

  @TC_008_Corroborar_datos_requeridos_al_realizar_un_NIM
  Scenario Outline: TC_008_Corroborar_datos_requeridos_al_realizar_un_NIM
    Given  Se busca el billing number "<numero>"
    When   Se setea el codigo de area con "<codigoDeArea>"
    Then   El campo bloque debe actualizarse con el numero "<bloque>"
    Examples:
      |  numero      | codigoDeArea| bloque    |    descripcion                     |
      |  3516858230  |	3327	  |	AC015	   |	LOPEZ CAMELO	                |
      |  3516858230  |	491	      |	FIFWA	   |	SERVICIO FWA	                |
      |  3516858230  |	2285	  |	S1503	   |	LAPRIDA	                        |
      |  3516858230  |	2658	  |	S3906	   |	BUENA ESPERANZA	                |
      |  3516858230  |	2946	  |	S4902	   |	CHOELE CHOEL	                |
      |  3516858230  |  2338	  |	S5771	   |	VICTORICA                       |
      |  3516858230  |	3489	  |	AC002	   |	CAMPANA     	                |
      |  3516858230  |	221	      |	AC005	   |	LA PLATA	                    |
      |  3516858230  |	237	      |	AC008	   |	MORENO	                        |
      |  3516858230  |	2901	  |	S2901	   |	USHUAIA	                        |
      |  3516858230  |	2962	  |	S4602	   |	COMANDANTE LUIS PIEDRA BUENA	|
      |  3516858230  |	348	      |	AC003	   |	ESCOBAR	                        |
      |  3516858230  |	2475	  |	S0701	   |	ROJAS	                        |
      |  3516858230  |	2393	  |	S3404	   |	SALAZAR	                        |
      |  3516858230  |	2323	  |	AC006	   |	LUJAN	                        |
      |  3516858230  |	220	      |	AC014	   |	LIBERTAD	                    |
      |  3516858230  |	980	      |	FIM2M	   |	FICTM-M2M	                    |
      |  3516858230  |	3525	  |	N0300	   |	JESUS MARIA	                    |
      |  3516858230  |	343	      |	N1100	   |	N1100 - Parana	                |
      |  3516858230  |	2964	  |	S4601	   |	RIO GRANDE	                    |
      |  3516858230  |	2354	  |	S5772	   |	VEDIA	                        |
      |  3516858230  |	3487	  |	AC010	   |	ZARATE	                        |
      |  3516858230  |	3547	  |	N5700	   |	ALTA GRACIA	                    |
      |  3516858230  |	3781	  |	N6417	   |	CAA CATI	                    |
      |  3516858230  |	2646	  |	S5763	   |	SAN AGUSTIN DEL VALLE FERTIL	|
      |  3516858230  |	3488	  |	AC003	   |	ESCOBAR	                        |
      |  3516858230  |	2322	  |	AC009	   |	PILAR	                        |
      |  3516858230  |	230	      |	AC009	   |	PILAR	                        |
      |  3516858230  |	237	      |	AC012	   |	G.RODRIGUEZ	                    |
      |  3516858230  |	2202	  |	AC013	   |	GONZALEZ CATAN	                |
      |  3516858230  |	2963	  |	S4603	   |	PERITO MORENO	                |
      |  3516858230  |	11	      |	AC001	   |	AMBA	                        |
      |  3516858230  |	220	      |	AC007	   |	MERLO	                        |
      |  3516858230  |	2229	  |	AC011	   |	J.M. GUTIERREZ	                |
      |  3516858230  |	999	      |	FIM2M	   |	FICTM-M2M	                    |
      |  3516858230  |	342	      |	N0900	   |	N0900 - Santa Fe	            |
      |  3516858230  |	2902	  |	S2902	   |	RIO TURBIO	                    |
      |  3516858230  |	2925	  |	S5303	   |	BERNASCONI	                    |
      |  3516858230  |	2271	  |	S5764	   |	MONTE	                        |
      |  3516858230  |	2320	  |	AC004	   |	JOSE C. PAZ	                    |
      |  3516858230  |	3835	  |	L0100	   |	CORDOBA	                        |
      |  3516858230  |	351	      |	N0100	   |	CORDOBA	                        |
      |  3516858230  |	358	      |	N0800	   |	RIO CUARTO	                    |
      |  3516858230  |	2982	  |	S2990	   |	CLAROMECO                       |

  @TC_009_Completar_campos_requeridos_para_hacer_NIM
  Scenario Outline: TC_009_Completar_campos_requeridos_para_hacer_NIM
    Given    Se busca el billing number "<numero>"
    When     Se hace click en el boton guardar nim
    Then     Se verifica el mensaje esperado "<mensaje_esperado>"
    Examples:
      |  numero      | mensaje_esperado   |
      |  3516858230  | [Cambio de Número]: Hay campos inválidos o incompletos. |


