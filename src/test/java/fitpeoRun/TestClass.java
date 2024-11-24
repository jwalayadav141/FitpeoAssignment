package fitpeoRun;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageClass.FitpeoHomePage;
import pageClass.FitpeoRevenueCalculatorPage;

public class TestClass extends BaseClass{
	FitpeoHomePage home;
	FitpeoRevenueCalculatorPage revenueCalculator;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Test(priority=0)
	public void homepage() throws InterruptedException {
		home = new FitpeoHomePage(driver);
		home.verifyHeader();
	}
	
	@Test(priority=1)
	public void revenueCal() {
		revenueCalculator = new FitpeoRevenueCalculatorPage(driver);
		revenueCalculator.openRevenueCalculatorPage();
		revenueCalculator.grossRevenue();
	}
	@Test(priority=2)
	public void medicareEligiblePatients() throws InterruptedException {
		revenueCalculator = new FitpeoRevenueCalculatorPage(driver);
		revenueCalculator.scrollToSlider();
		revenueCalculator.adjustSlider();
	}

}
