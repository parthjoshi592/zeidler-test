package CrudTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClass.AddComputerPage;
import PageClass.ComputerDatabaseHomepage;
import PageClass.ComputerDetailsPage;

public class CrudTest {
	private WebDriver driver;
	private String baseUrl;
	ComputerDatabaseHomepage homePage;
	AddComputerPage addComputerPage;
	ComputerDetailsPage detailsPage;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Parth\\eclipse-workspace\\libs\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		baseUrl = "http://computer-database.herokuapp.com/computers";

		homePage = new ComputerDatabaseHomepage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test (priority = 1)
	// Testing the create and read operations
	public void addComputer() {
		homePage.addItem();
		addComputerPage = new AddComputerPage(driver);
		addComputerPage.enterDetails();
		addComputerPage.clickCreate();
		homePage.filterComputer("OLCF-4");
		homePage.clickFilterButton();
		Assert.assertTrue(homePage.checkResults());
	}

	@Test (priority = 2)
	// Testing the update operation
	public void updateComputer() {
		homePage.filterComputer("OLCF-4");
		homePage.clickFilterButton();
		Assert.assertTrue(homePage.isTestElementPresent());
		homePage.clickComputer();
		detailsPage = new ComputerDetailsPage(driver);
		detailsPage.editName();
		detailsPage.saveComputer();
	}
	
	@Test (priority = 3)
	// Testing the delete operation
	public void deleteComputer() {
		homePage.filterComputer("OLCF");
		homePage.clickFilterButton();
		Assert.assertTrue(homePage.isTestElementPresent());
		homePage.clickComputer();
		detailsPage = new ComputerDetailsPage(driver);
		detailsPage.deleteItem();
		homePage.filterComputer("OLCF");
		homePage.clickFilterButton();
		Assert.assertTrue(homePage.isNoResultsFound());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
