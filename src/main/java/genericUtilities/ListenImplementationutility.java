package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * @author PALLAVI S
 */

public class ListenImplementationutility implements ITestListener
{

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result)
	{
		//capture method name
		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+" - Test execution started");

		//capture test in extent reports
		test=report.createTest(MethodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//capture method name
		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+" - Test PASS");

		//Log the test status as PASS in extent reports
		test.log(Status.PASS, MethodName+" - Test PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//capture method name
		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+" - Test FAIL");

		//Log the test status as FAIL in extent reports
		test.log(Status.FAIL, MethodName+" - Test FAIL");

		//capture the exception
		System.out.println(result.getThrowable());

		//Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());

		//capture the screenshot
		SeleniumUtility s= new SeleniumUtility();
		JavaUtility j =new JavaUtility();

		//configure screenshot name
		String screenshotName = MethodName+"-"+j.getSystemDate();

		try 
		{
			String path=s.captureScreenShot(BaseClass.sDriver, screenshotName);

			//Attach the screenshot to extent report
			test.addScreenCaptureFromPath(path, screenshotName);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//capture method name
		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+" - Test SKIP");

		//Log the test status as SKIP in extent reports
		test.log(Status.SKIP, MethodName+" - Test SKIP");

		//capture the exception
		System.out.println(result.getThrowable());

		//Log the exception in extent reports
		test.log(Status.WARNING,result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("Suite execution started");

		//Basic settings of extent reports
		ExtentSparkReporter esr =new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Swag Labs Automation Framework Execution");

		//configure Extent Report
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Environment", "Test environment");
		report.setSystemInfo("Reporter Name", "Pallavi");

	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Suite execution finished");

		//Generate Extent Report
		report.flush();

	}


}
