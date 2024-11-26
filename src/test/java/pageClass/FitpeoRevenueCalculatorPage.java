package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FitpeoRevenueCalculatorPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@href=\"/revenue-calculator\"]")
	WebElement revenueCalculatorBtn;

	@FindBy(css = ".MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.css-sy3s50")
	WebElement sliderBallMovmentElement;

	@FindBy(xpath = "//input[@type='range']")
	WebElement sliderBallElement;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")
	WebElement textBoxBySliderBoxElement;
	
	@FindBy(id = ":r0:")
	WebElement textBoxBySliderElement;

	@FindBy(xpath = "//p[contains(text(),\"CPT-\")]")
	WebElement cpt;
	
	// update the text field related xpath
	@FindBy(xpath = "//p[contains(text(),\"Total Recurring Reimbursement for all Patients Per Month:\")]/p")
	WebElement totalRecurring;
	
	// Created Constructor for initialize the webdriver
	public FitpeoRevenueCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    // It will open the revenue calculator page
	public void openRevenueCalculatorPage() {
		String text = revenueCalculatorBtn.getText();
		System.out.println("rev header: " + text);
		revenueCalculatorBtn.click();
	}

	// scroll down to slider section with action class till cpt section
	// now the slider will be in middle of screen
	public void scrollToSlider() {
		Actions action = new Actions(driver);
		action.moveToElement(cpt).perform();
	}

	// method will adjust the slider according to requirement and verify
	// the slider value and input box value
	public void adjustSlider(int setTheSliderValue) throws InterruptedException {
		
	       // Clear the input text box
			textBoxBySliderBoxElement.sendKeys(Keys.CONTROL, "a");
			textBoxBySliderBoxElement.sendKeys(Keys.BACK_SPACE);

			// increase the value with help of up arrow
			for (int i = 0; i < setTheSliderValue; i++) {
				sliderBallElement.sendKeys(Keys.ARROW_UP);
			}

			//Extract the value of slider
			String sliderValueAfterEnterVlue = sliderBallElement.getAttribute("aria-valuenow");

			// Extract the value in input box
			String textBoxBySliderValue = textBoxBySliderBoxElement.getAttribute("value");

			// Verifying the slider value and input box using Assertion
			Assert.assertEquals(textBoxBySliderValue, sliderValueAfterEnterVlue);		
	}
	
	// 
	public void updateTheTextField(int inputValue) throws InterruptedException {

		textBoxBySliderBoxElement.click();

		int EnterTheValueInTextInputField =0; // The number you want to enter
		
		 // Clear the input text box
		textBoxBySliderBoxElement.sendKeys(Keys.CONTROL, "a");
		textBoxBySliderBoxElement.sendKeys(Keys.BACK_SPACE);

		// Press the up arrow key the required number of times
		while(EnterTheValueInTextInputField<inputValue) {
			
			textBoxBySliderBoxElement.sendKeys(Keys.ARROW_UP);
			EnterTheValueInTextInputField++;
          }
		
		// Take the value of slider
		String sliderValueAfterEnterVlue = sliderBallElement.getAttribute("aria-valuenow");

		String textBoxBySliderValue = textBoxBySliderBoxElement.getAttribute("value");

		Assert.assertEquals(textBoxBySliderValue, sliderValueAfterEnterVlue);
	}
	
	public void selectCPTCode(String s) throws InterruptedException {
		String Xpath = "//p[contains(text(),\""+s+"\")]/parent::div//label/span[contains(@class,\"Checkbox\")]";
		WebElement check = driver.findElement(By.xpath(Xpath));
		check.click();
	}
	public void validateRecurring() {
		String amount = totalRecurring.getText();
		Assert.assertEquals(amount, "$110700");
	}
	

}
