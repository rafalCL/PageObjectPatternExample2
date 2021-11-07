package pl.coderslab.pageobjectpatternonlteaw02.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pageobjectpatternonlteaw02.registration.GloappsAuthenticationPage;
import pl.coderslab.pageobjectpatternonlteaw02.registration.GloappsCreateAccountPage;
import pl.coderslab.pageobjectpatternonlteaw02.registration.GloappsMyAccountPage;
import pl.coderslab.pageobjectpatternonlteaw02.registration.PersonalInformationFormData;

import java.time.Month;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GloappsRegistrationSteps {
    private WebDriver driver;
    private GloappsAuthenticationPage authenticationPage;
    private GloappsCreateAccountPage createAccountPage;
    private GloappsMyAccountPage myAccountPage;
    private String randomEmail;

    @Given("^Opened webpage: (.*)$")
    public void beforeEach(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(url);
        authenticationPage = new GloappsAuthenticationPage(driver);
        createAccountPage = new GloappsCreateAccountPage(driver);
        myAccountPage = new GloappsMyAccountPage(driver);
    }

    @When("Valid email provided in \"create account email\" input box")
    public void validEmailProvided() {
        randomEmail = UUID.randomUUID()+"@mail.pl";
        authenticationPage.fillEmailForCreateAccount(randomEmail);
    }

    @And("Click \"Create an account\" button")
    public void d(){
        authenticationPage.submitCreateAccount();
    }

    @And("Is Personal Information form displayed")
    public void isFormDisplayed() {
        assertTrue(createAccountPage.isPersonalInformationFormDisplayed());
    }

    @And("Is email input populated with previous email")
    public void emailPopulated() {
        assertTrue(createAccountPage.isEmailPopulatedWith(randomEmail));
    }

    @And("Fill valid user data")
    public void fillValidUserData() {
        PersonalInformationFormData formData = new PersonalInformationFormData()
                .setMr(false)
                .setFirstName("ala")
                .setLastName("novakovsky")
                .setPassword("ala123")
                .setDays(12)
                .setMonths(Month.SEPTEMBER)
                .setYears(2000)
                .setNewsletter(true)
                .setSpecialOffers(false);
        createAccountPage.fillPersonalInformation(formData);
    }

    @And("Click \"Register\" button")
    public void clickRegister() {
        createAccountPage.clickRegister();
    }

    @Then("Confirmed registration success")
    public void confirmedSuccess() {
        assertTrue(myAccountPage.isRegistrationSuccess());
    }

    @And("Browser quit")
    public void browserQuit() {
        driver.close();
    }
}
