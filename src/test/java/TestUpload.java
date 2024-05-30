import Pages.FileUpload;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUpload {
    WebDriver driver;
    private ConfigManager config;

    @BeforeTest
    public void BeforeTest(){
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL7");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }
    @Test
    public void Upload() throws InterruptedException {
        FileUpload browse = new FileUpload(driver);
        String link = config.getProperty("link");
        browse.Browse(link);
        browse.ClickUpload();
        browse.AssertMessage();
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
