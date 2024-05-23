package Revision;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnSelenium {

	WebDriver driver;

	// Element -list
	By USER_NAME_FIELD = By.xpath("//input[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//input[@id=\"password\"]");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id=\"login_submit\"]");
	By DASHBOARD_HEADER_FIELD = By.xpath("//span[text() = 'Dashboard']");
	By CUSTOMER_MENU_FIELD = By.xpath("//span[ text() = 'Customers']");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//span[text() = 'Add Customer']");
	By ADD_CUSTOMER_HEADER_FIELD = By.xpath("//strong [text() = 'New Customer']");
	//By FULL_NAME_FIELD = By.xpath("//input[@class='form-control name ']");
	//By COMPANY_DROPDOWN_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/span/span[1]/span");

	String DashboardHeaderText = "Dashboard";
	String AddCustomerHeaderText = "New Customer";
	String FullName = "Selenium";
	String company="Techfios";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void Test1() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com ");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		Assert.assertEquals("Dashboard page not available", driver.findElement(DASHBOARD_HEADER_FIELD).getText(),
				DashboardHeaderText);
		driver.findElement(CUSTOMER_MENU_FIELD).click();
	//	driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
	//	Assert.assertEquals("New Customer page not available", driver.findElement(ADD_CUSTOMER_HEADER_FIELD).getText(),
			//	AddCustomerHeaderText);

	}

	@Test
	public void Test2() {
		Test1();
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		Assert.assertEquals("New Customer page not available", driver.findElement(ADD_CUSTOMER_HEADER_FIELD).getText(),
				AddCustomerHeaderText);
	//	driver.findElement(FULL_NAME_FIELD).sendKeys(FullName + generateRandomNum(999));
	//	SelectFromDropDown(COMPANY_DROPDOWN_FIELD,company);
	
	}

	private int generateRandomNum(int boundaryNumb) {
		Random rnd = new Random();
		int randomNum = rnd.nextInt(boundaryNumb);
		return randomNum;
		
	}
private void SelectFromDropDown(By field,String visibleText) {
	Select sel = new Select(driver.findElement(field));
	sel.selectByVisibleText(visibleText);
}

}
