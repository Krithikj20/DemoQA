import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
   // @Parameters("browser")
    @BeforeClass
   // public void setUp(String browser) {
    public void setUp() {
//
//
//        if(browser.equalsIgnoreCase("firefox")) {
//
////Initializing the firefox driver
//            driver = new FirefoxDriver();
//
//        }else if (browser.equalsIgnoreCase("chrome")) {
//
//            //Initialize the chrome driver
//            driver = new ChromeDriver();
//
//        }
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {

    driver.quit();
        }
    }

