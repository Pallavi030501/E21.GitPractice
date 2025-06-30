package Inventorytests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
@Listeners(genericUtilities.ListenImplementationutility.class)
public class AddLowestPriceProductToCart extends BaseClass
{
	//using business library
	//public static void main(String[] args) throws IOException 
	
	//using TestNG
	@Test(groups = "RegressionSuite")
	public void tc_002_AddLowestPriceProductToCartTest() throws IOException
	{
	//		//create object of utilities
	//		FileUtility futil= new FileUtility();
	//		SeleniumUtility sutil =new SeleniumUtility();
	//
	//		//Read the common data from property file
	//		String URL=futil.readDataFromPropertyFile("url");
	//		String USERNAME = futil.readDataFromPropertyFile("username");
	//		String PASSWORD = futil.readDataFromPropertyFile("password");
	//Launching the browser
	//	WebDriver driver =new EdgeDriver();
	//	sutil.maximizeWindow(driver);
	//	sutil.addImplicitlyWait(driver);

	//	//Load the  URL
	//	driver.get(URL);
	//
	//	//login to application
	//	LoginPage lp=new LoginPage(driver);
	//	lp.loginToApp(USERNAME, PASSWORD);

//	if(productincart.equals(PRODUCTNAME))
//	{
//		System.out.println("PASS");
//		System.out.println(productincart);
//	}
//	else
//	{
//		System.out.println("product is not displayed");
//	}
//
//	//logout
//	ip.logoutOfApp();

//Using BaseClass
		//Read the test data from excel sheet
		String SORTOPTION=futil.readDataFromExcelFile("Products", 4, 2);
		System.out.println(SORTOPTION);
		String PRODUCTNAME= futil.readDataFromExcelFile("Products",4,3);
		System.out.println(PRODUCTNAME);

		//choose the sort option from drop-down
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnLowestProduct(driver, SORTOPTION, PRODUCTNAME);

		// click on a product
		ip.clickOnAProduct(driver, PRODUCTNAME);

		//add to cart
		InventoryItemPage itp=new InventoryItemPage(driver);
		itp.clickOnAddcartBtn();

		//navigate to the cart
		ip.clickOnCartContainerBtn();

		//validate for the product in the cart
		CartPage cp=new CartPage(driver);
		String productincart =cp.captureItemName();
		Assert.assertTrue( productincart.equals(PRODUCTNAME));

	}
}


