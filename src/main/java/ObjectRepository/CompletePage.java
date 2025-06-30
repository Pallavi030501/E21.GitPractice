package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage
{
	//Declaration
	@FindBy(className = "complete-header")
	private WebElement message;
	
	@FindBy(xpath = "//button[.='Back Home']")
	private WebElement backHomeBtn;
	
	//initialization
	public CompletePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	//Utilization
	public WebElement getMessage() 
	{
		return message;
	}

	public WebElement getBackHomeBtn() 
	{
		return backHomeBtn;
	}
	
	//Business Library
	/**
	 * This method will capture the message and return to the caller
	 * @return message
	 */
    public String captureMessage()
    {
    	return message.getText();
    }
    /**
     * This method will click on back home button
     */
    public void clickOnBackHomeButton()
    {
    	backHomeBtn.click();
    }
	
}
