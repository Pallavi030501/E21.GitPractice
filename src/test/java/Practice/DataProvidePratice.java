package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidePratice 
{
	@Test(dataProvider = "customerinfo")
	public void createCustomer(String name, int id)
	{
		//name id -5 -run multiple times- different data
		//multiple customer in single execution
		System.out.println("the customer name -->"+name);
		System.out.println("the customer id is -->"+id);
	}
	
	//stock your data
	@DataProvider(name="customerinfo")//row and columns
	public Object[][] getData()
	{
		//4sets of data and each set has 2 info
		Object[][] data =new Object[4][2];
		//First data set
		data[0][0]="sima";
		data[0][1]=12;
		
		//Second data set
		data[1][0]="richa";
		data[1][1]=14;
		
		//Third data set
		data[2][0]="Pallavi";
		data[2][1]=18;

		//Fourth data set
		data[3][0]="Aditya";
		data[3][1]=14;
		
		return data;

	}

}
