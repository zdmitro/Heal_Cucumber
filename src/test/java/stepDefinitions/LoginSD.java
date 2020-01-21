package stepDefinitions;

import asserts.LoginAssert;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.PropertiesReader;

public class LoginSD {

    private final PropertiesReader pr = new PropertiesReader();
    private final LoginAssert loginAssert = new LoginAssert();
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Given("^Login Page is opened$")
    public void loginPageIsOpened() {
        homePage.click(homePage.getLoginButton());
        loginAssert.assertLoginPageIsOpened();
    }

    @When("^Login entered as \"([^\"]*)\"$")
    public void loginEnteredAs(String loginEmail) {
        this.loginPage.writeText(this.loginPage.getLoginEmailField(), loginEmail);
    }

    @And("^Password entered as \"([^\"]*)\"$")
    public void passwordEnteredAs(String password) {
        this.loginPage.writeText(this.loginPage.getPasswordField(), password);
    }

    @And("^Login Page Login button is clicked$")
    public void loginPageLoginButtonIsClicked() {
        this.loginPage.click(this.loginPage.getBtnLogin());
    }

    @Then("^Error message \"([^\"]*)\" is displayed$")
    public void errorMessageIsDisplayed(String message) {
        this.loginAssert.assertErrorMessageIsDisplayed(message);
    }


}
