package pageObjectModel;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListner extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("test execution is sarted",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override	
	public void onTestFailure(ITestResult result) {
		String failedMethodName = result.getMethod().getMethodName();
		Reporter.log("" +failedMethodName+" is the method which got failed",true);
		try {
			failed(failedMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*String failedMethodName = result.getMethod().getMethodName();
	Reporter.log(" "+failedMethodName+" is the method which got failed",true);
	failed(failedMethodName);*/

} 

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("test execution is completed",true);

	}

}
