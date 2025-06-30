package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver =new ChromeDriver();
		//Enter the Url
		driver.get("https://www.saucedemo.com/");
		//enter the usernamne andpassword
		driver.findElement(By.xpath("//*[@*=\"Username\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@*='Password']")).sendKeys("secret_sauce");
        //login 
        driver.findElement(By.xpath("//*[@*='login-button']")).click();
        //product is displayed or not
        if(driver.findElement(By.xpath("//*[text()='Products']")).getText().equals("Products"))
        {
        	System.out.println("product page is displayed");
        }
        else
        {
        	System.out.println("product page is not displayed");
        
        }
        //logout
        driver.findElement(By.xpath("//*[@*='button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        
	}

}
