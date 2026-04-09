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
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        // maximize browser to window
        driver.manage().window().maximize();
        // wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
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
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());
        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }

    @Test
    public void findElementByLinkText() {
        WebElement letCarWork = driver.findElement(By.linkText("Let car work"));
        System.out.println(letCarWork.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement work = driver.findElement(By.partialLinkText("work"));
        System.out.println(work.getText());
    }

    @Test
    public void findElementByCssSelector() {
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

    @Test
    public void findElementByXpath() {
        /*
        some_tag[@attribute='value']
        *[@attribute='value']
        tag[2]
        tag[@attr='value1' and @attr2='value']
        tag[@attr='value1' or @attr2='value']
        tag[@attr='value1' not @attr2='value']
        text(); contains();
        */
//        //driver.findElement(By.tagName("h1"));
//        driver.findElement(By.cssSelector("h1")); // для тега ничего не меняется
        driver.findElement(By.xpath("//h1"));
//        //driver.findElement(By.id("city"));
//        driver.findElement(By.cssSelector("#city")); //для id надо добавить #
        driver.findElement(By.xpath("//input[@id='city']"));
//        //driver.findElement(By.className("telephone"));
//        driver.findElement(By.cssSelector(".telephone")); // для класса добавить точку .
        driver.findElement(By.xpath("//*[@class='telephone']"));
//        //[attr='par']
//        driver.findElement(By.cssSelector("[href='/search']"));
//        driver.findElement(By.cssSelector("[for='city']"));
//        //contains -> *
//        driver.findElement(By.cssSelector("[href*='car']"));
        driver.findElement(By.xpath("//a[contains(@href,'car')]"));
//        //start -> ˆ
//        driver.findElement(By.cssSelector("[href^='/let']"));
        driver.findElement(By.xpath("//a[starts-with(@href,'/let')]"));
//        //end -> $
//        driver.findElement(By.cssSelector("[href$='work']"));
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'This car exceeded my')]"));
        WebElement elementSame = driver.findElement(By.xpath("//p[contains(.,'This car exceeded my')]"));//text можно заменить на .
        System.out.println(element.getText());
        System.out.println(elementSame.getText());

//        //-----------composite css
//        //tag+class+pair
//        driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/login']"));
//        //tag+class
//        driver.findElement(By.cssSelector("div.social-networks"));
        driver.findElement(By.xpath("//div[@class='social-networks']"));
//        //1 step down
//        driver.findElement(By.cssSelector(".header>.logo>img"));
        driver.findElement(By.xpath("//a[@class='logo']/img"));
//        //2 or more steps down
//        driver.findElement(By.cssSelector(".feedback-page .top-banner"));
        driver.findElement(By.xpath("//div[@class='feedback-page']//*[@class='top-banner']"));

//        WebElement element = driver.findElement(By.cssSelector(".feedback-card:nth-child(4)"));
//        System.out.println(element.getText());

    }
    @Test
    public void findElementByXpathFamily(){
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));
        driver.findElement(By.xpath("//h1/ancestor::*"));
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
