package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteProduct 
{

	public static void main(String[] args)
	{
		//Launch browse
		WebDriver driver =new ChromeDriver();
		//enter url
		driver.get("https://www.saucedemo.com/");
		//enter un and pw
		driver.findElement(By.xpath("//*[@*=\"Username\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@*='Password']")).sendKeys("secret_sauce");
        //login
        driver.findElement(By.xpath("//*[@*='login-button']")).click();
        //add to cart
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        //go to cart
        driver.findElement(By.xpath("//*[@*='shopping-cart-link']")).click();
        //remove product from cart
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //verify product is removed or not
        if(driver.findElement(By.xpath("//*[text()='Your Cart']")).getText().isEmpty())
        	System.out.println("empty cart");
      //logout
        driver.findElement(By.xpath("//*[@*='button']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        

	}

}
