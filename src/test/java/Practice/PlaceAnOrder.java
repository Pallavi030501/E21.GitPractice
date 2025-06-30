package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PlaceAnOrder
{

	public static void main(String[] args)
	{
		WebDriver driver =new ChromeDriver();
		//Enter Url
		driver.get("https://www.saucedemo.com/");
		//login
		driver.findElement(By.xpath("//*[@*=\"Username\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@*='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@*='login-button']")).click();         
        //Add to cart
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        driver.findElement(By.xpath("//*[@*='shopping-cart-link']")).click();
        //checkout
        driver.findElement(By.xpath("//*[@*='checkout']")).click();
        //enter the details for checkout
        driver.findElement(By.xpath("//*[@*='First Name']")).sendKeys("Richa"); 
        driver.findElement(By.xpath("//*[@*='lastName']")).sendKeys("Sahu");                               
        driver.findElement(By.xpath("//*[@*='postalCode']")).sendKeys("751003");  
        //place an order
        driver.findElement(By.xpath("//*[@*='continue']")).click(); 
        driver.findElement(By.xpath("//*[@*='finish']")).click();
        //verify confirmation message
        WebElement confirmationmsg=driver.findElement(By.xpath("//*[text()='Thank you for your order!']"));
        if(confirmationmsg.getText().equals("Thank you for your order!"))
        {
        	System.out.println("confirmmsg validated");
        }
      //logout
        driver.findElement(By.xpath("//*[@*='button']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        
      

	}

}
