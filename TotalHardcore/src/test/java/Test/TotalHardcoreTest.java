package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TotalHardcoreTest {
    private CloudGoogleHomePage homePage;
    private SearchResultsPage searchPage;
    private AdditionalActionsPage SomeAdditionalActions;
    private PricingCalculatorPage calculatorPage;
    private TemporaryEmailsPage getTemporaryEmailPage;

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homePage = new CloudGoogleHomePage(driver);
        searchPage = new SearchResultsPage(driver);
        SomeAdditionalActions = new AdditionalActionsPage(driver);
        calculatorPage = new PricingCalculatorPage(driver);
        getTemporaryEmailPage = new TemporaryEmailsPage(driver);

    }

    @Test(description = "perform search for entered text")
    public void PasteAction() {

        homePage
                .openPage()
                .inputText(
                        "Google Cloud Platform Pricing Calculator"
                )
                .clickEnter()
        ;

        searchPage
                .waitLoading()
                .openCalculatorPage()
        ;

        SomeAdditionalActions
                .waitForIframe1Load()
                .switchToiFrame1()
                .waitForIframe2Load()
                .switchToiFrame2()
        ;

        calculatorPage

                .ComputeEngineTab()
                .InstanceNumber("4")
                .SeriesNumber("N1")
                .ActivateMachineTypeTab()
                .MachineType()
                .CheckGPUCheckbox()
                .NumberOfGPU()
                .SelectParticularNumberOfGPU()
                .GPUTypeList()
                .waitForListLoad()
                .SelectParticularGPUType()
                .LocalSSD_List()
                .waitForListLoad()
                .SelectParticularLocalSSD()
                .DatacenterLocation_List()
                .waitForListLoad()
                .SelectParticularDatacenterLocation()
                .CommittedUsage_List()
                .waitForListLoad()
                .SelectParticularCommittedUsage()
                .PerformCalculations()
        ;

        SomeAdditionalActions
                .switchBetweenTabs()
        ;

        getTemporaryEmailPage

                .openNewPage()
                .clickToCopyEmail()
        ;

        SomeAdditionalActions
                .ReturnToBaseTab()
        ;

        calculatorPage
                .ClickToGetPopupForEmail()
                .WaitForFormLoad()
                .ClickToActivateEmailLine()
                .SendEmail()
        ;

        SomeAdditionalActions
                .GoToNewTab()
        ;

        getTemporaryEmailPage
                .ClickToReviewNewEmail()
        ;


        Assert.assertTrue(getTemporaryEmailPage.EmailContainsCorrectAmount().contains("USD 1,082.77"), "Failed: The estimated amount does not match!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

