package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowsOperations extends Tables {
    private String originalWindowHandle;

    public WindowsOperations(WebDriver driver) {
        super(driver);
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
        Thread.sleep(2000);
        originalWindowHandle = driver.getWindowHandle();
        switchToNewWindow("https://automatenow.io/");
        driver.findElement(dialog).isDisplayed();
        Thread.sleep(2000);
        WebElement Logo = driver.findElement(logo);
        System.out.println(Logo.getText());
        Thread.sleep(1000);
        switchBackToOriginalWindow();
        Thread.sleep(2000);
    }
    public void ReplaceWindow() throws InterruptedException {
        driver.findElement(replacewindow).click();
        Thread.sleep(2000);
        originalWindowHandle = driver.getWindowHandle();
        switchToNewWindow("https://automatenow.io/");
        driver.findElement(dialog).isDisplayed();
        driver.findElement(rest).click();
        Thread.sleep(2000);
        WebElement Email = driver.findElement(subscribe);
        Email.sendKeys("www.dr2who@gmail.com");
        Thread.sleep(2000);
        driver.findElement(clicksubscribe).click();
        Thread.sleep(5000);
        //driver.switchTo().alert().accept();
        //Thread.sleep(2000);
        driver.navigate().to("https://practice-automation.com/window-operations/");
        //switchBackToOriginalWindow();
        Thread.sleep(2000);
    }
    public void NewWindow() throws InterruptedException {
        driver.findElement(window).click();
        Thread.sleep(2000);
        originalWindowHandle = driver.getWindowHandle();
        switchToNewWindow("https://automatenow.io/");
        Thread.sleep(5000);
    }

    private void switchToNewWindow(String url) throws InterruptedException {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.get(url);
    }
    private void switchBackToOriginalWindow() throws InterruptedException {
        driver.switchTo().window(originalWindowHandle);
        Thread.sleep(2000);
    }
}
