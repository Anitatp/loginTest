package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    @FindBy (id ="username")
    private WebElement usernameField;
    @FindBy (id="password")
    private WebElement passwordField;
    @FindBy (css ="#login button")
    private WebElement loginButton;
    @FindBy (id ="flash")
    private WebElement statusAlert;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public LoginPage login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public String getSuccessfulLoginMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(getStatusAlert()));
        return statusAlert.getText();
    }

    public String getErrorLoginMessage(){
        return statusAlert.getText();
    }

    private WebElement getStatusAlert(){
        return statusAlert;
    }
}
