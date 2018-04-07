/**
 * Created by niutt17236 on 2018-3-8.
 */
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

public class XueQiu {
    private AppiumDriver<WebElement> driver;

    private List<Integer> values;

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 10;

    @Before
    public void setUp() throws Exception {
        // set up appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "ddd");
        driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

    }

    @Test
    public  void demo() throws InterruptedException {
        Thread.sleep(5000);
        locate("//*[@text='自选2']").click();
        Thread.sleep(5000);
        //driver.findElementByXPath("//*[@text='添加']").click();
        //Thread.sleep(5000);
        locate("action_create_cube").click();
        Thread.sleep(5000);
        locate("search_input_text").sendKeys("600570");
        Thread.sleep(5000);
        driver.navigate().back(); //系统操作用driver
        Thread.sleep(5000);
    }

    public  WebElement locate(String locator){
        try {
            if (locator.matches("\\/\\/.*")) {
                return driver.findElementByXPath(locator);
            }else{
                return  driver.findElementById(locator);
            }
        }finally {
            //System.out.println(driver.getPageSource());
            for (WebElement e: driver.findElementsByXPath("//*")){
                System.out.println(e.getTagName());
                System.out.println(e.getText());
                System.out.println("\n");
            }

            System.out.println();
        }

    }


    @Test
    public  void  scrollTest() throws InterruptedException {
        Thread.sleep(5000);
        TouchAction action = new TouchAction(driver);
        action.press(100,500).moveTo(100,1000).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After
    public  void after(){
        driver.quit();
    }

}
