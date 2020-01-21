package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.SharedSD;
import utils.PropertiesReader;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public abstract class BasePage {

    private WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), TIMEOUT, POLLING);
    private static final int TIMEOUT = 15;
    private static final int POLLING = 100;
    private PropertiesReader propertiesReader = new PropertiesReader();

    public PropertiesReader getPropertiesReader() {
        return propertiesReader;
    }

    //wait visibility
    public void waitVisibility(By elementBy) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public boolean isElementDisplayed(By elementBy) {
        waitUntilElementDisplay(elementBy);
        return SharedSD.getDriver().findElement(elementBy).isDisplayed();
    }

    private void waitUntilElementDisplay(By elementBy) {
        int counter = 0;
       // System.out.println(counter);
        while (true) {
            try {
                counter++;
//                System.out.println(counter);
                SharedSD.getDriver().findElement(elementBy); //NoSuchElementException
                break;
            } catch (NoSuchElementException e) {
//                System.out.println(counter + "-> Element" + elementBy.toString() + " not found!");
                if (counter > 1000) {
                    break;
                }
            }
        }
        waitVisibility(elementBy);
    }

    //click
    public void click(By elementBy) {
        waitUntilElementDisplay(elementBy);
        SharedSD.getDriver().findElement(elementBy).click();
    }

    //write text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        SharedSD.getDriver().findElement(elementBy).sendKeys(text);
    }

    //read text
    public String readText(By elementBy) {
//        waitVisibility(elementBy);
        return SharedSD.getDriver().findElement(elementBy).getText();
    }

    //scrolls
    public void scrollByValues(String from, String to) {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(" + from + ", " + to + ")");
    }

    public void scrollDown(String from) {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(" + from + ", document.body.scrollHeight)");
    }

    public void scrollUp(String from) {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(" + from + ", -document.body.scrollHeight)");
    }

    public void scrollElement(By elementBy) {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elementBy);
    }

    //read Attribute
    public String readAttribute(By elementBy, String attribute) {
        waitVisibility(elementBy);
        return SharedSD.getDriver().findElement(elementBy).getAttribute(attribute);
    }

    //read CssValue
    public String readCSSValue(By elementBy, String style) {
        waitVisibility(elementBy);
        return SharedSD.getDriver().findElement(elementBy).getCssValue(style);
    }

    //assert
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void waitForElementToAppear(By elementBy) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementToDisappear(By elementBy) {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void waitForTextToDisappear(By elementBy, String text) {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(elementBy, text)));
    }

    public void assertElementsDisplayed(List<By> byList) {

        boolean isElementDisplayed = true;
        WebElement element;
        for (By e : byList) {
            try {
                element = SharedSD.getDriver().findElement(e);
            } catch (NoSuchElementException ex) {
                System.out.println(e + " - not found");
                isElementDisplayed = false;
                //break
            }
        }
        Assert.assertTrue(isElementDisplayed);
    }

    public void clearField(By elementBy) {
        waitVisibility(elementBy);
        SharedSD.getDriver().findElement(elementBy).clear();
    }
}
