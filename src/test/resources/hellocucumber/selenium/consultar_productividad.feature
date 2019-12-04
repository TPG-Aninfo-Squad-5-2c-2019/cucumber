Feature: Consultar la productividad de un desarrollador
  Como gerente de finanzas quiero poder ver la productividad de los desarrolladores

  Scenario: Consultar la productividad
    Given que estoy situado mi espacio de trabajo
    When selecciono la sección de Empleados
    And selecciono Desarrolladores
    Then el sistema me muestra un porcentaje de 0 a 100 indicando el nivel de esfuerzo realizado por cada desarrolador en cada proyecto