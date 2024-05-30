import Pages.Tables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTables {
WebDriver driver;
    private ConfigManager config;
    @BeforeTest
    public void beforeTest() {
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL5");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }
    @Test
    public void TestItemPrices() throws InterruptedException {
        Tables price = new Tables(driver);
        price.simpleTable1();
        price.sortableTable();
        price.Search();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        price.VerifyRecord();

    }
    @AfterTest
    public void closeTest(){
        driver.quit();

    }
}
