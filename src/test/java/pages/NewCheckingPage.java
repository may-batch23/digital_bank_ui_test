package pages;

import models.NewCheckingAccountInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewCheckingPage {
    private WebDriver driver;
    public NewCheckingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "checking-menu")
    private WebElement checkingBtn;

    @FindBy(id = "new-checking-menu-item")
    private WebElement newCheckingBtn;

    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingRadioBtn;

    @FindBy(id = "Individual")
    private WebElement individualRadioBtn;

    @FindBy(id = "name")
    private WebElement accountName;

    @FindBy(id = "openingBalance")
    private WebElement initialDepositAmount;

    @FindBy(id = "newCheckingSubmit")
    private WebElement newCheckingSubmitBtn;

    public void createNewChecking(List<NewCheckingAccountInfo> checkingAccountInfoList){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkingBtn.click();
        newCheckingBtn.click();
        standardCheckingRadioBtn.click();
        individualRadioBtn.click();
        NewCheckingAccountInfo testDataForOneCheckingAccount = checkingAccountInfoList.get(0);
        accountName.sendKeys(testDataForOneCheckingAccount.getAccountName());
        initialDepositAmount.sendKeys(String.valueOf(testDataForOneCheckingAccount.getInitialDepositAmount()));
        newCheckingSubmitBtn.click();
    }
}

