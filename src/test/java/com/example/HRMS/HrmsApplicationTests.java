package com.example.HRMS;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HrmsApplicationTests {

	/*public static WebDriver driver;
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	

	@BeforeEach
	public void browserSetup(){

		extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/extentReport.html");
       	extentReports = new ExtentReports();
       	extentReports.attachReporter(extentSparkReporter);

		//configuration items to change the look and feel
       	//add content, manage tests etc
		extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
		extentSparkReporter.config().setReportName("Test Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		//extentSparkReporter.config().setTheme(Theme.DARK);
		//extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void tittleVerification() {

		
		extentTest = extentReports.createTest("Test Title Verification");

		driver.get("http://localhost:8080/");

        // Print and verify title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Add assertion if necessary
        assert title.equals("Employee Management");

		extentTest.log(Status.PASS, "TITTLE VERIFICATION PASSED");

	}

	@Test
    public void addNewEmployee() {

		extentTest = extentReports.createTest("EMPLOYEE SAVE TEST");

        // Navigate to the "Add New Employee" page
       	driver.get("http://localhost:8080/");

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

		extentTest.log(Status.PASS, "SAVE EMPLOYEE DETAILS PASSED");

    }

	@AfterEach
	public void close(){

		extentReports.flush();

		if(driver != null){
			driver.quit();
		}
		
	}*/

}
