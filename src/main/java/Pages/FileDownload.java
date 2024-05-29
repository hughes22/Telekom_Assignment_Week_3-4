package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class FileDownload extends FileUpload{
    public FileDownload(WebDriver driver) {
        super(driver);
        initializeChromeOptions();
    }
    private void initializeChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePref = new HashMap<>();
        String downloadFilepath = "C:\\Downloads\\file-download";
        chromePref.put("profile.default_content_settings.popups", 0);
        chromePref.put("download.prompt_for_download", false);
        chromePref.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePref);
    }
    By download1 = By.xpath("//a[contains(@class,'wpdm-download-link download-on-click btn btn-primary')]");
    By download2 = By.xpath("//a[@class='wpdm-download-link wpdm-download-locked btn btn-primary ']");
    By keys = By.id("password_6653e6a71a66d_921");
    By button = By.cssSelector("input[id=\'wpdm_submit_6653e4fa67efc_921\']");
    By Iframeview = By.cssSelector("iframe[id=\"wpdm-lock-frame\"]");
    By Password = By.xpath("//input[@id='password_6656080f228d8_921']");

    public void Downloadpdf(){

        driver.findElement(download1).click();
    }
    public void Downloaddocx() throws InterruptedException {
        driver.findElement(download2).click();
        Thread.sleep(5000);
    }
    public void verifyfromalert() throws InterruptedException {
        WebElement elements = driver.findElement(keys);
        elements.click();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(Iframeview));
        WebElement password = driver.findElement(Password);
        password.sendKeys("automateNow");
        Thread.sleep(5000);
        driver.findElement(button).click();
        driver.switchTo().defaultContent();
    }




}
