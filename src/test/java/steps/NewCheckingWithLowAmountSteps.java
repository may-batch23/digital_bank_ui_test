package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.NewCheckingAccountInfo;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.NewCheckingPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewCheckingWithLowAmountSteps {
    WebDriver driver = new SafariDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private NewCheckingPage newCheckingPage = new NewCheckingPage(driver);

    @Given("the user is on the {string} and logged in as {string} with a password {string}")
    public void the_user_is_on_the_and_logged_in_as_with_a_password(String url, String email, String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        loginPage.login(email, password);
    }

    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<NewCheckingAccountInfo> checkingAccountInfoList) {
       newCheckingPage.createNewChecking(checkingAccountInfoList);
    }

    @Then("you should see an error message {string}")
    public void you_should_see_an_error_message(String message) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("new-account-error-msg")));
        Assertions.assertEquals(message, errorMessage.getText(), "error message mismatch");
    }

    @After
    public void shutDownTheDriver(){
        driver.quit();
    }

}
