package steps;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.SuccessfulAccountInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CheckingAccountPage;
import pages.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessfulAccountSteps {

   WebDriver driver = new FirefoxDriver();
    private LoginPage loginPage = new LoginPage(driver);

    private CheckingAccountPage checkingAccountPage;

    @BeforeAll
    public static void setup() {

        WebDriverManager.firefoxdriver().setup();

    }

    @Given("the user is on the dbank homepage {string}")
    public void the_user_is_on_the_dbank_homepage(String homePageLink) {
       driver.get(homePageLink);
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Given("the user logged in as {string} {string}")
    public void the_user_logged_in_as(String username, String password) {
        loginPage.login(username, password);
    }
    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<SuccessfulAccountInfo> successfulAccountInfoList) {

        SuccessfulAccountInfo testDataForOneCheckingAccount = successfulAccountInfoList.get(0);

        checkingAccountPage = new CheckingAccountPage(driver);

        checkingAccountPage.clickCheckingMenu();

        //the user clicks on the new checking button
        checkingAccountPage.clickNewCheckingButton();

        String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";

        assertEquals(expectedUrl, driver.getCurrentUrl(), "new checking button did not take to the " + expectedUrl);

        //the user selects account type
        WebElement accountTypeRadioButton =  driver.findElement(By.id(testDataForOneCheckingAccount.getCheckingAccountType()));
        accountTypeRadioButton.click();

        //the user select ownership
        WebElement ownershipTypeRadioButton =  driver.findElement(By.id(testDataForOneCheckingAccount.getAccountOwnership()));
        ownershipTypeRadioButton.click();


        //the user gives a name to the account
        checkingAccountPage.enterAccountName(testDataForOneCheckingAccount.getAccountName());

        //user makes the initial deposit
        checkingAccountPage.enterOpeningBalance(testDataForOneCheckingAccount.getInitialDepositAmount());

        //the user clicks on the submit button
        checkingAccountPage.clickSubmitButton();

    }
    @Then("the user should see the green {string} message")
    public void the_user_should_see_the_green_message(String expectedConfMessage) {

        WebElement newAccountConfAlertDiv = driver.findElement(By.id("new-account-conf-alert"));
        expectedConfMessage = "Confirmation " + expectedConfMessage + "\n×";

        assertEquals(expectedConfMessage, newAccountConfAlertDiv.getText());

    }



}
