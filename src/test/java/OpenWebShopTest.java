import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OpenWebShopTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openShopPage(){

    }

    @Test
    public void findElements(){
        driver.findElement(By.cssSelector("img[alt='Tricentis Demo Web Shop']"));//logo
        driver.findElement(By.className("ico-login")); // login link
        driver.findElement(By.className("search-box-text")); //search in header
        driver.findElement(By.cssSelector(".top-menu a[href='/apparel-shoes']"));//nav menu item
        List<WebElement> topMenu = driver.findElements(By.cssSelector(".top-menu a"));//whole list of menu
        topMenu.forEach(a -> System.out.println(a.getText()));
        driver.findElements(By.cssSelector(".listbox a[href='/jewelry']"));//listBox item
        driver.findElements(By.className("nivo-nextNav"));//next arrow for nivo main img
        driver.findElements(By.id("pollanswers-3"));//poll answer
        driver.findElements(By.cssSelector("[href=\"/producttag/6/computer\"]"));// tag from tags menu
        driver.findElement(By.cssSelector("[data-productid='72'] .rating"));// rating of third product
        driver.findElement(By.cssSelector("[data-productid='75'] .product-box-add-to-cart-button")); //add to card the last product
        driver.findElement(By.cssSelector(".my-account .ico-wishlist"));//wishlist at the footer
    }

    @Test
    public void findElementsByXpath(){
        driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));//logo
        driver.findElement(By.xpath("//a[@class='ico-login']")); // login link
        driver.findElement(By.xpath("//input[contains(@class,'search-box-text')]")); //search in header
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/apparel-shoes']"));//nav menu item
        List<WebElement> topMenu = driver.findElements(By.xpath("//ul[@class='top-menu']//a"));//whole list of menu
        topMenu.forEach(a -> System.out.println(a.getText()));
        driver.findElements(By.xpath("//*[@class='listbox']//a[@href='/jewelry']"));//listBox item
        driver.findElements(By.xpath("//a[@class='nivo-nextNav']"));//next arrow for nivo main img
        driver.findElements(By.xpath("//input[@id='pollanswers-3']"));//poll answer
        driver.findElements(By.xpath("//a[@href='/producttag/6/computer']"));// tag from tags menu
        driver.findElement(By.xpath("//*[@data-productid='72']//*[@class='rating']"));// rating of third product
        driver.findElement(By.xpath("//*[@data-productid='75']//input[contains(@class,'product-box-add-to-cart-button')]")); //add to card the last product
        driver.findElement(By.xpath("//*[@class='footer']//a[@class='ico-wishlist']"));//wishlist at the footer
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) driver.quit();
    }
}
