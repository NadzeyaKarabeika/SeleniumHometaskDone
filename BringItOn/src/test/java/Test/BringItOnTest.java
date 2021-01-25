package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.*;

public class BringItOnTest {

    private PasteOnHomePage homepage;
    private VerificationOnCreatedPage created_page;

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homepage = new PasteOnHomePage(driver);
        created_page = new VerificationOnCreatedPage(driver);
    }

    @Test(description = "to test code entered is matching the code in New Paste created")
    public void PasteAction() {

        homepage
                .maximizeWindow()
                .openPage()
                .inputText(
                        "git config --global user.name  \"New Sheriff in Town\"\n" +
                                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                "git push origin master --force"
                )
                .openSyntaxHighlightingSelect()
                .selectSyntaxHighlighting()
                .openExpirationSelect()
                .selectExpiration()
                .inputName("how to gain dominance among developers")
                .scrollDown()
                .submit()
        ;

        created_page
                .waitLoading()
        ;

        Assert.assertEquals("how to gain dominance among developers - Pastebin.com", created_page.getPageTitle());
        Assert.assertTrue(created_page.textHighlightedSize() > 0, "Failed: Text Highlighted not for a bash!");
        Assert.assertTrue(created_page.codeContains("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force"),"Failed: Text not found!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}

