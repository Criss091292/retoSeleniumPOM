# new feature
# Tags: optional

Feature: Como administrador del sistema
  necesito poder ver los usuarios registrados en el aplicativo y filtrarlos por rol
  para poder realizar seguimiento y control a los mismos

  Background:
    Given ingrese como usuario autenticado a la pagina de visualizacion de usuarios del sistema del aplicativo y en bd existen solo los roles Admin y ESS

    Scenario: buscar por rol especifico
      When selecciono un rol especifico y pulso search
      Then el sistema deberia solo mostrar los usuarios con el rol seleccionado

    Scenario: buscar por todos los roles
      When selecciono la opcion All y pulso search
      Then el sistema deberia solo mostrar usuarios con los roles existentes