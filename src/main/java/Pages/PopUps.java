package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUps extends Formfields {
    public PopUps(WebDriver driver) {
        super(driver);
    }
    By popup1 = By.id("alert");
    By popup2 = By.id("prompt");
    By popup3 = By.id("confirm");
    By popMessage = By.xpath("//p[@id='confirmResult']");

    public void AlertPopUp(){
        driver.findElement(popup1).click();
        Alert alert = driver.switchTo().alert();;
        String alertText = alert.getText();
        if (!"Hi there, pal!".equals(alertText)) {
            throw new AssertionError("Unexpected alert text: " + alertText);
        }
        alert.accept();
    }

    public void PromptPopUp(String alert_message){
        driver.findElement(popup2).click();
        Alert Alert = driver.switchTo().alert();
        Alert.sendKeys(alert_message);
        Alert.accept();
    }
    public void ConfirmPopUp() throws InterruptedException {
        driver.findElement(popup3).click();
        driver.switchTo().alert().accept();
    }
    public void verifypopuptext(){
        WebElement text = driver.findElement(popMessage);
        String myText = text.getText();
        if (!"OK it is!".equals(myText)) {
            throw new AssertionError("Unexpected alert text: " + myText);
        }
    }
}



