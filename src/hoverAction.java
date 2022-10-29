import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class hoverAction {
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
    public void mouseHover()
    {
    Actions hover = new Actions(driver);
    WebElement category = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
    hover.moveToElement(category).perform();

    driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]")).click();

        /*
        //WebElement
  WebElement element = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));

  Actions hover = new Actions(driver);

  hover.moveToElement(element).perform();

  //List of webElement to save 3 subcategories   [Desktops, Notebooks, Software]
String selector = "ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]+div[class=\"sublist-toggle\"]+ul[class=\"sublist first-level\"] a[href]";
List<WebElement> subcategory = driver.findElements(By.cssSelector(selector));
int count = subcategory.size();

//select random subcategory
        Random rand = new Random();
  int subCatNum =  rand.nextInt(count);   //select random value from 0 to 2
  subcategory.get(subCatNum).click();
*/
    }


    @AfterMethod
    public void quitDriver() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }



}
