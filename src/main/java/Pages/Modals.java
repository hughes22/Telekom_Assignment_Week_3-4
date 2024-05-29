package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Modals extends Calendars{

    public Modals(WebDriver driver) {
        super(driver);
    }
    By simple = By.id("simpleModal");
    By Form = By.id("formModal");
    By simpleCard = By.cssSelector("div[id=\"popmake-1318\"] ");
    By simpleText = By.cssSelector("div[id=\"popmake-1318\"] div[class=\"pum-content popmake-content\"]");
    By close = By.cssSelector("div[id=\"popmake-1318\"] button[class=\"pum-close popmake-close\"]");
    By CardBody = By.cssSelector("div[id=\"popmake-674\"]");
    By namefield = By.cssSelector("input[id=\"g1051-name\"]");
    By Email = By.cssSelector("input[id=\"g1051-email\"]");
    By textarea = By.cssSelector("textarea[id=\"contact-form-comment-g1051-message\"]");
    By sUbmit = By.cssSelector("p[class=\"contact-submit\"] button[type=\"submit\"]");
    public void SimpleModal(){
        driver.findElement(simple).click();
        WebElement cardMessage = driver.findElement(simpleCard);
        cardMessage.isDisplayed();
    }

    public void CardText(){
         WebElement cardtext = driver.findElement(simpleText);
         String text2 = cardtext.getText();
        if (!"Hi, I’m a simple modal.".equals(text2)) {
            throw new AssertionError("Unexpected Modal message: " + text2);
        }
        driver.findElement(close).click();
    }
    public void FormModal(){
        driver.findElement(Form).click();
        WebElement cardbody = driver.findElement(CardBody);
        cardbody.isDisplayed();

    }

    public void EnterYourName(String name){
        driver.findElement(namefield).sendKeys(name);
    }
    public void EnterYourEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void EnterYourMessage(String message){
        driver.findElement(textarea).sendKeys((message));
    }
    public void ClickSubmit(){
        driver.findElement(sUbmit).click();
    }

}
