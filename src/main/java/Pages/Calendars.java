package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendars extends PopUps{

    public Calendars(WebDriver driver) {
        super(driver);
    }
    By calendar = By.xpath("//input[@id=\"g1065-selectorenteradate\"]");
    By date = By.cssSelector("[data-date=\"21\"]");
    By send = By.cssSelector("div[class='entry-content'] button[type='submit']");
    By display = By.xpath("//div//h4[@id=\"contact-form-success-header\"]");


    public void ClickOnCalendar(){
        driver.findElement(calendar).click();
    }
    public void selectDate(){
        driver.findElement(date).click();
    }

    public void clickSubmit(){
        driver.findElement(send).click();
    }
    public void VerifyMessageDisplayed(){
        WebElement message = driver.findElement(display);
        String Message = message.getText();
        if (!"Your message has been sent".equals(Message)) {
            throw new AssertionError("Unexpected Success message: " + Message);
        }
    }
}
