package utils;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private  Driver() {

    }
    public static WebDriver getDriver() {
        if(driver == null) {

            String browser = ConfigReader.getPropertiesValue("browser");

            switch(browser.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "internet explorer":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "headless":
                    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("disable-extensions");
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("proxy-bypass-list=*");
                    options.addArguments("--start-maximized");
                    options.addArguments("--headless");

                    driver = new FirefoxDriver(options);
                    break;


                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
