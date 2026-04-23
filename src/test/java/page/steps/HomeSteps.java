package page.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeSteps {


    public static WebDriver driver;
    public HomeSteps() {
        driver = Hooks.driver;
    }
    @Given("User launch the Chrome browser")
    public void user_launch_the_chrome_browser() {
       System.out.println("Browser is launched");
    }
    @When("I enter the url {string}")
    public void i_enter_the_url(String url) {
      driver.get(url);
    }
    @Then("I should be able to access the homepage")
    public void i_should_be_able_to_access_the_homepage() {
       String PageTitle = driver.getTitle();
        System.out.println(PageTitle);
        String Name = null;
        System.out.println(Name.length());
    }
}
