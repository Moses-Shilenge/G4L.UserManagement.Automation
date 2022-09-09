package useCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(id = "email")
    private WebElement loginEmail;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(xpath = "/html/body/app-root/app-login/div/form/button")
    private WebElement loginButton;

    @FindBy(className = "")
    private WebElement errorText;

    @FindBy(name = "")
    private WebElement loginForm;

    private UserManagementPage userManagementPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        userManagementPage = PageFactory.initElements(driver, UserManagementPage.class);
    }

    public LoginPage enterEmail(String email) {
        loginEmail.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        loginPassword.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
