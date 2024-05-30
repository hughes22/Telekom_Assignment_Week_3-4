package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowsOperations extends Tables {
    private String originalWindowHandle;
    private WebDriverWait wait;

    public WindowsOperations(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By newtab = By.cssSelector("button[onclick=\"newTab()\"]");
    By replacewindow = By.cssSelector("button[onclick=\"newWindowSelf()\"]");
    By window = By.cssSelector("button[onclick=\"newWindow()\"]");
    By dialog = By.xpath("//div[@class='wp-block-media-text__content']");
    By logo = By.cssSelector("a[class=\"logo logo-left with-image   \"]");
    By rest = By.cssSelector("li[id=\"menu-item-22839\"]");
    By subscribe = By.cssSelector("input[type=\"email\"]");
    By clicksubscribe = By.xpath("//button[contains(text(),'Subscribe')]");




    public void NewTab() throws InterruptedException {
        driver.findElement(newtab).click();
        originalWindowHandle = driver.getWindowHandle();
        switchToNewWindow("https://automatenow.io/");
        wait.until(ExpectedConditions.presenceOfElementLocated(logo));
        WebElement Logo = driver.findElement(logo);
        System.out.println(Logo.getText());
        switchBackToOriginalWindow();
    }
    public void ReplaceWindow() throws InterruptedException {
        driver.findElement(replacewindow).click();
        originalWindowHandle = driver.getWindowHandle();
        switchToNewWindow("https://automatenow.io/");
        wait.until(ExpectedConditions.presenceOfElementLocated(rest));
        driver.findElement(rest).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(subscribe));
        WebElement Email = driver.findElement(subscribe);
        Email.sendKeys("www.dr2who@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(clicksubscribe));
        driver.findElement(clicksubscribe).click();
        wait.until(ExpectedConditions.urlToBe("https://automatenow.io/rest-assured-tutorials/"));
        driver.navigate().to("https://practice-automation.com/window-operations/");
    }
    public void NewWindow() throws InterruptedException {
        driver.findElement(window).click();
        originalWindowHandle = driver.getWindowHandle();
        switchToNewWindow("https://automatenow.io/");
        wait.until(ExpectedConditions.urlContains("https://automatenow.io/"));
    }

    private void switchToNewWindow(String url) throws InterruptedException {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    private void switchBackToOriginalWindow() throws InterruptedException {
        driver.switchTo().window(originalWindowHandle);
    }
}
