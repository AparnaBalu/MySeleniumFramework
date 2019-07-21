package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseclass.driverInstance;
import utilityPackage.ExcelUtils;
import Pages.loginpage;

public class TC_Login1 extends driverInstance{
	private int iTestCaseRow;
  @Test(dataProvider="Authentication")
  public void tc_01_login_test(String username,String password) throws Exception
  {
	  loginpage login=new loginpage(driver);
	  login.enterusername(username);
	  login.enterpassword(password);
	  login.clicksignin();
	 Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
  }
  @DataProvider
	
	//public static Object[][] credentials()
//	{
	//	return new	Object[][] {{"arjun","arjun"},{"arjun","hari"}};
	//}
  public Object[][] Authentication() throws Exception
  {
	  utilityPackage.ExcelUtils.setExcelFile("./testData/TestData.xlsx","testdata");
	  String sTestCaseName="DataProviderWithExcel";
	  iTestCaseRow=ExcelUtils.getRowContains(sTestCaseName,0);
	  Object[][] testObjArray=ExcelUtils.getTableArray(iTestCaseRow);
	  return(testObjArray);
  }
  }
	

