package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility
{
	//Declaration


	@FindBy(className ="product_sort_container")
	private WebElement sortDropDown;

	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;

	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;


	//Initialization

	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization

	public WebElement getSortDropDown() 
	{
		return sortDropDown;
	}


	public WebElement getCartContainerBtn() 
	{
		return cartContainerBtn;
	}


	public WebElement getMenuBtn() 
	{
		return menuBtn;
	}


	public WebElement getLogoutLink()
	{
		return logoutLink;
	}

	//Business Library
	/**
	 * This method will perform logout operation
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLink.click();		
	}
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainerBtn()
	{
		cartContainerBtn.click();
	}
	/**
	 * This method will click on a product
	 * @param driver
	 * @param PRODUCTNAME
	 */
	public void clickOnAProduct(WebDriver driver,String PRODUCTNAME)
	{
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();

	}
	/**
	 * This method will sort the product for lowest price and click on it
	 * @param driver
	 * @param SORTOPTION
	 * @param PRODUCTNAME
	 */
	public void clickOnLowestProduct(WebDriver driver,String SORTOPTION,String PRODUCTNAME)
	{
		handleDropdown(sortDropDown,SORTOPTION);
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
	}




}
