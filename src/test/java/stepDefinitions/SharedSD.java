package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class SharedSD {
    private static WebDriver driver;

    @Before
    public static void setUp() {
        PropertiesReader pr = new PropertiesReader();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        System.setProperty("webdriver.chrome.driver", pr.getChromeDriverPass());
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get(pr.getUrl());
    }

    @After
    public static void after() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
