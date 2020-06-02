package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddComputerPage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Add a computer']")
	WebElement header;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameTextbox;
	
	@FindBy(xpath="//input[@id='introduced']")
	WebElement introducedTextbox;
	
	@FindBy(xpath="//input[@id='discontinued']")
	WebElement discontinuedTextbox;
	
	@FindBy(xpath="//select[@id='company']")
	WebElement companySelectbox;
	
	@FindBy(xpath="//input[@value='Create this computer']")
	WebElement createButton;
	
	public AddComputerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails() {
		nameTextbox.sendKeys("OLCF-4");
		introducedTextbox.sendKeys("2019-01-01");
		discontinuedTextbox.sendKeys("2020-01-01");
		Select selectDropbox = new Select(companySelectbox);
		selectDropbox.selectByVisibleText("IBM");
	}
	
	public void clickCreate() {
		createButton.click();
	}

}
