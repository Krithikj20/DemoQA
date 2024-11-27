import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
   @Parameters("browser")
    @BeforeClass
  public void setUp(String browser) {
//    public void setUp() {


       if (browser.equalsIgnoreCase("firefox")) {
FirefoxOptions opt=new FirefoxOptions();
opt.addArguments("-private");

           FirefoxProfile profile = new FirefoxProfile();

           // Set the preference to start in private browsing mode
           profile.setPreference("browser.privatebrowsing.autostart", true);

           // Create FirefoxOptions object and set the profile
           FirefoxOptions options = new FirefoxOptions();
           options.setProfile(profile);

           // Create a WebDriver instance using the options
          driver = new FirefoxDriver(options);
           driver.get("https://demoqa.com/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


       }
       if (browser.equalsIgnoreCase("chrome")) {
           driver = new ChromeDriver();
           driver.get("https://demoqa.com/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       }
   }
    @AfterClass
    public void tearDown() {
       driver.quit();
        }
    }

