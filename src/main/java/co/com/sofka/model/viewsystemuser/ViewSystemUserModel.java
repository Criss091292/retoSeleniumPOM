package co.com.sofka.model.viewsystemuser;

import co.com.sofka.util.Status;
import co.com.sofka.util.UserRole;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewSystemUserModel {
    private String userName;
    private UserRole userRole;
    private String empployee_name;
    private Status status;
    private List<WebElement> resultTable;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getEmpployee_name() {
        return empployee_name;
    }

    public void setEmpployee_name(String empployee_name) {
        this.empployee_name = empployee_name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<WebElement> getResultTable() {
        return resultTable;
    }

    public void setResultTable(List<WebElement> resultTable) {
        this.resultTable = resultTable;
    }

}
