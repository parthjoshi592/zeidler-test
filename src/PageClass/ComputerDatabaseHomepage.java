package PageClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerDatabaseHomepage {

	WebDriver driver;
	
	@FindBy(id="searchbox")
	WebElement filterBox;
	
	@FindBy(id="searchsubmit")
	WebElement filterButton;
	
	@FindBy(xpath="//a[text()='Add a new computer']")
	WebElement addComputerButton;
	
	@FindBy(xpath="//a[contains(text(), 'Next')]")
	WebElement nextButton;
	
	@FindBy(xpath="//table[contains(@class, 'computers')]//a[contains(text(), 'OLCF')]")
	WebElement testElement;
	
	@FindBy(xpath="//em[contains(text(), 'Nothing to display')]")
	WebElement noResultsText;
	
	public ComputerDatabaseHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void filterComputer(String searchTerm) {
		filterBox.sendKeys(searchTerm);
	}
	
	public void clickFilterButton() {
		filterButton.click();;
	}
	
	public boolean checkResults() {
		List<WebElement> results = new ArrayList<WebElement>();
		results = this.driver.findElements(By.xpath("//table[contains(@class, 'computers')]//a[contains(text(), 'OLCF-4')]"));
		if ( results.size() > 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addItem() {
		addComputerButton.click();
	}
	
	public boolean isTestElementPresent() {
		if (testElement.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickComputer() {
		testElement.click();
	}
	
	public boolean isNoResultsFound() {
		if (noResultsText.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
}
