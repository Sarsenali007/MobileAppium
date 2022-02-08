package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.types.Path;
import org.aspectj.util.FileUtil;
import org.junit.Assert;
import org.openqa.selenium.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import lib.Platform;

import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver){

        this.driver = driver;
    }


    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );

    }

    public void scrollWebPageUp() {
        if(Platform.getInstance().isMW())
        {
            JavascriptExecutor JSExecuter = (JavascriptExecutor) driver;
            JSExecuter.executeScript("window.scrollBy(0, 250)");
        }
        System.out.println("Method scrollWebPageUp () do nothing for platform" + Platform.getInstance().getPlatformVar());

    }

    public void scrollWebPageTillElementNotVisible(String locator, String error_message, int max_swipes){
        int already_swiped = 0;

        WebElement element = this.waitForElementPresent(locator, error_message);
        while (this.isElementLocatedOnTheScreen(locator))
        {
            scrollWebPageUp();
            ++ already_swiped;
            if(already_swiped>max_swipes)
            {
                Assert.assertTrue(error_message, element.isDisplayed());
            }
        }
    }

    public WebElement waitForElementPresent(String locator, String error_message)
    {
        return waitForElementPresent(locator, error_message);
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    private void assertElementHasText(String locator, String expectedText, String errorMessage,long timeoutInSeconds ) {
        WebElement title_element = waitForElementPresent(
                locator,
                errorMessage,
                15
        );
        String article_title = title_element.getAttribute("text");
        Assert.assertEquals(
                errorMessage,
                expectedText,
                article_title
        );
    }
    private void assertElementHasTextNotWait(String locator, String expectedText, String errorMessage) {
        WebElement title_element = waitForElementPresent(
                locator,
                errorMessage
        );
        String article_title = title_element.getAttribute("text");
        Assert.assertEquals(
                errorMessage,
                expectedText,
                article_title
        );
    }
    protected void swipeUp(int timeOfSwipe) {
        if(driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.getWidth() / 2;
            int startY = (int) (size.getHeight() * 0.8);
            int endY = (int) (size.getHeight() * 0.2);

            action
                    .press(PointOption.point(x, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, endY))
                    .release()
                    .perform();
        }
        else
        {
            System.out.println("Method swipe up () do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
    protected void swipeUpQuick() {
        swipeUp(200);
    }

    protected void swipeUpToFindElement(String locator, String  errorMessage, int maxSwipes) {
        int alreadySwipes = 0;
        By by = this.getLocatorByString(locator);
        while (driver.findElements(by).size() == 0) {
            if (alreadySwipes > maxSwipes) {
                waitForElementPresent(
                        locator,
                        "Cannot find element by swiping up." + errorMessage,
                        0
                );
                return;
            }
            swipeUpQuick();
            alreadySwipes++;
        }
    }

    public void swipeUpTitleElementAppear(String locator, String errorMessage, int maxSwipes) {

        int alreadySwiped = 0;

        while (!this.isElementLocatedOnTheScreen(locator)) {
            if (alreadySwiped > maxSwipes) {
                Assert.assertTrue(errorMessage, this.isElementLocatedOnTheScreen(locator));
            }

            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator) {
        int elementLocationByY = this.waitForElementPresent(locator, "Cannot find element by locator", 1).getLocation().getY();
        if (Platform.getInstance().isMW()){
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            Object js_result = JSExecutor.executeScript("returnon window.pageYOffset");
            elementLocationByY -= Integer.parseInt(js_result.toString());

        }
        int screenSizeByY = driver.manage().window().getSize().getHeight();
        return elementLocationByY < screenSizeByY;
    }

    protected void swipeElementToLeft(String locator, String error_message) {

        if(driver instanceof AppiumDriver) {
            WebElement element = waitForElementPresent(
                    locator,
                    error_message,
                    10);
            int leftX = element.getLocation().getX();
            int rightX = leftX + element.getSize().getWidth();
            int upperY = element.getLocation().getY();
            int lowerY = upperY + element.getSize().getHeight();
            int middleY = (upperY + lowerY) / 2;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            action
                    .press(PointOption.point(rightX, middleY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(leftX, middleY))
                    .release()
                    .perform();
        }
        else
        {
            System.out.println("Method swipe up () do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
    protected int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements > 0) {
            String defaultMessage = "An element '" + locator.toString() + "' supposed to be not present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }

    private String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    private By getLocatorByString(String locater_with_type)
    {
        String[] exploded_locator = locater_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];
        System.out.println("locator is :" + locator);

        if (by_type.equals("xpath"))
        {
            return By.xpath(locator);
        }
        else if (by_type.equals("id"))
        {
            return By.id(locator);
        }
        else if (by_type.equals("css"))
        {
            return By.cssSelector(locator);
        }
        else
        {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locater_with_type);
        }
    }

    public String takeScreenshot(String name)
    {
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir" + "/" + name + "_screenshot.png");
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken:" + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path)
    {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        }
        catch (IOException e)
        {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }
}
