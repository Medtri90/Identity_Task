package steps;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.CarValuationPage;

public class CarValuationSteps {

    CarValuationPage carValuationPage = new CarValuationPage(DriverFactory.getDriver());

    @Given("user navigates to the car valuation website")
    public void navigateToCarValuationWebsite() {
        DriverFactory.getDriver().get("https://motorway.co.uk/");
        String currentUrl = carValuationPage.getUrl();
        Assert.assertThat(currentUrl, Matchers.startsWith("https://motorway"));
    }

    @When("user enters the registration number {string}")
    public void enterRegistrationNumber(String registrationNumber) throws InterruptedException {
        carValuationPage.enterRegistrationNumber(registrationNumber);
    }

    @And("user clicks on value your car")
    public void userClicksOnValueYourCar() {
        carValuationPage.clickSearchButton();
    }

    @Then("the car details should match {string} and {string}")
    public void verifyCarDetails(String expectedMakeModel, String expectedYear) {
        String actualCarModelValue = carValuationPage.getCarModel();
        Assert.assertThat(actualCarModelValue, Matchers.equalTo(expectedMakeModel));
        String actualCarYear = carValuationPage.getCarYear();
        Assert.assertThat(actualCarYear, Matchers.equalTo(expectedYear));
    }
}
