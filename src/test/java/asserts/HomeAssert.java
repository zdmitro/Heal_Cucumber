package asserts;

import org.junit.Assert;
import pageObjects.HomePage;
import stepDefinitions.SharedSD;
import utils.PropertiesReader;

public class HomeAssert {
    private final PropertiesReader pr = new PropertiesReader();
    private final HomePage homePage = new HomePage();

    //Method which asserts

    public void assertHomePageIsOpened() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), pr.getUrl());
        Assert.assertTrue(this.homePage.isElementDisplayed(this.homePage.getLoginButton()));
        Assert.assertTrue(this.homePage.isElementDisplayed(this.homePage.getSignUpButton()));
    }

    public void assertLoginPageIsOpened() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), pr.getLoginPageURL());
    }
}
