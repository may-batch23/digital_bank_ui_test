package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckingAccountPage {
    private WebDriver driver;

    public CheckingAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checking-menu")
    private WebElement checkingMenu;

    @FindBy(id = "new-checking-menu-item")
    private WebElement newCheckingButton;

    @FindBy(id = "name")
    private WebElement accountNameTxt;

    @FindBy(id = "openingBalance")
    private WebElement openingBalanceTxtBox;

    @FindBy(id = "newCheckingSubmit")
    private WebElement submitButton;

    // Add more locators as needed

    public void clickCheckingMenu() {
        checkingMenu.click();
    }

    public void clickNewCheckingButton() {
        newCheckingButton.click();
    }

    public void enterAccountName(String accountName) {
        accountNameTxt.sendKeys(accountName);
    }

    public void enterOpeningBalance(double openingBalance) {
        openingBalanceTxtBox.sendKeys(String.valueOf(openingBalance));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
