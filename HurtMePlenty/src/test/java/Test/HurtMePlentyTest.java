package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

    private CloudGoogleHomePage homePage;
    private SearchResultsPage searchPage;
    private GoogleCloudPricingCalculatorPage calculatorPage;

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homePage = new CloudGoogleHomePage(driver);
        searchPage = new SearchResultsPage(driver);
        calculatorPage = new GoogleCloudPricingCalculatorPage(driver);

    }

    @Test(description = "perform search for entered text")
    public void PasteAction() {
        homePage
                .openPage()
                .inputText(
                        "Google Cloud Platform Pricing Calculator"
                )
                .clickEnter();

        searchPage
                .waitLoading()
                .openCalculatorPage()
        ;

        calculatorPage
                .waitForIframe1Load()
                .switchToiFrame1()
                .waitForIframe2Load()
                .switchToiFrame2()
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


        Assert.assertTrue(calculatorPage.checkMachineClassMatchesRegular().contains("regular"), "Failed: VM class doesn't match!");
        Assert.assertTrue(calculatorPage.checkInstanceTypeMatches().contains("n1-standard-8"), "Failed: Instance type doesn't match!");
        Assert.assertTrue(calculatorPage.checkRegionMatchesFrankfurt().contains("Frankfurt"), "Failed: Region doesn't match!");
        Assert.assertTrue(calculatorPage.checkLocalSSDMatches().contains("2x375 GiB"), "Failed: Local SSD doesn't match!");
        Assert.assertTrue(calculatorPage.checkCommittedUsageMatches().contains("1 Year"), "Failed: Commitment term doesn't match!");
        Assert.assertTrue(calculatorPage.checkEstimatedCostManualResultMatches().contains("1,082.77"), "Failed: Estimated Cost doesn't match!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}


