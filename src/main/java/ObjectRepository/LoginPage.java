package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule1
{
	//Rule2-Declaration
	@FindBy(id="user-name")
	private WebElement usernameEdt;

	//@FindAll-identify single web-element with multiple locators
	//OR operator
	//Auto healing process
	//	@FindAll({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
	//	private WebElement usernameEdt;

	//@FindBys- identify single web-elements with multiple locators
	//AND operator
	//	@FindBys({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
	//	private WebElement usernameEdt;
	
	@FindBy(id="password")
	private WebElement passwordEdt;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	//Rule3- Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //Rule4-Utilization
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return passwordEdt;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	//Business-generic method-project specific
	/**
	 * This method will perform login operation
	 * @param un
	 * @param Pwd
	 */
	public void loginToApp(String un,String Pwd)
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(Pwd);
		loginBtn.click();
	}

}
