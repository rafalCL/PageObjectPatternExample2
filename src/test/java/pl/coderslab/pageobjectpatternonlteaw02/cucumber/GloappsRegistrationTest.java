package pl.coderslab.pageobjectpatternonlteaw02.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/gloapps-create-account.feature", plugin = {"pretty", "html:out"})
public class GloappsRegistrationTest {

}
