import Pages.FileDownload;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDownload {
    WebDriver driver;
    private ConfigManager config;

@BeforeTest
    public void BeforeTest(){
    config = new ConfigManager();
    String baseURL = config.getProperty("baseURL8");
    driver = new FirefoxDriver();
    driver.get(baseURL);
}
@Test
    public void clickDownload() throws InterruptedException {
        FileDownload download = new FileDownload(driver);

        download.Downloadpdf();
        download.Downloaddocx();
        download.verifyfromalert();
    }

    @AfterTest
    public void AfterTest(){
    driver.quit();
    }

}
