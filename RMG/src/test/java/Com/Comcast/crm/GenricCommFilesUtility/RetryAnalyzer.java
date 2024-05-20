package Com.Comcast.crm.GenricCommFilesUtility;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer {
int count=0;
int limiCount=5;

	public boolean retry(ITestResult result) {
		if(count<limiCount) {
			count++;
			return true;
		}		
		return false;
	}
}
