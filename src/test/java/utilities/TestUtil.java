package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.Page;

public class TestUtil extends Page {
	
	
	public static String fileName;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./test-output/html/" + fileName));

	}


	@DataProvider(name="dp")
	public static Object[][] getData(Method m) {
		Object [][] data = new Object[3][2];		
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		data[2][0]="performance_glitch_user";
		data[2][1]="secret_sauce";
		
		return data;
	}
	

}
