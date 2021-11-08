package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Page;

public class HomePage extends Page {
	
	
	public void doLoginWithValidUser(String username, String password) {
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		String expectedUrlHome="https://www.saucedemo.com/inventory.html";
		if (expectedUrlHome.equals(driver.getCurrentUrl())) {
			System.out.println(" login user ");
		}else {
			Assert.fail("Login fail ");
		}	
	
	}
	
	public void doLoginWithInvalidUser(String username, String password) {
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		String actual=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()")).getText();
		String expected="Epic sadface: Username and password do not match any user in this service";
		if (actual.equals(expected)) {
			System.out.println(expected +"is equal to "+ actual);
		}
		else { 
			Assert.fail("expected is different from actual");
		}

		driver.findElement(By.id("user-name")).clear();;
		driver.findElement(By.id("password")).clear();
		
	}


	public void doLoginLocked(String username, String password) {

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		String actual=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()")).getText();
		String expected="Epic sadface: Sorry, this user has been locked out.";
		if (actual.equals(expected)) {
			System.out.println(expected +"is equal to "+ actual);
		}
		else { 
			Assert.fail("expected is different from actual");
		}
		driver.findElement(By.id("user-name")).clear();;
		driver.findElement(By.id("password")).clear();;
	}
	
	public void verifyTitle() {
		
		String expectedTitle="Swag Labs";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	public void verifyUrl() {
		
		String expectedUrl="https://www.saucedemo.com/";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	
	}	

}
