package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FoodGuruRegistration {
//FoodGuru Registration Page
	public static void main(String[] args) throws InterruptedException {
		// Complete Registration of Page
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anshu\\Selenium WebDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/login.jsp");
		//if we don't send key to any field and keep empty (throws pop up) for required
		driver.findElement(By.className("signup-image-link")).click();
		System.out.println("Registration Page Opened!!");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("John");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("john@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("john123");
		Thread.sleep(2000);
		driver.findElement(By.id("re_pass")).sendKeys("john123");
		Thread.sleep(2000);
		driver.findElement(By.id("contact")).sendKeys("7888878888");
		Thread.sleep(2000);
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]/label/span"));
		checkBox.click();
		Thread.sleep(3000);
		driver.findElement(By.id("signup")).click();
		System.out.println("Registration Successful!!");
		Thread.sleep(3000);
		driver.close();
	}

}
