package pageObjects;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By loginEmailField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]/div[1]/div/ion-input/input");
    private final By passwordField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/div/ion-input/input");
    private final By btnLogin = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login[3]/ion-content/div[2]/div/ion-row[3]/ion-col/button");
    private final By errorMessageForInvalidLogin = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]/div[1]/div/ion-label/p");
    private final By linkForgotPassword = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login[3]/ion-content/div[2]/div/ion-row[2]/a");

    public By getLoginEmailField() {
        return loginEmailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public By getErrorMessageForInvalidLogin() {
        return errorMessageForInvalidLogin;
    }

    public By getLinkForgotPassword() {
        return linkForgotPassword;
    }
}
