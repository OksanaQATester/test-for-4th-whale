/**
 * In real life situation the following test would have
 * multiple browser and multiple versions as well as cross
 * devices test coverage
 */

package newProject;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Test_4th_Whale {
        WebDriver driver;
        @Test public void learnMoreBtnTest() {
        System.setProperty("webdriver.gecko.driver","{{path/to/geckodriver}}");

        //in real life situation we would load config with multiple browsers
        //in order to dynamically path test to multiple envs
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Let's mimic mobile phone viewport
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812));
        // Launch the application
        driver.get("https://www.rabbitsreviews.com/index.html");

        //This will scroll the web page till end.
        js.executeScript("document.querySelector(\".container.text-center > .btn.btn-primary\").scrollIntoView({block: \"center\"});");
        driver.findElement(By.cssSelector(".container.text-center > .btn.btn-primary > span")).click();

        //check if previous click takes a user to an appropriate page
        String h1Text = driver.findElement(By.cssSelector("#content > h1")).getText();
        Assert.assertEquals(h1Text, "How we work");

	}
}
