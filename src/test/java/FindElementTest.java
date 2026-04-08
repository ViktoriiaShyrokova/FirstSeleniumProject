import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        // maximize browser to window
        driver.manage().window().maximize();
        // wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName(){
        // by - cтратегия, h1- локатор
        WebElement h1 = driver.findElement(By.tagName("h1"));// Option+Enter создает переменную
        System.out.println(h1.getText());
        WebElement h2 = driver.findElement(By.tagName("h2"));// Option+Enter создает переменную
        System.out.println(h2.getText());

        WebElement a = driver.findElement(By.tagName("a"));
        System.out.println(a.getAttribute("class"));


        List<WebElement> listA = driver.findElements(By.tagName("a"));
        System.out.println(listA.size());
        listA.forEach(aLink -> System.out.println(aLink.getText()));
    }

    @Test
    public void findElementById(){
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));
    }

    @Test
    public void findElementByClassName(){
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());
        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null) driver.quit();
    }
}
