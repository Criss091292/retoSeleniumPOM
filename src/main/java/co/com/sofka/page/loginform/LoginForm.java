package co.com.sofka.page.loginform;


import co.com.sofka.model.loginform.LoginFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginForm extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(LoginForm.class);
    private LoginFormModel loginFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    private static final String USERNAME = "txtUsername";
    private static final String PASSWORD = "txtPassword";
    private static final String SUBMIT = "btnLogin";
    private static final String WELCOME_MESSAGE_ID = "welcome";
    private static final String CREDENTIALS_VALIDATION_MESSAGE_ID = "spanMessage";
    //For input test cases.

    private final By userName = By.id(USERNAME);
    private final By password = By.id(PASSWORD);
    private final By submit = By.id(SUBMIT);

    //For Assertions test case.
    private final By assertionUserNameNotEmpty = By.id("spanMessage");


    public LoginForm(WebDriver driver, LoginFormModel loginFormModel) {
        super(driver);
        this.loginFormModel = loginFormModel;

    }

    public LoginForm(WebDriver driver, LoginFormModel loginFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);

        if(loginFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.loginFormModel = loginFormModel;

    }

    //Page functions.
    public void doLogin() throws IOException {
        clear(userName);
        typeInto(userName, loginFormModel.getUserName());
        clear(password);
        typeInto(password, loginFormModel.getPassword());
        doSubmit(submit);

    }


    public String getWelcomeMessage(){
        return getText(By.id(WELCOME_MESSAGE_ID));
    }

    public String getValidationMessage(){
        return getText(By.id(CREDENTIALS_VALIDATION_MESSAGE_ID));
    }
}
