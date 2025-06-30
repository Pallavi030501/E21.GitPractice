package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage 
{
	//Declaration
	@FindBy(id = "first-name")
	private WebElement firstNameTextField;
	
	@FindBy(id="last-name")
	private WebElement lastNameTextField;
	
	@FindBy(id="postal-code")
	private WebElement zipcodeTextField;
	
	@FindBy(xpath="//button[.='Cancel']")
	private WebElement cancelBtn;
	
	@FindBy(id="continue")
	private WebElement continuebtn;
	
	//Initialization    

	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getFirstNameTextField()
	{
		return firstNameTextField;
	}

	public WebElement getLastNameTextField()
	{
		return lastNameTextField;
	}

	public WebElement getZipcodeTextField()
	{
		return zipcodeTextField;
	}

	public WebElement getCancelBtn()
	{
		return cancelBtn;
	}

	public WebElement getContinuebtn() 
	{
		return continuebtn;
	}
	
	//Business library
	/**
	 * This method will fil the details of checkout page
	 */
	public void checkoutToApp(String fn,String ln,String num) 
	{
		firstNameTextField.sendKeys(fn);
		lastNameTextField.sendKeys(ln);
		zipcodeTextField.sendKeys(num);
	}
	
	/**
	 * This method will click on cancel button
	 */
	public void clickOnCancelButton()
	{
		cancelBtn.click();
	}
	/**
	 * This method will click on a continue button 
	 */
	public void clickOnContinueButton()
	{
		continuebtn.click();
	}


}
