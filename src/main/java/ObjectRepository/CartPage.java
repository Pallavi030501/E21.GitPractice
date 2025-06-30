package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	//declaration
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;

	@FindBy(xpath = "//button[.='Remove']")
	private WebElement removeBtn;

	@FindBy(xpath = "//button[.='Checkout']")
	private WebElement checkoutBtn;
	//initialization
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getItemInfo() {
		return itemInfo;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	//Business Library
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	/**
	 * This method will capture the product name and return to caller
	 * @return product name
	 */
	public String captureItemName()
	{
		return itemInfo.getText();
	}
	/**
	 * This method will click on checkout button
	 */
	public void clickOnCheckoutBtn()
	{
		checkoutBtn.click();
	}
















}
