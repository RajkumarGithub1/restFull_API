package genericLib;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtil 
{

	public int getrandomNumber()
	{
		Random r=new Random();
		int number = r.nextInt(2000);
		
		return number;
		
	}
}
