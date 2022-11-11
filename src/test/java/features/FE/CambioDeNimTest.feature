@functional
Feature: Cambio de Nim
  Como QA automation quiero ingresar a la pantalla Cambio de Nim para testear su correcto funcionamiento

#Seba
  Background: Login
    Given   El usuario se encuentra en la pantalla Login
    And    setea credenciales e ingresa a la app
    And    Se debe dirigir a la pantalla con titulo "PGL"

#Seba
  @browser
  Scenario Outline:  Ingresar a cambio de Nim
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se setea el codigo de area con el numero <codArea>
    Then    Se debe actualizar el bloque con el numero <bloque>

    Examples:
      | codArea | bloque |
      |   011   |  A1234 |
      |   348   |  asdf |
      |   2322  | jfgf  |
      |   345   |  a345  |
      |  654    |  A654  |



#Caro
  @browser
  Scenario Outline: Ingresar a cambio de Nim
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se completa el <codigoDeArea>
    And Se hace click en el boton guardar nim
    Then Se debe visualizar el mensaje de confirmacion
    #And Se deben visualizar los cambios realizados
    Examples:
      | codigoDeArea |
      |   011        |

  @browser
  Scenario Outline: Corroborar el bloque generado
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se utiliza el <numero>
    And     Se completa el <codigoDeArea>
    Then    El campo <bloque> debe actualizarse
    Examples:

      |  numero      | codigoDeArea  |  bloque    |    descripcion                     |
      |  3512090566  |	3327	      |	AC015	   |	LOPEZ CAMELO	                |
      |  3512090566  |	491	      |	FIFWA	   |	SERVICIO FWA	                |
      |  3512090566  |	2285	      |	S1503	   |	LAPRIDA	                        |
      |  3512090566  |	2658	      |	S3906	   |	BUENA ESPERANZA	                |
      |  3512090566  |	2946	      |	S4902	   |	CHOELE CHOEL	                |
      |  3512090566  | 2338	      |	S5771	   |	VICTORICA                       |
      |  3512090566  |	3489	      |	AC002	   |	CAMPANA     	                |
      |  3512090566  |	221	          |	AC005	   |	LA PLATA	                    |
      |  3512090566  |	237	          |	AC008	   |	MORENO	                        |
      |  3512090566  |	2901	      |	S2901	   |	USHUAIA	                        |
      |  3512090566  |	2962	      |	S4602	   |	COMANDANTE LUIS PIEDRA BUENA	|
      |  3512090566  |	348	          |	AC003	   |	ESCOBAR	                        |
      |  3512090566  |	2475	      |	S0701	   |	ROJAS	                        |
      |  3512090566  |	2393	      |	S3404	   |	SALAZAR	                        |
      |  3512090566  |	2323	      |	AC006	   |	LUJAN	                        |
      |  3512090566  |	220	          |	AC014	   |	LIBERTAD	                    |
      |  3512090566  |	980	          |	FIM2M	   |	FICTM-M2M	                    |
      |  3512090566  |	3525	      |	N0300	   |	JESUS MARIA	                    |
      |  3512090566  |	343	          |	N1100	   |	N1100 - Parana	                |
      |  3512090566  |	2964	      |	S4601	   |	RIO GRANDE	                    |
      |  3512090566  |	2354	      |	S5772	   |	VEDIA	                        |
      |  3512090566  |	3487	      |	AC010	   |	ZARATE	                        |
      |  3512090566  |	3547	      |	N5700	   |	ALTA GRACIA	                    |
      |  3512090566  |	3781	      |	N6417	   |	CAA CATI	                    |
      |  3512090566  |	2646	      |	S5763	   |	SAN AGUSTIN DEL VALLE FERTIL	|
      |  3512090566  |	3488	      |	AC003	   |	ESCOBAR	                        |
      |  3512090566  |	2322	      |	AC009	   |	PILAR	                        |
      |  3512090566  |	230	          |	AC009	   |	PILAR	                        |
      |  3512090566  |	237	          |	AC012	   |	G.RODRIGUEZ	                    |
      |  3512090566  |	2202	      |	AC013	   |	GONZALEZ CATAN	                |
      |  3512090566  |	2963	      |	S4603	   |	PERITO MORENO	                |
      |  3512090566  |	11	          |	AC001	   |	AMBA	                        |
      |  3512090566  |	220	          |	AC007	   |	MERLO	                        |
      |  3512090566  |	2229	      |	AC011	   |	J.M. GUTIERREZ	                |
      |  3512090566  |	999	          |	FIM2M	   |	FICTM-M2M	                    |
      |  3512090566  |	342	          |	N0900	   |	N0900 - Santa Fe	            |
      |  3512090566  |	2902	      |	S2902	   |	RIO TURBIO	                    |
      |  3512090566  |	2925	      |	S5303	   |	BERNASCONI	                    |
      |  3512090566  |	2271	      |	S5764	   |	MONTE	                        |
      |  3512090566  |	2320	      |	AC004	   |	JOSE C. PAZ	                    |
      |  3512090566  |	3835	      |	L0100	   |	CORDOBA	                        |
      |  3512090566  |	351	          |	N0100	   |	CORDOBA	                        |
      |  3512090566  |	358	          |	N0800	   |	RIO CUARTO	                    |
      |  3512090566  |	2982	      |	S2990	   |	CLAROMECO	                    |



  Scenario: Habilitacion de Check numero especial
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    se habilita el check numero especial
    Then se debe habilitar el campo nuevo numero de linea

  Scenario: Habilitacion de Check numero especial
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    se habilita el check numero especial
    Then se debe habilitar el campo nuevo numero de linea

  Scenario: Ingresar a cambio de Nim
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    se habilita el check numero especial
    Then se debe habilitar el campo nuevo numero de linea

  Scenario: Ingresar a cambio de Nim
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    se habilita el check numero especial
    Then se debe habilitar el campo nuevo numero de linea


  Scenario Outline: Ingresar a cambio de Nim con el <numero> y que aparezca Cambio de NIM
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se utiliza el <numero>
    Then    Se debe visualizar cambio de NIM
    Examples:
      | numero        |
      |  3512090566   |

  Scenario Outline: Ingresar a cambio de Nim con el <numero>  y que aparezca Deshacer Cambio de NIM
    Given   El usuario se encuentra en la pantalla Cambio de Nim
    When    Se utiliza el <numero>
    Then    Se debe visualizar deshacer cambio de NIM
    Examples:
      | numero        |
      |  3512090566   |