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
    
    @
    Test
    public void findElementByLinkText(){
        WebElement letCarWork = driver.findElement(By.linkText("Let car work"));
        System.out.println(letCarWork.getText());
    }

    @Test
    public void findElementByPartialLinkText(){
        WebElement work = driver.findElement(By.partialLinkText("work"));
        System.out.println(work.getText());
    }

    @Test
    public void findElementByCssSelector(){
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1")); // для тега ничего не меняется
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city")); //для id надо добавить #
        //driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".telephone")); // для класса добавить точку .
        //[attr='par']
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='city']"));
        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ˆ
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end -> $
        driver.findElement(By.cssSelector("[href$='work']"));

        //-----------composite css
        //tag+class+pair
        driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        //tag+class
        driver.findElement(By.cssSelector("div.social-networks"));
        //1 step down
        driver.findElement(By.cssSelector(".header>.logo>img"));
        //2 or more steps down
        driver.findElement(By.cssSelector(".feedback-page .top-banner"));
        WebElement element = driver.findElement(By.cssSelector(".feedback-card:nth-child(4)"));
        System.out.println(element.getText());

    }

    @AfterMethod
    public void tearDown(){
        if(driver != null) driver.quit();
    }
}
