import Pages.Modals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestModals {
    WebDriver driver;
    private ConfigManager config;

    @BeforeTest
    public void beforeTest() {
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL4");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }

    @Test
    public void usingmodal() throws InterruptedException {
        Modals dialog = new Modals(driver);
        dialog.SimpleModal();

        dialog.CardText();
        Thread.sleep(2000);

        dialog.FormModal();

        String username = config.getProperty("username");
        dialog.EnterYourName(username);

        String email = config.getProperty("email");
        dialog.EnterYourEmail(email);

        String alert_message = config.getProperty("alert_message");
        dialog.EnterYourMessage(alert_message);

        dialog.ClickSubmit();
    }
    @AfterTest
    public void exit(){
        driver.quit();
    }
}

