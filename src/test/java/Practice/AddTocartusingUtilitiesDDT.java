package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddTocartusingUtilitiesDDT 
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

		//Read the test data from excel sheet
		String PRODUCTNAME= futil.readDataFromExcelFile("Products",1,2);

		//Launching the browser
		WebDriver driver =new EdgeDriver();
		sutil.maximizeWindow(driver);
		sutil.addImplicitlyWait(driver);

		//Load the  URL
		driver.get(URL);

		//login to application
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.name("login-button")).click();

//		LoginPage lp=new LoginPage(driver);
//			     lp.getUsernameEdt().sendKeys(USERNAME);
//			     lp.getPasswordEdt().sendKeys(PASSWORD);
//			     lp.getLoginBtn().click();
//
//		lp.loginToApp(USERNAME, PASSWORD);

		// click on a product and add to cart
	
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.name("add-to-cart")).click();
		

		//navigate to the cart
		driver.findElement(By.id("shopping_cart_container")).click();
		//validate for the product in the cart
		String productincart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productincart.equals(PRODUCTNAME))
		{
			System.out.println("PASS");
			System.out.println(productincart);
		}
		else
		{
			System.out.println("product is not displayed");
		}
		//logout

		driver.findElement(By.id("react-burger-menu-btn")).click();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();


	}

}
