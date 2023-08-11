package vtigerGeneric_Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation implements ITestListener{

	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"test script execution started");
		test=reports.createTest(methodname);   //for extent report
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"test script pass");
		test.log(Status.PASS, "test script pass");    //for extent report
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"test script fail");
		test.log(Status.FAIL, "test script fail");
		
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		String Screenshotname = methodname+ju.systemDate();
		try {
			String path=wu.screenShot(BaseClass.sdriver, Screenshotname);
			test.addScreenCaptureFromPath(path);     //converting absolute to relative
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"test script skipped");
		test.log(Status.SKIP, "test script skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("suit level execution started");
		
		ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReport\\Report-"+new JavaUtility().systemDate()+".html");
				reporter.config().setDocumentTitle("Vtiger application Report");
				reporter.config().setTheme(Theme.STANDARD);
				reporter.config().setReportName("Vtiger Execution report");
				
				reports=new ExtentReports();
				reports.attachReporter(reporter);
				reports.setSystemInfo("BaseURL", "http://localhost:8888/");
				reports.setSystemInfo("Browser", "chrome");
				reports.setSystemInfo("reporter name", "prabhat");
				
	}

	@Override
	public void onFinish(ITestContext context) {
		
		reports.flush();
		System.out.println("suit level execution completed");
		
	}

	
	

}
