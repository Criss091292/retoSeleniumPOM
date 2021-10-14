package co.com.sofka.stepdefinition.viewsystemuser.opt1;

import co.com.sofka.model.viewsystemuser.ViewSystemUserModel;
import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.viewsystemuser.ViewSystemUserPage;
import co.com.sofka.page.loginform.LoginForm;
import co.com.sofka.stepdefinition.loginform.opt1.LoginFormCucumberOpt1StepDefinition;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.UserRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ViewSystemUserOpt1StepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginFormCucumberOpt1StepDefinition.class);
    private LoginFormModel loginFormModel;
    private LoginForm loginForm;
    private ViewSystemUserModel landingPageModel;
    private ViewSystemUserPage landingPage;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private static final String RIGHT_USER = "Admin";
    private static final String RIGHT_PASSWORD = "admin123";
    private static final int USER_ROLE_COLUMN_INDEX = 2;
    //Background


    @Given("ingrese como usuario autenticado a la pagina de visualizacion de usuarios del sistema del aplicativo y en bd existen solo los roles Admin y ESS")
    public void ingrese_como_usuario_autenticado_a_la_pagina_de_visualizacion_de_usuarios_del_sistema_del_aplicativo_y_en_bd_existen_solo_los_roles_admin_y_ess() {
        try{
            generalSetUp();
            loginFormModel = new LoginFormModel();
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

    @When("selecciono un rol especifico y pulso search")
    public void selecciono_un_rol_especifico_y_pulso_search() {
        try{
            landingPageModel = new ViewSystemUserModel();
            landingPageModel.setUserRole(UserRole.ADMIN);
            landingPage = new ViewSystemUserPage(driver, landingPageModel);
            landingPage.searchByUserRole(landingPageModel.getUserRole().getValue());
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberia solo mostrar los usuarios con el rol seleccionado")
    public void el_sistema_deberia_solo_mostrar_los_usuarios_con_el_rol_seleccionado() {
        try {
            Assertions.assertTrue(
                    landingPage.validateTableUsersAreFilteredByRoles(landingPage.getResultTable(),landingPageModel.getUserRole().getValue()),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("selecciono la opcion All y pulso search")
    public void selecciono_la_opcion_all_y_pulso_search() {
        try{
            landingPageModel = new ViewSystemUserModel();
            landingPageModel.setUserRole(UserRole.ALL);
            landingPage = new ViewSystemUserPage(driver, landingPageModel);
            landingPage.searchByUserRole(landingPageModel.getUserRole().getValue());
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }



    @Then("el sistema deberia solo mostrar usuarios con los roles existentes")
    public void el_sistema_deberia_solo_mostrar_usuarios_con_los_roles_existentes() {
        try {
            Assertions.assertTrue(
                    landingPage.validateTableWithFilterAll(landingPage.getResultTable(),landingPageModel.getUserRole().getValue()),
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
