package generic;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListner extends BaseTest implements ITestListener{

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		String failedMethodname = result.getMethod().getMethodName();
		Reporter.log(" "+failedMethodname+" is the method which got failed",true);
		failed(failedMethodname);

	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}



