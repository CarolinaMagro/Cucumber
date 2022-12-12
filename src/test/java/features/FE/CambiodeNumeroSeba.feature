@functional
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

  Background: Login
    Given  El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"
    And    El usuario se encuentra en la pantalla Cambio de Nim

  #@browser
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
    Then  Se debe visualizar el mensaje de confirmacion

  #@browser
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
    Then  Se debe visualizar el mensaje de confirmacion

  @browser
  Scenario: TC_003_Hacer_NIM_elegido_manualmente
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

  @browser
  Scenario: TC_004_Hacer_NIM_elegido_manualmete_no_diponible
    Given Se busca el billing number "3512072771"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se habilita el check especial
    And   Se setea un numero especial "9999999999"
    And   Se obtiene el nuevo numero de linea especial
    When  Se hace click en el boton guardar nim

    #mejorar
    Then  Se debe visualizar el mensaje de error

  @browser
  Scenario Outline: TC_005_Hacer_NIM_con_número_no_habilitado_por_reglas_de_negocio
    Given Se busca el billing number "<numero>"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    When  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado "<mensaje_esperado>"
    Examples:
      |  numero      | mensaje_esperado  |
      |  3516858230  |aqui va el mensaje|

  @browser
  Scenario: TC_006_Deshacer_NIM_habilitado
    Given Se busca el billing number "<7439874329739>"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    And  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado "mensaje_esperado"
    #terminar

  @browser
  Scenario: TC_007_Deshacer_NIM_con_un_número_no_habilitado
    Given Se busca el billing number "7439874329739"
    And   Se setea el codigo de area con "11"
    And   El campo bloque debe actualizarse con el numero "AC001"
    And   Se obtiene el nuevo numero de linea
    And  Se hace click en el boton guardar nim
    And   Se verifica el mensaje esperado "mensaje_esperado"
    #terminar

  @browser
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

  #@browser
  Scenario Outline: TC_009_Completar_campos_requeridos_para_hacer_NIM
    Given    Se busca el billing number "<numero>"
    When     Se hace click en el boton guardar nim
    Then    Se verifica el mensaje esperado "<mensaje_esperado>"
    Examples:
      |  numero      | mensaje_esperado   |
      |  3516858230  | aqui va el mensaje |


