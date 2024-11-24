package baseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	// Created WebDriver obj instance
	public WebDriver driver;
	
	// created setUp method in Beforeclass tag, which is used for setup all the pre-requisite for start the automation
	// used chrome as browser and all the capability added here
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		
		// Launch the specific URL
		driver.get("https://www.fitpeo.com/");
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// Set Implicit wait which will be applicable for whole class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// added teardown method for closing all the browser opened during session
	@AfterClass
	public void tearDown() {
//		driver.quit();
	}

}
