package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {
WebDriver driver;
	@FindBy(xpath="//span[text()='Clients']")
	WebElement clientsMenu;
	
	@FindBy(xpath = "//a[@title='Add client']")
	WebElement btnAddClient;
	
	@FindBy(id="company_name")
	WebElement textCompanyName;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath = "//button[text()='Sign in']")
    private WebElement SignInButton;
	
	public ClientPageFactory(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddNewClientFunction(String companyName)
	{
		SignInButton.click();
		clientsMenu.click();
		btnAddClient.click();
		textCompanyName.sendKeys(companyName);
		btnSave.click();
	}
	
	public void SearchNewClient(String companyName)
	{
		
	}
}
