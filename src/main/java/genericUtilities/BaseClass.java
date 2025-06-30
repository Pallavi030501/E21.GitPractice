package genericUtilities;
/**
 * This class consists of basic configuration annotation of TestNG
 * @author PALLAVI S
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class BaseClass
{
   public FileUtility futil= new FileUtility();
   public JavaUtility Jutil=new JavaUtility();
   public SeleniumUtility sutil =new SeleniumUtility();
   public WebDriver driver;
   
   //for Listeners
   public static WebDriver sDriver;
   
   @BeforeSuite(alwaysRun=true)
   public void bsconfig()
   {
	   System.out.println("--------------Database connection sucessful-----------");
   }
   //
  // @AfterTest
  // @Parameters("Browser")
   @BeforeClass(alwaysRun = true)
   public void bcconfig(/*String pValue*/) throws IOException
   {
	   String URL = futil.readDataFromPropertyFile("url");
	   //launch browser
	  // driver=new EdgeDriver();
//	   if(pValue.equals("edge"))
//	   {
//		   driver=new EdgeDriver();
//	   }
//	   else if(pValue.equals("firefox"))
//	   {
//		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
//	   }
//	   else 
//	   {
//		   driver=new EdgeDriver();
//	   }
	   sutil.maximizeWindow(driver);
	   sutil.addImplicitlyWait(driver);
	   driver.get(URL);
	   //for Listeners
	   sDriver=driver;
	   System.out.println("--------------Browser launch sucessful-----------");
   }
   
   @BeforeMethod(alwaysRun = true)
   public void bmconfig() throws IOException
   {
	   String Username = futil.readDataFromPropertyFile("username");
	   String Password = futil.readDataFromPropertyFile("password");
	   
	   LoginPage lp=new LoginPage(driver);
	   lp.loginToApp(Username, Password);
	   System.out.println("--------------Login to application sucessful-----------");   
   }
   
   @AfterMethod(alwaysRun = true)
   public  void amconfig()
   {
	   InventoryPage ip=new InventoryPage(driver);
	   ip.logoutOfApp();
	   System.out.println("--------------Logout to application sucessful-----------");

   }
   
  // @AfterTest
   @AfterClass(alwaysRun = true)
   public void acconfig()
   {
	   driver.quit();
	   System.out.println("--------------Browser Closure sucessful-----------");

   }
   
   @AfterSuite(alwaysRun = true)
   public void asconfig()
   {
	   System.out.println("--------------Database closure sucessful-----------");

   }

}
