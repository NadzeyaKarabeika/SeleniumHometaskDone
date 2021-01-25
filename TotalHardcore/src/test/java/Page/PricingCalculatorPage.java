package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage {

    private WebDriver driver;

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

    @FindBy(id = "email_quote")
    private WebElement EmailEstimateButton;

    @FindBy(xpath = "//form[@name='emailForm']")
    private WebElement WaitForFormLoad;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement ActivateEmailLine;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement SendEmailWithEstimates;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage ComputeEngineTab() {
        ActivateComputeEngine.click();
        return this;
    }

    public PricingCalculatorPage InstanceNumber(String text) {
        EnterQuantity.sendKeys(text);
        return this;
    }

    public PricingCalculatorPage SeriesNumber(String text) {
        EnterSeries.sendKeys(text);
        return this;
    }

    public PricingCalculatorPage ActivateMachineTypeTab() {
        MachineTypeTab.click();
        return this;
    }


    public PricingCalculatorPage MachineType() {
        EnterMachineType.click();
        return this;
    }

    public PricingCalculatorPage CheckGPUCheckbox() {
        GPUCheckbox.click();
        return this;
    }

    public PricingCalculatorPage NumberOfGPU() {
        NumberOfGPUList.click();
        return this;
    }

    public PricingCalculatorPage SelectParticularNumberOfGPU() {
        ParticularNumberOfGPU.click();
        return this;
    }

    public PricingCalculatorPage GPUTypeList() {
        GPUType.click();
        return this;
    }

    public PricingCalculatorPage SelectParticularGPUType() {

        ParticularTypeOfGPU.click();
        return this;
    }

    public PricingCalculatorPage LocalSSD_List() {
        LocalSSD.click();
        return this;
    }

    public PricingCalculatorPage waitForListLoad() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']")));
        return this;
    }

    public PricingCalculatorPage SelectParticularLocalSSD() {
        ParticularLocalSSD.click();
        return this;
    }

    public PricingCalculatorPage DatacenterLocation_List() {
        DatacenterLocation.click();
        return this;
    }

    public PricingCalculatorPage SelectParticularDatacenterLocation() {
        ParticularDatacenterLocation.click();
        return this;
    }

    public PricingCalculatorPage CommittedUsage_List() {
        CommittedUsage.click();
        return this;
    }

    public PricingCalculatorPage SelectParticularCommittedUsage() {
        ParticularCommittedUsage.click();
        return this;
    }

    public PricingCalculatorPage PerformCalculations() {
        CalculationButton.click();
        return this;
    }

    public PricingCalculatorPage ClickToGetPopupForEmail() {
        EmailEstimateButton.click();
        return this;
    }

    public PricingCalculatorPage WaitForFormLoad() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='emailForm']")));
        return this;
    }

    public PricingCalculatorPage ClickToActivateEmailLine() {
       ActivateEmailLine.click();
       ActivateEmailLine.sendKeys(Keys.chord(Keys.CONTROL, "v"));
       return this;
    }

    public PricingCalculatorPage SendEmail() {
        SendEmailWithEstimates.click();
        return this;
    }

}
