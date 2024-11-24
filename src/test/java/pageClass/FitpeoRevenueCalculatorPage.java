package pageClass;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitpeoRevenueCalculatorPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href=\"/revenue-calculator\"]")
	WebElement revenueCalculatorBtn;
	
	@FindBy(xpath = "//h5[contains(text(),\"Total Gross Revenue Per Year\")]")
	WebElement gross;
	
	@FindBy(xpath = "//span[contains(@class,\"MuiSlider\")]//input")
	WebElement slider;
	
	@FindBy(xpath = "//span[contains(@class,\"MuiSlider\")]//following-sibling::div//input[contains(@class,\"InputBase\")]")
	WebElement sliderInput;
	
	@FindBy(xpath = "//p[contains(text(),\"CPT-\")]")
	WebElement cpt;
	
	
	public FitpeoRevenueCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openRevenueCalculatorPage() {
		String text = revenueCalculatorBtn.getText();
		System.out.println("rev header: "+text);
		revenueCalculatorBtn.click();
	}
	public void grossRevenue() {
		String text = gross.getText();
		System.out.println("gross: "+text);
	}
	public void scrollToSlider() {
		Actions action=new Actions(driver);
		action.moveToElement(cpt).perform();
	}
	public void adjustSlider() throws InterruptedException {
		slider.sendKeys("860");
		Thread.sleep(10);
		String inputValue = sliderInput.getText();
		
		System.out.println("inputValue: "+inputValue);
	}

}
