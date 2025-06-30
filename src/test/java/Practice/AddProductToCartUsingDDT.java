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

public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException 
	{
		//common data from property file
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		//Read the test data from excel sheet
		FileInputStream fise =new  FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fise);
		Sheet sh =wb.getSheet("Products");
		Row rw=sh.getRow(1);
		Cell cel =rw.getCell(2);
		String PRODUCTNAME= cel.getStringCellValue();

		//Launching the browser
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter the  URL
		driver.get(URL);
		//login to application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login-button")).click();
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









