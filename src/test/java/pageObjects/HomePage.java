package pageObjects;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    // all elements private final

    private final By loginButton = By.id("login");
    private final By signUpButton = By.id("signup");

    public By getLoginButton() {
        return loginButton;
    }

    public By getSignUpButton() {
        return signUpButton;
    }
}
