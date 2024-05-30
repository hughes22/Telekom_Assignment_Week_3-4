package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.Message;

public class FileUpload extends WindowsOperations {

    public FileUpload(WebDriver driver) {
        super(driver);
    }
    By file = By.cssSelector("input[id=\"file-upload\"]");
    By upload = By.cssSelector("input[id=\"upload-btn\"]");
    By Message = By.cssSelector("div[class=\"wpcf7-response-output\"]");

    public void Browse(String link) throws InterruptedException {
        WebElement Load = driver.findElement(file);
        Load.sendKeys(link);
    }

    public void ClickUpload(){
        driver.findElement(upload).click();
    }
    public void AssertMessage() {
        WebElement message = driver.findElement(Message);
        String output = message.getText();
        System.out.println(output);
        if (!output.equals(output)) {
            throw new AssertionError("Wrong Text" + output);
        }
    }
}
