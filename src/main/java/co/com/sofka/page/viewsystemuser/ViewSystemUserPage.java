package co.com.sofka.page.viewsystemuser;

import co.com.sofka.model.viewsystemuser.ViewSystemUserModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import co.com.sofka.page.loginform.LoginForm;
import co.com.sofka.util.UserRole;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class ViewSystemUserPage extends CommonActionsOnPages {
    private static final String WELCOME_MESSAGE_ID = "welcome";
    public ViewSystemUserPage(WebDriver driver, ViewSystemUserModel landingPageModel) {
        super(driver);
        this.landingPageModel = landingPageModel;
    }

    public ViewSystemUserPage(WebDriver driver, ViewSystemUserModel landingPageModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);

        if(landingPageModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.landingPageModel = landingPageModel;
    }

    private static final Logger LOGGER = Logger.getLogger(LoginForm.class);
    private ViewSystemUserModel landingPageModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //System users
    public static final String USER_NAME = "searchSystemUser_userName";
    public static final String USER_ROLE = "searchSystemUser_userType";
    public static final String EMPLOYEE_NAME = "searchSystemUser_employeeName_empName";
    public static final String STATUS = "searchSystemUser_status";
    public static final String SEARCH = "searchBtn";
    public static final String RESET = "resetBtn";

    public static final String ADD = "btnAdd";
    public static final String DELETE = "btnDelete";
    public static final String TABLE = "resultTable";


    //For input test cases.
    private final By username = By.id(USER_NAME);
    private final Select userRole = new Select(findElement(By.id(USER_ROLE)));
    private final By employee_name = By.id(EMPLOYEE_NAME);
    private final Select status = new Select(findElement(By.id(STATUS)));
    private final By searchButton = By.id(SEARCH);
    private final By resetButton = By.id(RESET);
    private final By addButton = By.id(ADD);
    private final By ResetButton = By.id(RESET);


    //For Assertions test case.


    public void searchByUserRole(String userRole) throws IOException {
        this.userRole.selectByVisibleText(userRole);
        doSubmit(searchButton);
    }

    public List<WebElement> getResultTable(){
        WebElement table = findElement(By.id(TABLE));
        return table.findElements(By.tagName("tr"));

    }
    public boolean validateTableUsersAreFilteredByRoles(List<WebElement> allRows, String userRole){
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if(i==2 && !cell.getText().equalsIgnoreCase(userRole)){
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public boolean validateTableWithFilterAll(List<WebElement> allRows, String userRole){
        for (WebElement row : allRows) {
               List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if(i==2 && (!cell.getText().equalsIgnoreCase(UserRole.ADMIN.getValue())&&!cell.getText().equalsIgnoreCase(UserRole.ESS.getValue()))){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
    public String getWelcomeMessage(){
        return getText(By.id(WELCOME_MESSAGE_ID));
    }



}
