import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class loginTestCases {
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
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 1)
    public void validLogin()
    {
  // Id, Name, ClassName, linkText/PartiallinkText, css selector, xpath

    //1- click on Form Authentication to open login page
    driver.findElement(By.cssSelector("a[href=\"/login\"]")).click();

    //2- enter valid username
    driver.findElement(By.id("username")).sendKeys("tomsmith");

    //3- enter valid password
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

    //4- user click on login button
    driver.findElement(By.className("radius")).click();

    //5- compare actual result with expected result using TestNG assertions

        SoftAssert soft = new SoftAssert();

    //5.1- user directed to secure url    https://the-internet.herokuapp.com/secure
  String actualUrl = driver.getCurrentUrl();
  soft.assertEquals(actualUrl,"https://the-internet.herokuapp.com/secure");

  //5.2- success message contain  "You logged into a secure area!"
  String actualMsg = driver.findElement(By.id("flash")).getText();
  soft.assertTrue(actualMsg.contains("You logged into a secure area"));

  //5.3- success message background color is green  expected result rgba(93, 164, 35, 1)      getCssValue()
    String actualColor =  driver.findElement(By.id("flash")).getCssValue("background-color");
    soft.assertEquals(actualColor,"rgba(93, 164, 35, 1)");
    soft.assertTrue(actualColor.contains("93, 164, 35, 1"));

    //How to convert RGBA to Hex
    String actualColorHex = Color.fromString(actualColor).asHex();
    soft.assertEquals(actualColorHex,"#5da423");

  //5.4- logout button is displayed (is visible on UI Page)   isDisplayed()
 boolean actualStatus  = driver.findElement(By.cssSelector("a[class=\"button secondary radius\"]")).isDisplayed();
        soft.assertEquals(actualStatus,true);
        soft.assertTrue(actualStatus);

        soft.assertAll();

    }

    @Test(priority = 2)
    public void invalidLogin()
    {

    //1- click on Form Authentication to open login page
    driver.findElement(By.cssSelector("a[href=\"/login\"]")).click();

    //2- enter invalid username
    driver.findElement(By.id("username")).sendKeys("khaled");

    //3- enter invalid password
    driver.findElement(By.id("password")).sendKeys("wrong");

    //4- user click on login button
    driver.findElement(By.className("radius")).click();


    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }



}
