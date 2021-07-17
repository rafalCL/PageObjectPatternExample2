package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GloappsRegistrationTest {
    private WebDriver driver;
    private GloappsAuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;

    @Test
    public void shouldRegisterUser() {
        // go to registration form
        authenticationPage.fillEmailForCreateAccount("ola2@makota.pl");
        authenticationPage.submitCreateAccount();
        assertTrue(createAccountPage.isPersonalInformationFormDisplayed());
        // assert account created
    }

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://qloapps.coderslab.pl/en/login?back=my-account");
        authenticationPage = new GloappsAuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @After
    public void afterEach() {
//        driver.close();
    }
}
