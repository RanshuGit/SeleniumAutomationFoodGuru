package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    // Locators for Registration Page
    By nameField = By.id("name");
    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By confirmPasswordField = By.id("re_pass");
    By contactField = By.id("contact");
    By checkBox = By.xpath("//*[@id='register-form']/div[6]/label/span");
    By signUpButton = By.id("signup");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // fill registration form
    public void fillRegistrationForm(String name, String email, String password, String contact) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(contactField).sendKeys(contact);
    }

    // click sign-up button
    public void clickSignUp() {
        driver.findElement(checkBox).click();
        driver.findElement(signUpButton).click();
    }
}
