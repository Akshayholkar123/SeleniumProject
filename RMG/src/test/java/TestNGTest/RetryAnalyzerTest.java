package TestNGTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerTest {
  @Test(retryAnalyzer =Com.Comcast.crm.GenricCommFilesUtility.RetryAnalyzer.class)
  public void retry() {
	  System.out.println("execute retry test");
	  Assert.assertEquals(1,true);
	  System.out.println("1");
	  System.out.println("2");
	  System.out.println("3");
	  System.out.println("4");
  }
}
