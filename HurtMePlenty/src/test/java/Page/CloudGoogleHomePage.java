package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


public class CloudGoogleHomePage {

    private WebDriver driver;
    private String CLOUD_GOOGLE_HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement SearchInput;

    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(CLOUD_GOOGLE_HOME_PAGE_URL);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        return this;
    }

    public CloudGoogleHomePage inputText(String text) {
        SearchInput.sendKeys(text);
        return this;
    }

    public CloudGoogleHomePage clickEnter() {
        SearchInput.sendKeys(Keys.ENTER);
        return this;
    }
}
