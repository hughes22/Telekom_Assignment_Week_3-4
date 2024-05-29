package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Formfields {
    WebDriver driver;
    public  Formfields(WebDriver driver){
        this.driver = driver;
    }
    By Name = By.id("name");
    By Drink = By.id("drink1");
    By Color = By.id("color2");
    By Siblings = By.id("siblings");
    By Animals = By.xpath("//li[contains(text(),'Eagle')]");
    By Email = By.id("email");
    By Message = By.id("message");
    By Submit = By.id("submit-btn");

    public void enterFirstName(String firstname) {
        WebElement firstNameInput = driver.findElement(Name);
        firstNameInput.sendKeys(firstname);
    }
    public void selectFavoritedrink(){
        driver.findElement(Drink).click();
    }
    public void selectFavoriteColor(){
        driver.findElement(Color).click();
    }
    public  void selectAnySiblings(){
        Select dropdown = new Select(driver.findElement(Siblings));
        dropdown.selectByVisibleText("Yes");
    }

    public void selectFastAnimals(){
         WebElement element = driver.findElement(Animals);
         System.out.println(element.getText());
    }
    public void enterEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void enterMessage(String message){
        driver.findElement(Message).sendKeys(message);
    }
    public void clickSubmit(){
        driver.findElement(Submit).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
