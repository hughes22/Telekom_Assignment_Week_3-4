package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Tables extends Modals{
    public Tables(WebDriver driver) {
        super(driver);
    }
    By Oranges = By.xpath("//td[contains(text(),'$3.99')]");
    By Marbles = By.xpath(("//td[contains(text(),'$1.25')]"));
    By Option = By.cssSelector("select[name=\"tablepress-1_length\"]");
    By searchbox = By.cssSelector("div[id=\"tablepress-1_filter\"] input[type=\"search\"]");
    By tableRecord = By.cssSelector("table[id=\"tablepress-1\"] tr[class=\"row-11 even\"]");


    public void simpleTable1() throws InterruptedException {
        WebElement oranges = driver.findElement(Oranges);
        String Item =oranges.getText();
        if (!"$3.99".equals(Item)) {
            throw new AssertionError("Unexpected price message: " + Item);
        }

        Thread.sleep(5000);

        WebElement marbles = driver.findElement(Marbles);
        String item = marbles.getText();
        if (!"$1.25".equals(item)) {
            throw new AssertionError("Unexpected price message: " + item);
        }
    }
    public void sortableTable(){
        WebElement mySelectElement = driver.findElement(Option);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue("100");
    }

    public void Search() {
        driver.findElement(searchbox).sendKeys("Mex");
    }
    public void VerifyRecord(){
        WebElement record = driver.findElement(tableRecord);
        //String entries = "10\tMexico\t128.5";
        String RecordRole = record.getText();
        if (!"10 Mexico 128.5".equals(RecordRole)) {
            throw new AssertionError("Unexpected price message: " + RecordRole);
        }
    }
}
