package org.tyss.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.Attachment;

public class ListenerImplementation implements ITestListener {
	
	 private ExtentReports report;
	 private ExtentTest test;
	 public static  ExtentTest testLog;
	

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark= new ExtentSparkReporter("./extentreport-output/emailable-extentreport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Rport name");
		spark.config().setTheme(Theme.DARK);
		
			
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows 10");
		report.setSystemInfo("Browser Name","Chrome");	
		
		test= report.createTest(context.getClass().getSimpleName());
		test.assignAuthor("Smruti");
		test.assignCategory("smoke");
		testLog=test;
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
//		test= report.createTest(result.getMethod().getMethodName());
//		test.assignAuthor("Smruti");
//		test.assignCategory("smoke");
//		testLog=test;
				
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"is pass");
		
		
	}
	@Attachment(value="def", type="img/png")
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"is Failed");
		test.fail(result.getThrowable());
		String pathOfScreenShot=UtilityObjectClass.getWebdriverutility().takesScreenShotElementBase64(UtilityObjectClass.getDriver());
		test.addScreenCaptureFromBase64String(pathOfScreenShot, result.getMethod().getMethodName());
		
		byte[] path = UtilityObjectClass.getWebdriverutility().takesScreenShotElementBytes(UtilityObjectClass.getDriver());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"is Skipped");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
		
	}

	
	
	
}
