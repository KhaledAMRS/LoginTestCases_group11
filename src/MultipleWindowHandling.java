import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MultipleWindowHandling {
    //Declaration new variable
    WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
    //1- Define setProperty
    System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");

    //2- Create new object from chromeDriver
    driver = new ChromeDriver();

    //3- Configurations
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //4- navigate
    driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @Test(priority = 1)
    public void facebook() throws InterruptedException {

    driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();

        System.out.println(driver.getCurrentUrl());
        // https://demo.nopcommerce.com/

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println(driver.getCurrentUrl());
        // https://www.facebook.com/nopCommerce

        driver.close();

        driver.switchTo().window(tabs.get(0));

    }



    @AfterMethod
    public void quitDriver() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }


}
