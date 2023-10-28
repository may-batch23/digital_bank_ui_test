package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginToBank;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class NewCheckingAccountSteps {

    WebDriver driver = Driver.getDriver();
    private LoginToBank loginToBank = new LoginToBank(driver);

    @BeforeAll
    public static void setup() {

        WebDriverManager.firefoxdriver().setup();
    }

    @Given("user is on {string}")
    public void user_is_on(String string) {

        driver.manage().window().maximize();
        driver.get("https://dbank-qa.wedevx.co/bank/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }
    @When("the user enters login {string} and password {string}")
    public void the_user_enters_login_and_password(String username, String password) throws InterruptedException {

        loginToBank.login(username, password);

    }
    @Then("the user clicks on {string} and chooses {string} account")
    public void the_user_clicks_on_and_chooses_account(String string, String string2) throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkingBtn = driver.findElement(By.id("checking-menu"));
        checkingBtn.click();

        //user clicks on new checking account
        Thread.sleep(2000);
        WebElement newChecking = driver.findElement(By.id("new-checking-menu-item"));
        newChecking.click();
        Assertions.assertEquals("https://dbank-qa.wedevx.co/bank/account/checking-add", driver.getCurrentUrl(), "User was not redirected");

    }
    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String string) throws InterruptedException {

        Thread.sleep(2000);
        WebElement submitBtn = driver.findElement(By.id("newCheckingSubmit"));
        submitBtn.click();

    }
    @Then("the user should get an error message {string}")
    public void the_user_should_get_an_error_message(String errorMessage) {

        String actualMessage = driver.switchTo().activeElement().getAttribute("validationMessage");
        System.out.println(errorMessage);
        Assertions.assertEquals(actualMessage, errorMessage, "Message is not valid");

    }

}
