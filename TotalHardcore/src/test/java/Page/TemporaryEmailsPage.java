package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TemporaryEmailsPage {

    private WebDriver driver;
    private String TEMPORARY_EMAILS_PAGE_URL = "https://10minutemail.com";

    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement CopyEmailAddress;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement ReviewNewEmail;

    @FindBy(xpath = "//table[@class='quote']")
    private WebElement NewEmailText;

    public TemporaryEmailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TemporaryEmailsPage openNewPage() {
        driver.get(TEMPORARY_EMAILS_PAGE_URL);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='copy_address']")));
        return this;
    }

    public TemporaryEmailsPage clickToCopyEmail() {
        Actions actions = new Actions(driver);
        actions.doubleClick(CopyEmailAddress).perform();
        CopyEmailAddress.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        return this;
    }

    public TemporaryEmailsPage ClickToReviewNewEmail () {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message_top']")));
        ReviewNewEmail.click();
        return this;
    }

    public String EmailContainsCorrectAmount () {
        String NewEmailText = driver.findElement(By.xpath("//table[@class='quote']")).getText();
        return NewEmailText;
    }

}
