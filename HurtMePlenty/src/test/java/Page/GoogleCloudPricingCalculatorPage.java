package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement iFrame1;

    @FindBy(id = "myFrame")
    private WebElement iFrame2;

    @FindBy(xpath = "//*[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']")
    private WebElement ActivateComputeEngine;

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement EnterQuantity;

    @FindBy(xpath = "//md-select[@name = 'series']")
    private WebElement EnterSeries;

    @FindBy(id = "select_90")
    private WebElement MachineTypeTab;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div")
    private WebElement EnterMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement GPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement NumberOfGPUList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(.,'2')]")
    private WebElement ParticularNumberOfGPU;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUType;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(.,'NVIDIA Tesla P100')]")
    private WebElement ParticularTypeOfGPU;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement LocalSSD;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(.,'2x375 GB')]")
    private WebElement ParticularLocalSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement DatacenterLocation;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(.,'Frankfurt (europe-west3)')]")
    private WebElement ParticularDatacenterLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement CommittedUsage;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(.,'1 Year')]")
    private WebElement ParticularCommittedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement CalculationButton;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(., 'VM class: regular')]")
    private WebElement MachineClassMatch;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(., 'Instance type: n1-standard-8']")
    private WebElement InstanceTypeMatch;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(., 'Region: Frankfurt')]")
    private WebElement RegionTypeMatch;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(., '2x375 GiB')]")
    private WebElement LocalSSDMatch;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(., '1 Year')]")
    private WebElement CommittedUsageMatch;

    @FindBy(xpath = "//div[@class='md-list-item-text']/b[contains(., 'USD 1,082.77')]")
    private WebElement EstimatedCostManualResultMatch;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage waitForIframe1Load() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//devsite-iframe/iframe")));
        return this;
    }

    public GoogleCloudPricingCalculatorPage switchToiFrame1() {
        driver.switchTo().frame(iFrame1);
        return this;
    }

    public GoogleCloudPricingCalculatorPage waitForIframe2Load() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("myFrame")));
        return this;
    }

    public String getiFrame2url() {
        String iframe2url = driver.findElement(By.id("myFrame")).getAttribute("src");
        return iframe2url;
    }

    public GoogleCloudPricingCalculatorPage switchToiFrame2() {
        driver.get(getiFrame2url());
        return this;
    }

    public GoogleCloudPricingCalculatorPage ComputeEngineTab() {
        ActivateComputeEngine.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage InstanceNumber(String text) {
        EnterQuantity.sendKeys(text);
        return this;
    }

    public GoogleCloudPricingCalculatorPage SeriesNumber(String text) {
        EnterSeries.sendKeys(text);
        return this;
    }

    public GoogleCloudPricingCalculatorPage ActivateMachineTypeTab() {
        MachineTypeTab.click();
        return this;
    }


    public GoogleCloudPricingCalculatorPage MachineType() {
        EnterMachineType.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage CheckGPUCheckbox() {
        GPUCheckbox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage NumberOfGPU() {
        NumberOfGPUList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage SelectParticularNumberOfGPU() {
        ParticularNumberOfGPU.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage GPUTypeList() {
        GPUType.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage SelectParticularGPUType() {

        ParticularTypeOfGPU.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage LocalSSD_List() {
        LocalSSD.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage waitForListLoad() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']")));
        return this;
    }

    public GoogleCloudPricingCalculatorPage SelectParticularLocalSSD() {
        ParticularLocalSSD.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage DatacenterLocation_List() {
        DatacenterLocation.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage SelectParticularDatacenterLocation() {
        ParticularDatacenterLocation.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage CommittedUsage_List() {
        CommittedUsage.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage SelectParticularCommittedUsage() {
        ParticularCommittedUsage.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage PerformCalculations() {
        CalculationButton.click();
        return this;
    }

    public String checkMachineClassMatchesRegular() {
        String MachineClassMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., 'VM class: regular')]")).getText();
        return MachineClassMatch;
    }

    public String checkInstanceTypeMatches() {
        String InstanceTypeMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., 'Instance type: n1-standard-8')]")).getText();
        return InstanceTypeMatch;
    }

    public String checkRegionMatchesFrankfurt () {
        String RegionTypeMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., 'Region: Frankfurt')]")).getText();
        return RegionTypeMatch;
    }

    public String checkLocalSSDMatches () {
        String LocalSSDMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., '2x375 GiB')]")).getText();
        return LocalSSDMatch;
    }

    public String checkCommittedUsageMatches () {
        String CommittedUsageMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., '1 Year')]")).getText();
        return CommittedUsageMatch;
    }
    public String checkEstimatedCostManualResultMatches () {
        String EstimatedCostManualResultMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text']/b[contains(., 'USD 1,082.77')]")).getText();
        return EstimatedCostManualResultMatch;
    }

  }
