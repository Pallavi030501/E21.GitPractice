package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage 
{
	//Declaration
	@FindBy(id = "add-to-cart")
	private WebElement addToCartBtn;


	//Initialization

	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getAddToCartBtn() 
	{
		return addToCartBtn;
	}

	//Business library
	/**
	 * This method will click on add to cart button
	 */
	public void clickOnAddcartBtn()
	{
		addToCartBtn.click();
	}

	

	
		
	
}
