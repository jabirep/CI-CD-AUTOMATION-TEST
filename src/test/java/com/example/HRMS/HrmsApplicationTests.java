package com.example.HRMS;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
class HrmsApplicationTests {

	public static WebDriver driver;

	@BeforeEach
	public void browserSetup(){

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void tittleVerification() {

		driver.get("http://localhost:8082");

        // Print and verify title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Add assertion if necessary
        assert title.equals("Employee Management");

	}

	@Test
    public void addNewEmployee() {
        // Navigate to the "Add New Employee" page
        driver.get("http://localhost:8082/");

        // Locate form fields and fill them
        WebElement nameField = driver.findElement(By.id("employeeName"));  // Replace with actual field locator
        nameField.sendKeys("John Doe");

        WebElement emailField = driver.findElement(By.id("employeeEmail"));  // Replace with actual field locator
        emailField.sendKeys("john.doe@example.com");

        WebElement position = driver.findElement(By.id("employeePosition"));  // Replace with actual field locator
        position.sendKeys("Engineer");

        // Locate the submit button and click it
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='employeePosition']"));  // Replace with actual button locator
        submitButton.click();
    }

	@AfterEach
	public void close(){

		if(driver != null){
			driver.quit();
		}
		
	}

}
