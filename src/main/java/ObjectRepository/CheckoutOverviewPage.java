package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage 
{
	//declaration
	@FindBy(className = "inventory_item_name")
	private WebElement itemName;

	@FindBy(xpath="//button[.='Finish']")
	private WebElement finishbtn;
	
	@FindBy(xpath = "//button[.='Cancel']")
	private WebElement cancelbtn;
	
	//initialization
	public CheckoutOverviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getFinishbtn() {
		return finishbtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	//Business library
	/**
	 * This method will capture the product name and return to caller
	 * @return product name
	 */
	public String ItemName()
	{
		return itemName.getText();
	}
	/**
	 * This method will click on finish button
	 */
	public void clickOnFinishButton()
	{
		finishbtn.click();
	}
	
}
