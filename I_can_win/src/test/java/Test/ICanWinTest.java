package Test;

import Page.NewPastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinTest {

    private NewPastebinPage pastebinPage;

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        pastebinPage = new NewPastebinPage(driver);
    }

    @Test(description = "Performing several operations on a cite")
    public void PasteAction() {

        pastebinPage
                .openPage()
                .EnterYourMessage("Hello from WebDriver")
                .ReviewExpirationList()
                .EnterExposureOption()
                .EnterYourNameOrTitle("helloweb")
                .YouCanCreateNewPaste();

    }

   @AfterMethod(alwaysRun = true)
   public void browserTearDown() {
       driver.quit();
       driver = null;
    }
}
