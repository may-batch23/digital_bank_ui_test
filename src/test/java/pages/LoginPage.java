package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "remember=me")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up Here')]")
    private WebElement signUpHereLink;

    //create instance methods

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitBtn.click();
    }
}

