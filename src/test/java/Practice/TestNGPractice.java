package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice 
{
//	@Test(priority = 1)
//	public void create()
//	{
//		System.out.println("Create");
//	}
//	@Test(priority = 2)
//	public void modify()
//	{
//		System.out.println("modify");
//	}
//	@Test(priority = 3)
//	public void delete()
//	{
//		System.out.println("Delete");
//	}
//	
	//@Test(priority = 1)
	//@Test(priority = -1)
//	@Test(priority = 1,invocationCount = 3)
//	public void create()
//	{
//		System.out.println("Create");
//	}
//	@Test(enabled = false)
//	public void modify()
//	{
//		System.out.println("modify");
//	}
//	@Test(priority = 3)
//	public void delete()
//	{
//		System.out.println("Delete");
//	}
	
	@Test
	public void create()//create a customer
	{
		//Assert.fail();//fail
		System.out.println("Create");
	}
	@Test()
	public void modify()
	{
		System.out.println("modify");
	}
	@Test(priority = 3,dependsOnMethods = "create")
	public void delete()
	{
		System.out.println("Delete");
	}

}
