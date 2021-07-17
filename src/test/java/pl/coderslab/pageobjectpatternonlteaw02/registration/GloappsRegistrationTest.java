package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Month;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GloappsRegistrationTest {
    private WebDriver driver;
    private GloappsAuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;
    private GloappsMyAccountPage myAccountPage;

    @Test
    public void shouldRegisterUser() {
        final String randomEmail = UUID.randomUUID()+"@mail.pl";
        authenticationPage.fillEmailForCreateAccount(randomEmail);
        authenticationPage.submitCreateAccount();
        assertTrue(createAccountPage.isPersonalInformationFormDisplayed());
        assertTrue(createAccountPage.isEmailPopulatedWith(randomEmail));
        PersonalInformationFormData formData = new PersonalInformationFormData()
                .setMr(true)
                .setFirstName("ala")
                .setLastName("novakovsky")
                .setPassword("ala123")
                .setDays(12)
                .setMonths(Month.SEPTEMBER)
                .setYears(2000)
                .setNewsletter(true)
                .setSpecialOffers(false);
        createAccountPage.fillPersonalInformation(formData);
        createAccountPage.submit();
        assertTrue(myAccountPage.isRegistrationSuccess());
    }

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://qloapps.coderslab.pl/en/login?back=my-account");
        authenticationPage = new GloappsAuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new GloappsMyAccountPage(driver);
    }

    @After
    public void afterEach() {
//        driver.close();
    }
}
