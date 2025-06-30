package Inventorytests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.CartPage;
import ObjectRepository.CheckoutOverviewPage;
import ObjectRepository.CheckoutPage;
import ObjectRepository.CompletePage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class PlaceAnOrder 
{

	public static void main(String[] args) throws IOException 
	{
		//create object of utilities
		FileUtility futil= new FileUtility();
		SeleniumUtility sutil =new SeleniumUtility();

		//Read the common data from property file
		String URL=futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String FIRSTNAME =futil.readDataFromPropertyFile("firstname");
		String LASTNAME =futil.readDataFromPropertyFile("lastname");
		String ZIPCODE=futil.readDataFromPropertyFile("zipcode");

		//Read the test data from excel sheet
		String PRODUCTNAME= futil.readDataFromExcelFile("Products",1,2);

		//Launching the browser
		WebDriver driver =new EdgeDriver();
		sutil.maximizeWindow(driver);
		sutil.addImplicitlyWait(driver);

		//Load the  URL
		driver.get(URL);

		//login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// click on a product
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);

		//add to cart
		InventoryItemPage itp=new InventoryItemPage(driver);
		itp.clickOnAddcartBtn();

		//navigate to the cart
		ip.clickOnCartContainerBtn();

		//click on checkout
		CartPage cp=new CartPage(driver);
		String productincart =cp.captureItemName();
		System.out.println(productincart);
		cp.clickOnCheckoutBtn();

		//checkout to application
		CheckoutPage ckp=new CheckoutPage(driver);
		ckp.checkoutToApp(FIRSTNAME, LASTNAME, ZIPCODE);
		ckp.clickOnContinueButton();

		//Place an order
		CheckoutOverviewPage cop=new CheckoutOverviewPage(driver);
		System.out.println(cop.ItemName());
		cop.clickOnFinishButton();

		//navigate to complete page
		CompletePage cmp=new CompletePage(driver);
		String confirmMessage=cmp.captureMessage();
		System.out.println(confirmMessage);

		if(confirmMessage.equals("Thank you for your order!"))
		{
			System.out.println("confirmmsg validated");
		}
		cmp.clickOnBackHomeButton();
		//logout
		ip.logoutOfApp();
	}

}
