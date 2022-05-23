package genericLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils 
{
	Connection con=null;
	
	public void createConnection() throws Throwable
	{
		Driver dr=new Driver();
		DriverManager.registerDriver(dr);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		
	}
	
	public void closeConnection() throws Throwable
	{
		con.close();
	}
	
	
	public ResultSet executeQueryInStatement(String query) throws Throwable
	{
		Statement s = con.createStatement();
		ResultSet result = s.executeQuery(query);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
