import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    // before -> setUp
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/"); // open browser without history
        //driver.navigate().to("https://www.google.com/"); // initialisation with history
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
    }

    //test
    @Test
    public void openGoogle(){
        System.out.println("Hello");
    }

    //after -> tearDown
    @AfterMethod
    public void tearDown(){
        driver.quit(); // close whole browser
       // driver.close(); // - close last tab in browser
    }
}
