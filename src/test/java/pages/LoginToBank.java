package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToBank {

    private WebDriver driver;

    public LoginToBank(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameTxtBtn;

    @FindBy(id = "password")
    private WebElement passwordTxtBtn;

    @FindBy(xpath = "//button")
    private WebElement submitBtn;

    public void login(String username, String password) {
        usernameTxtBtn.sendKeys(username);
        passwordTxtBtn.sendKeys(password);
        submitBtn.click();
    }




}
