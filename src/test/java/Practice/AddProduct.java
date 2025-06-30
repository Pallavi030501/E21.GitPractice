package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProduct 
{

	public static void main(String[] args) 
	{
		//Launching the browser
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter the  URL
		driver.get("https://www.saucedemo.com/");
		//login to application
		driver.findElement(By.xpath("//*[@*=\"Username\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@*='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@*='login-button']")).click();
        // click on a product and add to cart
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        //navigate to the cart
        driver.findElement(By.xpath("//*[@*='shopping-cart-link']")).click();
        //validate for the product in the cart
        if(driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).isDisplayed())
        {
        	System.out.println("product is displayed");
        }
        else
        {
        	System.out.println("product is not displayed");
        }
      //logout
        driver.findElement(By.xpath("//*[@*='button']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        

	}

}
