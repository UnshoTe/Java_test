import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by niutt17236 on 2018-3-10.
 */
public class ApiDemo {

    private AppiumDriver<WebElement>  driver;
    @Before
    public  void before() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity", ".ApiDemos");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "ddd");
        driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
    }

    @Test
    public  void demoApi() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TouchAction action = new TouchAction(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Thread.sleep(2000);
        //action.longPress(100,1900).moveTo(100,100).release().perform();
        action.press(400,1500).waitAction(Duration.ofMillis(1000)).moveTo(100,300).release().perform();
        Thread.sleep(2000);
        driver.findElementById("Views").click();
        Thread.sleep(2000);
        action.press(400,1500).waitAction(Duration.ofMillis(1000)).moveTo(100,300).release().perform();
        Thread.sleep(2000);
        action.press(400,1500).waitAction(Duration.ofMillis(1000)).moveTo(100,300).release().perform();
        Thread.sleep(2000);
        //action.press(100,1800).waitAction(Duration.ofMillis(1000)).moveTo(100,100).release().perform();
        //Thread.sleep(5000);
        driver.findElementById("Popup Menu").click();
        Thread.sleep(2000);
        locate("Make a Popup!").click();
        Thread.sleep(2000);
        locate("//*[contains(@text,'Search')]").click();
        //Thread.sleep(500);
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='andriod.widget.Toast']"))).getText());
        }
        //for (int i=0;i<100;i++)
        //System.out.println(driver.findElementByXPath("//*[@class='andriod.wiget.toast']").getText());


    public  WebElement locate(String locator) {
        try {
            if (locator.matches("\\/\\/.*")) {
                return driver.findElementByXPath(locator);
            } else {
                return driver.findElementById(locator);
            }
        } finally {
            //System.out.println(driver.getPageSource());
            for (WebElement e : driver.findElementsByXPath("//*")) {
                System.out.println(e.getTagName());
                System.out.println(e.getText());
                System.out.println("\n");
            }
        }
    }

    @After
    public void quit(){
        driver.quit();
    }


}

