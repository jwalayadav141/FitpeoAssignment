package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitpeoHomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href=\"/home\"]/div[contains(text(),\"Home\")]")
	WebElement Title;
	
	public FitpeoHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void verifyHeader() {
		String pageTitle = Title.getText();
		System.out.println("Page title is : "+ pageTitle);

	}

}
