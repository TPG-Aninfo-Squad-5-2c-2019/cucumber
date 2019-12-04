Feature: Consultar Ingresos y Egresos
  Como gerente de finanzas quiero poder ver ingresos y egresos

  Scenario: Ir al calendario de ingresos y egresos
    Given que estoy situado en mi espacio de trabajo
    When selecciono calendario de ingresos y egresos
    Then el sistema me muestra las fechas para consultar ingresos y egresos

  Scenario: Ver importes de una fecha
    Given que estoy situado sobre el calendario de ingresos y egresos
    When selecciono una fecha
    Then el sistema me muestra todos los importes de los ingresos, egresos de la fecha
    And  me informa por cada ingreso y egreso: TIPO,EMPRESA,CONCEPTO, IMPORTE