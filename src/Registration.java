import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Registration {
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
    public void validRegister()
    {
    driver.findElement(By.className("ico-register")).click();

    driver.findElement(By.id("gender-male")).click();

    driver.findElement(By.id("FirstName")).sendKeys("khaled");
    driver.findElement(By.id("LastName")).sendKeys("Shabaik");

    // How to handle static dropdown using Select class
    WebElement dayelement = driver.findElement(By.name("DateOfBirthDay"));
    Select day = new Select(dayelement);
    day.selectByValue("4");

    WebElement monthelement = driver.findElement(By.name("DateOfBirthMonth"));
    Select month = new Select(monthelement);
    month.selectByValue("3");

    WebElement yearelement = driver.findElement(By.name("DateOfBirthYear"));
    Select year = new Select(yearelement);
    year.selectByValue("1999");



/*
    driver.findElement(By.className("ico-register")).click();

    driver.findElement(By.id("FirstName")).sendKeys("khaled");
    driver.findElement(By.id("LastName")).sendKeys("Shabaik");

    //Method1: How to handle static dropdown in selenium using Select class
    WebElement daylist = driver.findElement(By.name("DateOfBirthDay"));
    Select day = new Select(daylist);
    day.selectByVisibleText("4");
    day.selectByValue("4");
    day.selectByIndex(4);

    //Method2: How to handle static dropdown in selenium using findElements()
List<WebElement> dayOptions = driver.findElements(By.cssSelector("select[name=\"DateOfBirthDay\"] option"));
    dayOptions.get(4).click();
*/

    }


    @AfterMethod
    public void quitDriver() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }


}
