package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FoodGuruLogin {
//FoodGuruLoginPage
	public static void main(String[] args) throws InterruptedException {
		// Complete Login and Logout
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anshu\\Selenium WebDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/login.jsp");
		//if we don't send key to any field and keep empty (throws pop up) for required
		driver.findElement(By.name("username")).sendKeys("rajput@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("123");
		Thread.sleep(3000);
		driver.findElement(By.name("signin")).click();
		System.out.println("Login Successful!!");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.linkText("LOGOUT")).click();
		System.out.println("Logout Successful!!");
		Thread.sleep(2000);
		driver.close();
	}
}
