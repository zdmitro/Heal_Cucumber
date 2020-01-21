package asserts;

import org.junit.Assert;
import pageObjects.LoginPage;
import stepDefinitions.SharedSD;
import utils.PropertiesReader;

public class LoginAssert {
    private final PropertiesReader pr = new PropertiesReader();
    private final LoginPage loginPage = new LoginPage();

    //Method which asserts

    public void assertLoginPageIsOpened() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), pr.getLoginPageURL());
    }

    public void assertErrorMessageIsDisplayed(String message) {
        Assert.assertEquals(loginPage.readText(loginPage.getErrorMessageForInvalidLogin()), message);
    }
}
