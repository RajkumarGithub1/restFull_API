package genericLib;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIclass //implements EndPoints
{
	
	public DatabaseUtils dutil=new DatabaseUtils();
	
	
	@BeforeSuite
	public void connectToDB() throws Throwable
	{
		dutil.createConnection();
		
	}
	
	
	@AfterSuite
	public void closeConnectToDB() throws Throwable
	{
		dutil.closeConnection();
		
	}
	
}
