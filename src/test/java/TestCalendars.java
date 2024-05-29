import Pages.Calendars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;

public class TestCalendars {

    WebDriver driver;
    private ConfigManager config;

    @BeforeTest
    public void beforeTest(){
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL3");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }
    @Test
    public void selectDate() throws InterruptedException {
        Calendars Date = new Calendars(driver);
        Date.ClickOnCalendar();
        Date.selectDate();
        Thread.sleep(5000);
        Date.clickSubmit();
        Date.VerifyMessageDisplayed();
    }

    @AfterTest
    public void exit(){
        driver.quit();
    }
}

