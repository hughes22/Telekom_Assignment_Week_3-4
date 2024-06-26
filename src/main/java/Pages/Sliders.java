package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Sliders extends FileDownload{
    public Sliders(WebDriver driver) {
        super(driver);
    }
    By slider = By.cssSelector("input[id=\"slideMe\"]");
    By value = By.xpath("//span[@id='value']");

    public void SlideMe() {
        WebElement greenslider = driver.findElement(slider);
        Actions actions = new Actions(driver);
        int sliderWidth = greenslider.getSize().width;
        Random random = new Random();
        int randomPosition = random.nextInt(101);
        int offset = (int) ((randomPosition / 100.0) * sliderWidth);
        actions.clickAndHold(greenslider)
        .moveByOffset(offset - (sliderWidth / 2), 0).release().perform();
    }

    public void CurrentValue(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement count = wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        String Point = count.getText();
        System.out.println(Point);
        if(!Point.equals(Point)){
            throw new AssertionError("Wrong Count" + Point);
        }
    }
}
