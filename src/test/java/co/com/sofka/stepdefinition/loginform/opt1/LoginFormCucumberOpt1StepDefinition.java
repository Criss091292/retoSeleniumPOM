package co.com.sofka.stepdefinition.loginform.opt1;

import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.loginform.LoginForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;



public class LoginFormCucumberOpt1StepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginFormCucumberOpt1StepDefinition.class);
    private LoginFormModel loginFormModel;
    private LoginForm loginForm;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private static final String WELCOME_MESSAGE = "Welcome";
    private static final String WRONG_USER = "Administrador123";
    private static final String WRONG_PASSWORD = "Admin1234";
    private static final String RIGHT_USER = "Admin";
    private static final String RIGHT_PASSWORD = "admin123";
    private static final String EMPTY_USER = "";
    private static final String EMPTY_PASSWORD = "";
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid credentials";
    private static final String USERNAME_CANNOT_BE_EMPTY_MESSAGE = "Username cannot be empty";
    private static final String PASSWORD_CANNOT_BE_EMPTY_MESSAGE = "Password cannot be empty";

    public LoginFormCucumberOpt1StepDefinition() {
    }

    //Background
    @Given("ingreso directamente a la url correspondiente a la ruta admin -user management - users del aplicativo sin haberme autenticado")
    public void ingreso_directamente_a_la_url_correspondiente_a_la_ruta_admin_user_management_users_del_aplicativo_sin_haberme_autenticado() {
        try{
            generalSetUp();
            loginFormModel = new LoginFormModel();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @When("Escribo usuario correcto y contrasena incorrecta y pulso el boton submit.")
    public void escriboUsuarioCorrectoYContrasenaIncorrectaYPulsoElBotonSubmit() {
        try{
            loginFormModel.setUserName(RIGHT_USER);
            loginFormModel.setPassword(WRONG_PASSWORD);
            loginForm = new LoginForm(driver, loginFormModel);
            loginForm.doLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @Then("el sistema debera mostrar mensaje de credenciales invalidas.")
    public void el_sistema_debera_mostrar_mensaje_de_credenciales_invalidas() {
        try {
            Assertions.assertEquals(
                    INVALID_CREDENTIALS_MESSAGE,
                    loginForm.getValidationMessage(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("Escribo usuario incorrecto y contrasena correcta y pulso el boton submit")
    public void Escribo_usuario_incorrecto_y_contrasena_correcta_y_pulso_el_boton_submit() {
        try{
            loginFormModel.setUserName(WRONG_USER);
            loginFormModel.setPassword(RIGHT_PASSWORD);
            loginForm = new LoginForm(driver, loginFormModel);
            loginForm.doLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @Then("el sistema debera mostrar mensaje de error de credenciales.")
    public void el_sistema_debera_mostrar_mensaje_de_error_de_credenciales() {
        try {
            Assertions.assertEquals(
                    INVALID_CREDENTIALS_MESSAGE,
                    loginForm.getValidationMessage(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("Escribo usuario y contrasena correctos y pulso el boton submit")
    public void escribo_usuario_y_contrasena_correctos_y_pulso_el_boton_submit() {
        try{
            loginFormModel.setUserName(RIGHT_USER);
            loginFormModel.setPassword(RIGHT_PASSWORD);
            loginForm = new LoginForm(driver, loginFormModel);
            loginForm.doLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debera mostrar la pagina de usuarios.")
    public void el_sistema_debera_mostrar_la_pagina_de_usuarios() {
        try {
            Assertions.assertTrue(
                    loginForm.getWelcomeMessage().contains(WELCOME_MESSAGE),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("dejo el usuario en blanco, escribo cualquier password y pulso submit")
    public void dejo_el_usuario_en_blanco_escribo_cualquier_password_y_pulso_submit() {
        try{
            loginFormModel.setUserName(EMPTY_USER);
            loginFormModel.setPassword(WRONG_PASSWORD);
            loginForm = new LoginForm(driver, loginFormModel);
            loginForm.doLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debera mostrar mensaje de error indicando que el usuario no debe ser vacio")
    public void el_sistema_debera_mostrar_mensaje_de_error_indicando_que_el_usuario_no_debe_ser_vacio() {
        try {
            Assertions.assertEquals(
                    USERNAME_CANNOT_BE_EMPTY_MESSAGE,
                    loginForm.getValidationMessage(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("dejo el password en blanco, escribo cualquier usuario y pulso submit")
    public void dejo_el_password_en_blanco_escribo_cualquier_usuario_y_pulso_submit() {
        try{
            loginFormModel.setUserName(WRONG_USER);
            loginFormModel.setPassword(EMPTY_PASSWORD);
            loginForm = new LoginForm(driver, loginFormModel);
            loginForm.doLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @Then("el sistema debera mostrar mensaje de error indicando que el password no debe ser vacio")
    public void el_sistema_debera_mostrar_mensaje_de_error_indicando_que_el_password_no_debe_ser_vacio() {
        try {
            Assertions.assertEquals(
                    PASSWORD_CANNOT_BE_EMPTY_MESSAGE,
                    loginForm.getValidationMessage(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
}
