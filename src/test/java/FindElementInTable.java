import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementInTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findCssSelectorInTable() {
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        rows.forEach(a -> System.out.println(a.getAttribute("textContent")));

        WebElement austria = driver.findElement(By.cssSelector("#customers tr:nth-child(5) td:nth-child(3)"));//Austria
        System.out.println(austria.getAttribute("textContent"));
/*
        WebElement austria1 = driver.findElement(
                By.xpath("//table[@id='customers']//td[text()='Austria']")
        );
        System.out.println(austria1.getText());
        System.out.println("getText = [" + austria1.getText() + "]");// empty
        System.out.println("textContent = [" + austria1.getAttribute("textContent") + "]"); //Austria
        System.out.println(austria1.getAttribute("textContent").trim());
        //System.out.println(austria.getAttribute("innerText")); don't work
*/
        //get row 2,2 element
        WebElement maria = driver.findElement(By.cssSelector("#customers tr:nth-child(2) td:nth-child(2)"));
        System.out.println(maria.getText());
        System.out.println("*************************");

        //get row 4, last child
        WebElement last = driver.findElement(By.cssSelector("#customers tr:nth-child(4) td:last-child"));
        System.out.println(last.getText());

    }

    @Test
    public void findElementXpathInTable() {
//        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));
        System.out.println(rows.size());
//        rows.forEach(a -> System.out.println(a.getAttribute("textContent")));
//
//        WebElement austria = driver.findElement(By.cssSelector("#customers tr:nth-child(5) td:nth-child(3)"));//Austria
        WebElement austria = driver.findElement(By.xpath("//*[@id='customers']//tr[5]//td[3]"));//Austria
        System.out.println(austria.getAttribute("textContent"));
//        //get row 2,2 element
//        WebElement maria = driver.findElement(By.cssSelector("#customers tr:nth-child(2) td:nth-child(2)"));
        WebElement maria = driver.findElement(By.xpath("//*[@id='customers']//tr[2]//td[2]"));
        System.out.println(maria.getText());
//        System.out.println("*************************");
//
//        //get row 4, last child
//        WebElement last = driver.findElement(By.cssSelector("#customers tr:nth-child(4) td:last-child"));
        WebElement last = driver.findElement(By.xpath("//*[@id='customers']//tr[4]//td[last()]"));
        System.out.println(last.getText());

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
