package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class WithdrawFeatureSteps {
    WebDriver driver = new FirefoxDriver();
    private LoginPage loginPage = new LoginPage(driver);
    @Given("the user enters with {string} and password {string}")
    public void the_user_enters_with_and_password(String username, String password) {
        driver.get("http://Alimbek.mydevx.com/bank/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.login(username, password);
    }
    @When("the user withdraws {string} dollars from the checking account")
    public void the_user_withdraws_dollars_from_the_checking_account(String string) {
        WebElement withdrawMenu = driver.findElement(By.xpath("//a[@id=\"withdraw-menu-item\"]"));
        withdrawMenu.click();
        WebElement selectAccount = driver.findElement(By.id("selectedAccount"));
        Select accountSelect = new Select(selectAccount);
        accountSelect.selectByVisibleText("Temp (Standard Checking)");
        WebElement amountInput = driver.findElement(By.xpath("//input[@name=\"amount\"]"));
        amountInput.sendKeys(string);
        WebElement submitButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();
        submitButton.click();
    }
    @Then("the difference in money should be equal to the amount withdrawn {string}")
    public void the_difference_in_money_should_be_equal_to_the_amount_withdrawn(String amount) {

    }
}
