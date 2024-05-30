package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Calendars extends PopUps{
    private WebDriverWait wait;

    public Calendars(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By calendar = By.xpath("//input[@id=\"g1065-selectorenteradate\"]");
    By date = By.cssSelector("[data-date=\"21\"]");
    By send = By.cssSelector("div[class='entry-content'] button[type='submit']");
    By display = By.xpath("//div//h4[@id=\"contact-form-success-header\"]");


    public void ClickOnCalendar(){
        driver.findElement(calendar).click();
    }
    public void selectDate(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(date));
        driver.findElement(date).click();
    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(send));
        driver.findElement(send).click();
    }
    public void VerifyMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(display));
        WebElement message = driver.findElement(display);
        String Message = message.getText();
        if (!"Your message has been sent".equals(Message)) {
            throw new AssertionError("Unexpected Success message: " + Message);
        }
    }
}
