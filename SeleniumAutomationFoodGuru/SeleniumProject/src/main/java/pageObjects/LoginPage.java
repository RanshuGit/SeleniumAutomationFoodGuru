package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // Locators for Login Page
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.name("signin");
    By logoutButton = By.linkText("LOGOUT");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // login method
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // logout button visibility check
    public boolean isLogoutButtonDisplayed() {
        WebElement logoutBtn = driver.findElement(logoutButton);
        return logoutBtn.isDisplayed();
    }
}
