package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class PasteOnHomePage  {

        private WebDriver driver;

        private String PASTEON_HOMEPAGE_URL = "https://pastebin.com/";

        @FindBy(id = "postform-text")
        private WebElement newPaste;

        @FindBy(id = "select2-postform-format-container")
        private WebElement selectSyntaxHighlighting;

        @FindBy(xpath = "//li[@class='select2-results__option'][text()='Bash']")
        private WebElement optionBash;

        @FindBy(id = "select2-postform-expiration-container")
        private WebElement selectPasteExpiration;

        @FindBy(xpath = "//li[@class='select2-results__option'][text()='10 Minutes']")
        private WebElement optionPublic;

        @FindBy(id = "postform-name")
        private WebElement pasteName;

        @FindBy(xpath = "//*[@class='top-footer']")
        private WebElement footer;

        @FindBy(xpath = "//button[@class='btn -big'][text()='Create New Paste']")
        private WebElement submitButton;

        public PasteOnHomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public PasteOnHomePage maximizeWindow() {
            driver.manage().window().maximize();
            return this;
        }

        public PasteOnHomePage openPage() {
            driver.get(PASTEON_HOMEPAGE_URL);
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
            return this;
        }

        public PasteOnHomePage inputText(String text) {
            newPaste.sendKeys(text);
            return this;
        }

        public PasteOnHomePage openSyntaxHighlightingSelect() {
            selectSyntaxHighlighting.click();
            return this;
        }

        public PasteOnHomePage selectSyntaxHighlighting() {
            optionBash.click();
            return this;
        }

        public PasteOnHomePage openExpirationSelect() {
            selectPasteExpiration.click();
            return this;
        }

        public PasteOnHomePage selectExpiration() {
            optionPublic.click();
            return this;
        }

        public PasteOnHomePage inputName(String text) {
            pasteName.sendKeys(text);
            return this;
        }

        public PasteOnHomePage scrollDown() {
            Actions actions = new Actions(driver);
            actions.moveToElement(footer);
            actions.perform();
            return this;
        }

        public PasteOnHomePage submit() {
            submitButton.click();
            return this;
        }
    }
