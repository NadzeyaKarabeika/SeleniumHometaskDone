package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']/div/a[@class='gs-title'][contains(.,'Google Cloud Platform Pricing Calculator')]")
    private WebElement ParticularResult;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage waitLoading() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='gsc-results gsc-webResult']")));
        return this;
    }

    public SearchResultsPage openCalculatorPage() {
        ParticularResult.click();
        return this;
    }
}
