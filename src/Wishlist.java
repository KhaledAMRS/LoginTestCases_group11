import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Wishlist {
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
    public void wishlist() throws InterruptedException {

List<WebElement> wishlist = driver.findElements(By.cssSelector("class=\"button-2 add-to-wishlist-button\""));
wishlist.get(2).click();

Thread.sleep(2000);

// Explicit wait

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement bar_notification = driver.findElement(By.id("bar-notification"));
    wait.until(ExpectedConditions.invisibilityOf(bar_notification));

driver.findElement(By.className("wishlist-label")).click();

        /*
List<WebElement> wishlist =  driver.findElements(By.className("add-to-wishlist-button"));
wishlist.get(2).click();

Thread.sleep(2000);

//Explicit wait:  wait until green label is disappeared then click on wishlist-label

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement greenLine = driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
        wait.until(ExpectedConditions.invisibilityOf(greenLine));

        driver.findElement(By.className("wishlist-label")).click();
*/
    }

    @Test(priority = 2)
    public void JavaScript()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }



    @AfterMethod
    public void quitDriver() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }


}
