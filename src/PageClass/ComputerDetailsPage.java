package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerDetailsPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameTextbox;
	
	@FindBy(xpath="//input[contains(@class, 'danger') and @value='Delete this computer']")
	WebElement deleteButton;
	
	@FindBy(xpath="//input[contains(@class, 'primary') and @value='Save this computer']")
	WebElement saveComputerButton;	
	
	public ComputerDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void deleteItem() {
		deleteButton.click();
	}
	
	public void editName() {
		nameTextbox.clear();
		nameTextbox.sendKeys("OLCF");
	}
	
	public void saveComputer() {
		saveComputerButton.click();
	}
	
}
