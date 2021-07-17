package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GloappsRegistrationTest {
    private WebDriver driver;
    private GloappsRegistrationPage registrationPage;

    @Test
    public void shouldRegisterUser() {
        // go to registration form
        registrationPage.fillForm("ola@makota.pl");
        // submit
        // assert account created
    }

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qloapps.coderslab.pl/en/login?back=my-account");
        registrationPage = new GloappsRegistrationPage(driver);
    }

    @After
    public void afterEach() {
        driver.close();
    }
}
