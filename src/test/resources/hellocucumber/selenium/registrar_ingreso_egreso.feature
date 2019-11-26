Feature: Registrar un Ingreso o Egreso para una fecha en particular
  Como gerente de finanzas quiero poder registrar un ingreso o Egreso

  Scenario: Registrar un Ingreso o Egreso
    Given que estoy situado sobre el calendario de ingresos y egresos
    When selecciono agregar un ingreso o egreso para una fecha en particular
    Then el sistema me pide que complete los campos: TIPO,EMPRESA,CONCEPTO,IMPORTE