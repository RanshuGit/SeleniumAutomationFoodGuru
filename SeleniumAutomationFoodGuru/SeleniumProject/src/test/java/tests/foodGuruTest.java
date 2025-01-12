package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class foodGuruTest {
    WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeSuite
    public void setup() {
        // Setup WebDriver
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
		driver.manage().window().maximize();
        // report setup
        htmlReporter = new ExtentHtmlReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // opens base url
        driver.get("http://localhost:8084/login.jsp");
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    // Registration functionality
    @Test(groups = "regression")
    public void testRegistration() throws InterruptedException {
        driver.manage().window().maximize();
        ExtentTest test = extent.createTest("Validate user registration functionality");
        test.info("Started");

        // navigate to registration page
        driver.findElement(By.className("signup-image-link")).click();
        test.log(Status.INFO, "Registration Page Opened");

        // fill registration form
        try {
            registrationPage.fillRegistrationForm("John", "john@gmail.com", "john123", "7888878888");
            registrationPage.clickSignUp();
            test.pass("Registration successful for user John");
        } catch (Exception e) {
            test.fail("Registration failed: " + e.getMessage());
        }

        test.info("Ended");
    }

    // login functionality
    @Test(groups = {"smoke","regression"})
    public void testLogin() throws InterruptedException {
        driver.manage().window().maximize();
        ExtentTest test = extent.createTest("Validate user login functionality");
        test.info("Started");
        try {
            loginPage.login("john@gmail.com", "john123");
            test.log(Status.INFO, "Login Button Clicked");

            if (loginPage.isLogoutButtonDisplayed()) {
                test.pass("Login successful. Logout button is visible.");
            } else {
                test.fail("Login failed. Logout button is not visible.");
            }

        } catch (Exception e) {
            test.fail("Login failed: " + e.getMessage());
        }

        test.info("Ended");
    }

    @AfterSuite
    public void close() {
        extent.flush();
        driver.quit();
    }
}
