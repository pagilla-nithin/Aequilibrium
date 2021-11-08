package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.TestUtil;

public class LoginTest extends HomePage{
	
public 	WebDriver driver;
	
	@BeforeTest
	void setup() {
		System.out.println("Start Test");
	}

	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp",priority = 3)
	public void doLoginValid(String username, String password) throws InterruptedException {
		HomePage home= new HomePage();
		home.doLoginWithValidUser(username, password);
	}
	
	
	
	@Test(priority = 4)
	public void doLoginLocked() {
		HomePage home = new HomePage();
		home.doLoginLocked("locked_out_user","secret_sauce");
	}
	
	@Test(priority = 5)
	public void doLoginInvalidUser() {
		HomePage home = new HomePage();
		home.doLoginWithInvalidUser("user","sauce");
	}

	@Test(priority = 1)
	public void verifyTitle() {
		HomePage home = new HomePage();
		home.verifyTitle();
	}

	

	@Test(priority = 2)
	public void verifyUrl() {
		HomePage home = new HomePage();
		home.verifyUrl();
	}

	@AfterTest
	void teardown() {
		driver.close();
	}
	
	
}
