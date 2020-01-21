package stepDefinitions;

import asserts.HomeAssert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import utils.PropertiesReader;

public class HomeSD {

    private final PropertiesReader pr = new PropertiesReader();
    private final HomeAssert homeAssert = new HomeAssert();
    private final HomePage homePage = new HomePage();

    @Given("^Home Page is opened$")
    public void homePageIsOpened() {
        this.homeAssert.assertHomePageIsOpened();
    }

    @When("^Login button is clicked$")
    public void loginButtonIsClicked() {
        this.homePage.click(this.homePage.getLoginButton());

    }

    @Then("^Assert Login page is opened$")
    public void assertLogInPageIsOpened() {
        this.homeAssert.assertLoginPageIsOpened();
    }

}
