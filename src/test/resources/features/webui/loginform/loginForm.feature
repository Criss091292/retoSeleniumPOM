Feature: Como usuario del sistema
  necesito autenticarme en el aplicativo
  para poder ingresar a la plataforma y realizar mis actividades

  Background:
    Given ingreso directamente a la url correspondiente a la ruta admin -user management - users del aplicativo sin haberme autenticado



  Scenario: Inicio de sesion donde el password es invalido.
    When Escribo usuario correcto y contrasena incorrecta y pulso el boton submit.
    Then el sistema debera mostrar mensaje de credenciales invalidas.

  Scenario: Inicio de sesion donde el usuario es invalido.
    When  Escribo usuario incorrecto y contrasena correcta y pulso el boton submit
    Then  el sistema debera mostrar mensaje de error de credenciales.

  Scenario: Inicio de sesion exitoso.
    When Escribo usuario y contrasena correctos y pulso el boton submit
    Then el sistema debera mostrar la pagina de usuarios.

  Scenario: Inicio de sesion con usuario en blanco y password cualquiera.
    When dejo el usuario en blanco, escribo cualquier password y pulso submit
    Then el sistema debera mostrar mensaje de error indicando que el usuario no debe ser vacio

  Scenario: Inicio de sesion con usuario cualquiera y password en blanco.
    When dejo el password en blanco, escribo cualquier usuario y pulso submit
    Then el sistema debera mostrar mensaje de error indicando que el password no debe ser vacio