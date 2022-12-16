import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    public static final String HOME_PAGE = "https://the-internet.herokuapp.com/";
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToHomePage();
    }

    private void goToHomePage(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
