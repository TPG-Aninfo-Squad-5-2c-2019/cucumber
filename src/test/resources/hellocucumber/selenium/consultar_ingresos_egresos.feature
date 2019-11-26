Feature: Consultar Ingresos y Egresos
  Como gerente de finanzas quiero poder ver ingresos y egresos

  Scenario: Ir al calendario de ingresos y egresos
    Given que estoy situado en finanzas
    When selecciono calendario de ingresos y egresos
    Then el sistema me muestra las fechas para consultar ingresos y egresos

  Scenario: Consultar detalles de un dia
    Given que estoy situado en el calendario de ingresos y egresos
    When selecciono ver detalles de un dia
	  Then el sistema me informa: TIPO,EMPRESA,CONCEPTO, IMPORTE