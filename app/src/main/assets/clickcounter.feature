Feature: contador de clicks

  Scenario: crear contador en maestro
    Given dado mostrar lista con numero de contadores "0"
    When cuando pulsar boton master
    Then entonces mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"

  Scenario: crear contador en maestro con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    When cuando rotar pantalla
    Then entonces mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"


  Scenario: pulsar en contador de maestro
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"
    When cuando pulsar boton contador en posicion "0"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"


  Scenario: pulsar en contador de maestro con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"
    And y pulsar boton contador en posicion "0"
    When cuando rotar pantalla
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"

  Scenario: pulsar en contador de detalle
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"
    And y pulsar boton contador en posicion "0"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"
    When cuando pulsar boton detalle
    Then entonces mostrar contador con valor "2"
    And y mostrar numero de clicks con valor "2"


  Scenario: pulsar en contador de detalle con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"
    And y pulsar boton contador en posicion "0"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"
    And y pulsar boton detalle
    When cuando rotar pantalla
    Then entonces mostrar contador con valor "2"
    And y mostrar numero de clicks con valor "2"


  Scenario: pulsar en regresar de detalle
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"
    And y pulsar boton contador en posicion "0"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"
    And y pulsar boton detalle
    And y mostrar contador con valor "2"
    And y mostrar numero de clicks con valor "2"
    When cuando pulsar boton regresar
    And y mostrar contador en lista en posicion "0" con valor "2"
    And y mostrar lista con numero de contadores "1"

  Scenario: pulsar en regresar de detalle con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar lista con numero de contadores "1"
    And y pulsar boton contador en posicion "0"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"
    And y pulsar boton detalle
    And y mostrar contador con valor "2"
    And y mostrar numero de clicks con valor "2"
    And y pulsar boton regresar
    When cuando rotar pantalla
    And y mostrar contador en lista en posicion "0" con valor "2"
    And y mostrar lista con numero de contadores "1"


  Scenario: crear varios contadores en maestro
    Given dado mostrar lista con numero de contadores "0"
    When cuando pulsar boton master numero de veces "3"
    Then entonces mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"


  Scenario: pulsar varias veces en contador de maestro
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    When cuando pulsar boton contador en posicion "2"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"

  Scenario: pulsar varias veces en contadores de maestro
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    When cuando pulsar boton contador en posicion "1" numero de veces "2"
    And y pulsar boton contador en posicion "2"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "3"


  Scenario: pulsar en contador de detalles
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    And y pulsar boton contador en posicion "1" numero de veces "2"
    And y mostrar contador en lista en posicion "1" con valor "2"
    And y pulsar boton contador en posicion "1"
    And y mostrar contador con valor "3"
    And y mostrar numero de clicks con valor "3"
    When cuando pulsar boton detalle
    Then entonces mostrar contador con valor "4"
    And y mostrar numero de clicks con valor "4"


  Scenario: pulsar varias veces contador de detalles
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    And y pulsar boton contador en posicion "1" numero de veces "2"
    And y pulsar boton contador en posicion "2"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "3"
    When cuando pulsar boton detalle numero de veces "3"
    Then entonces mostrar contador con valor "4"
    And y mostrar numero de clicks con valor "6"



  Scenario: crear varios contadores en maestro con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    When cuando rotar pantalla
    Then entonces mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"


  Scenario: pulsar varias veces en contador de maestro con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    And y pulsar boton contador en posicion "2"
    When cuando rotar pantalla
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "1"

  Scenario: pulsar varias veces en contadores de maestro con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    And y pulsar boton contador en posicion "1" numero de veces "2"
    When cuando rotar pantalla
    And y pulsar boton contador en posicion "2"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "3"

  Scenario: pulsar en contador de detalles con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    And y pulsar boton contador en posicion "1" numero de veces "2"
    And y mostrar contador en lista en posicion "1" con valor "2"
    And y pulsar boton contador en posicion "1"
    And y mostrar contador con valor "3"
    And y mostrar numero de clicks con valor "3"
    And y pulsar boton detalle
    When cuando rotar pantalla
    Then entonces mostrar contador con valor "4"
    And y mostrar numero de clicks con valor "4"


  Scenario: pulsar varias veces contador de detalles con rotacion de pantalla
    Given dado mostrar lista con numero de contadores "0"
    And y pulsar boton master numero de veces "3"
    And y mostrar contador en lista en posicion "0" con valor "0"
    And y mostrar contador en lista en posicion "1" con valor "0"
    And y mostrar contador en lista en posicion "2" con valor "0"
    And y mostrar lista con numero de contadores "3"
    And y pulsar boton contador en posicion "1" numero de veces "2"
    And y pulsar boton contador en posicion "2"
    And y mostrar contador con valor "1"
    And y mostrar numero de clicks con valor "3"
    And y pulsar boton detalle numero de veces "3"
    When cuando rotar pantalla
    Then entonces mostrar contador con valor "4"
    And y mostrar numero de clicks con valor "6"