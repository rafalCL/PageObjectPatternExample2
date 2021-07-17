package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.WebDriver;

// this is our class implementing a page object pattern
public class GloappsRegistrationPage {
    private final WebDriver driver;

    public GloappsRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm() {
        System.out.println("filling form");
    }
}
