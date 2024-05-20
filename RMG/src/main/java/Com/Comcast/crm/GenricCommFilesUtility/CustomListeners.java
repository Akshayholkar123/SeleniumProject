package Com.Comcast.crm.GenricCommFilesUtility;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;
import Com.Comcast.Generic.WebDriverUtility.UtilityClassObj;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
public class CustomListeners implements ITestListener,ISuiteListener {
    public ExtentSparkReporter spark;
    public  ExtentReports report;
public static ExtentTest test;
	public void onStart(ISuite suite) {
		
		spark=new ExtentSparkReporter("./AdvanceReports/reports2.html");
		spark.config().setDocumentTitle("crm test result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add new info and theme
		report=new ExtentReports();
		report.attachReporter(spark);
		 
		report.setSystemInfo("os","windows 12");
		report.setSystemInfo("Browser","chromium");
		


		
	}

	public void onFinish(ISuite suite) {
		report.flush();
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("test start");

		test=report.createTest(result.getMethod().getMethodName()); 
        UtilityClassObj uco=new UtilityClassObj();
        uco.setTest(test);
	}
	

	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO,result.getMethod().getMethodName()+"  this test case is success ");

	}

	public void onTestFailure(ITestResult result) {
		String failedMtdname=result.getMethod().getMethodName();
		Reporter.log(failedMtdname+" this the mtd which got failed");
		
		TakesScreenshot ts=(TakesScreenshot)BS_Class.driver;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		JavaUtility ju=new JavaUtility();	
		String time=ju.getTimeTamp();
		test.addScreenCaptureFromBase64String(filePath,failedMtdname+" "+time);

		//File dest=new File("./screenshots/"+failedMtdname+"+"+ju.getTime()+".png");
		
		
		}

		
	

	public void onTestSkipped(ITestResult result) {
		test.log(Status.INFO,result.getMethod().getMethodName()+"  skipped ");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.INFO,result.getMethod().getMethodName()+"  TestFailedButWithinSuccessPercentage ");

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		test.log(Status.INFO,result.getMethod().getMethodName()+"  skipped with timeOut");
	}

	/*
	 * public void onStart(ITestContext context) { }
	 * 
	 * public void onFinish(ITestContext context) { }
	 * 
	 * @Override public int hashCode() { // TODO Auto-generated method stub return
	 * super.hashCode(); }
	 *  
	 * @Override public boolean equals(Object obj) { // TODO Auto-generated method
	 * stub return super.equals(obj); }
	 * 
	 * @Override protected Object clone() throws CloneNotSupportedException { //
	 * TODO Auto-generated method stub return super.clone(); }
	 * 
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return super.toString(); }
	 * 
	 * @Override protected void finalize() throws Throwable { // TODO Auto-generated
	 * method stub super.finalize(); }
	 */
}
