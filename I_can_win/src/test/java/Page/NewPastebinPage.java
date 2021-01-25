package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewPastebinPage {

    private WebDriver driver;
    private String PASTEBIN_HOME_PAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement TextBoxToEnterMessage;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement ExpirationDropdownList;

    @FindBy(xpath = "//li[@class = 'select2-results__option'][contains(., '10 Minutes')]")
    private WebElement ExposureOption;

    @FindBy(id = "postform-name")
    private WebElement PasteNameOrTitle;

    @FindBy(xpath = "//button[@class='btn -big'][text()='Create New Paste']")
    private WebElement ClickToCreateNewPaste;

    @FindBy(xpath = "//*[@class='top-footer']")
    private WebElement footer;


    public NewPastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewPastebinPage openPage() {
        driver.get(PASTEBIN_HOME_PAGE_URL);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        driver.manage().window().maximize();
        return this;
    }

    public NewPastebinPage EnterYourMessage(String text) {
        TextBoxToEnterMessage.sendKeys(text);
        return this;
    }

    public NewPastebinPage ReviewExpirationList() {
        ExpirationDropdownList.click();
        return this;
    }

    public NewPastebinPage EnterExposureOption() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class = 'select2-results__option']")));
        ExposureOption.click();
        return this;
    }

    public NewPastebinPage EnterYourNameOrTitle(String text) {
        PasteNameOrTitle.sendKeys(text);
        return this;
    }

    public NewPastebinPage YouCanCreateNewPaste() {
        ClickToCreateNewPaste.click();
        return this;
    }
}
