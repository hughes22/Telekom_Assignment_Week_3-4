import Pages.Formfields;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFormfields {
    WebDriver driver;
    private ConfigManager config;

    @BeforeTest
    public void beforeTest(){
        config = new ConfigManager();
        String baseURL = config.getProperty("baseURL1");
        driver = new FirefoxDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }
    @Test
    public void field() throws InterruptedException {
        Formfields forms = new Formfields(driver);
        String username = config.getProperty("username");
        forms.enterFirstName(username);
        forms.selectFavoritedrink();
        forms.selectFavoriteColor();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        forms.selectAnySiblings();
        forms.selectFastAnimals();
        String email = config.getProperty("email");
        forms.enterEmail(email);
        String messages = config.getProperty("messages");
        forms.enterMessage(messages);
        forms.clickSubmit();
    }
    @AfterTest
    public void exit(){
        driver.quit();
    }
}

