package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtil;

public class CustomListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {


		Reporter.log("Test case pass");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("custom listnere    ");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		Reporter.log("<a href="+TestUtil.fileName+" target=\"_blank\">Screenshot Captured</a>");
		Reporter.log("<br>");
		
		Reporter.log("<a href="+TestUtil.fileName+" target=\"_blank\"><img src="+TestUtil.fileName+" height=200 width=200></a>");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
