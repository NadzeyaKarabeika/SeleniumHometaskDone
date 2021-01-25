package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class AdditionalActionsPage {
    private WebDriver driver;

    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement iFrame1;

    @FindBy(id = "myFrame")
    private WebElement iFrame2;


    public AdditionalActionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdditionalActionsPage waitForIframe1Load() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//devsite-iframe/iframe")));
        return this;
    }

    public AdditionalActionsPage switchToiFrame1() {
        driver.switchTo().frame(iFrame1);
        return this;
    }

    public AdditionalActionsPage waitForIframe2Load() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("myFrame")));
        return this;
    }

    public String getiFrame2url() {
        String iframe2url = driver.findElement(By.id("myFrame")).getAttribute("src");
        return iframe2url;
    }

    public AdditionalActionsPage switchToiFrame2() {
        driver.get(getiFrame2url());
        return this;
    }

    public AdditionalActionsPage switchBetweenTabs() {

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;

    }

    public AdditionalActionsPage ReturnToBaseTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    public AdditionalActionsPage GoToNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

}

