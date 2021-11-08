package base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public static WebElement dropdown;
	
	@AfterTest
	void teardown() {
		driver.close();
	}
		
		public Page() {
			if (driver == null) {

				PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

				try {
					fis = new FileInputStream("./src/test/resources/properties/Config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Config.load(fis);
					log.info("Config properties file loaded");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					fis = new FileInputStream("./src/test/resources/properties/OR.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					OR.load(fis);
					log.info("OR properties file loaded");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (Config.getProperty("browser").equals("chrome")) {

					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					log.info("Chrome browser launched !!!");
				} else if (Config.getProperty("browser").equals("firefox")) {

					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					log.info("Firefox browser launched !!!");
				}

				driver.get(Config.getProperty("testsiteurl"));
				log.info("Navigated to : " + Config.getProperty("testsiteurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
						TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));
			
			}

		}

	
	

}
