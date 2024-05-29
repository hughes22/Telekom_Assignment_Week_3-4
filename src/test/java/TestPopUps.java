import Pages.PopUps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPopUps {
    WebDriver driver;
    private ConfigManager config;

    @BeforeTest
    public void beforeTest(){
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL2");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }

    @Test
    public void PopupAlert() throws InterruptedException {
        PopUps pop = new PopUps(driver);
        pop.AlertPopUp();
        Thread.sleep(2000);
        String alert_message = config.getProperty("alert_message");
        pop.PromptPopUp(alert_message);
        Thread.sleep(2000);

        pop.ConfirmPopUp();
        Thread.sleep(2000);

        pop.verifypopuptext();
    }
    @AfterTest
    public void exit(){
        driver.quit();
    }
}
