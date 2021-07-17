package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this is our class implementing a page object pattern
public class GloappsRegistrationPage {
    private final WebDriver driver;

    public GloappsRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("#email_create"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }
}
