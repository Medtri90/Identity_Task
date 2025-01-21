package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarValuationPage {
    WebDriver driver;

    private By registrationInputField = By.xpath("//input[@id='vrm-input']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By carModel = By.xpath("//h1[@data-cy='vehicleMakeAndModel']");
    private By carYear = By.xpath("//ul[@class='HeroVehicle__details-XpAI']/li[1]");

    public CarValuationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void enterRegistrationNumber(String registrationNumber) {
        driver.findElement(registrationInputField).sendKeys(registrationNumber);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getCarModel() {
        return driver.findElement(carModel).getText();
    }

    public String getCarYear() {
        return driver.findElement(carYear).getText();
    }
}
