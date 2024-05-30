import Pages.WindowsOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWindowsOperations {
        WebDriver driver;
    private ConfigManager config;
        @BeforeTest
         public void beforeTest(){
            config = new ConfigManager();
            String baseURL = config.getProperty("baseURL6");
            driver = new FirefoxDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();
        }
    @Test
    public void Window() throws InterruptedException {
        WindowsOperations window = new WindowsOperations(driver);
        window.NewTab();
        window.ReplaceWindow();
        window.NewWindow();
    }
    @AfterTest
    public void closeTest(){
        driver.quit();
    }
}
