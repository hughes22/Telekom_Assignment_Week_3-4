import Pages.Sliders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSliders {
    WebDriver driver;
    private ConfigManager config;

    @BeforeTest
    public void beforeTest(){
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL9");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }

    @Test
  private void sliders(){
        Sliders test = new Sliders(driver);
        test.SlideMe();
        test.CurrentValue();
    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
    }

}
