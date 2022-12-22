package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id = "id_username")
    private WebElement usernameTextBox;

    @FindBy (id = "id_password")
    private WebElement passwordTextBox;

    @FindBy (css = ".btn.btn-success")
    private WebElement loginButton;

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completeLogin(String username, String password) {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }
}
