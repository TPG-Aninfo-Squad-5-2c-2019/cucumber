	Feature: Consultar version de producto de un cliente
  			Como gerente de marketing quiero consultar las versiones de producto que usan los clientes
  			
  Scenario Outline: Ver los productos asociados al cliente
    Given estoy en la seccion de clientes
    When selecciono "<cliente>"
    Then los productos asociados al cliente se listan

    Examples:
      | 	cliente       |
      | ir_a_Coca_info    |