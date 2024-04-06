package Automation.pagelocator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.thread.ThreadExecutionException;

import Automation.common.CommonBase;

public class LoginPageFactory {


	private WebDriver driver;
	
	public LoginPageFactory(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="email")	
	WebElement txtEmail;
	
	@FindBy(id="password")	
	WebElement txtPass;
	
	@FindBy(xpath="//button[@type='submit' and text()='Sign in']")	
	WebElement btnLogin;
	
	@FindBy(xpath = "//ul[@class='navbar-nav']/li[last()]")
	WebElement UserLogined;
	
	@FindBy(xpath = "//li/a[normalize-space()='Sign Out']")
	WebElement signOut;
	
	@FindBy(xpath = "//h4[text()='Dashboard']")
	WebElement EventFunction;
	
	@FindBy(xpath = "//a/span[text()='Events']")
	WebElement EventPage;
	
	@FindBy(xpath = "//a[text()=' Add event']")
	WebElement AddEvent;
	
	@FindBy(xpath = "//button[@type='button' and normalize-space()='Event type']")
	WebElement Eventtype;
	
	@FindBy(xpath = "//div//button[@type='button' and text()='month']")
	WebElement Month;
	
	@FindBy(xpath = "//div//button[@type='button' and text()='week']")
	WebElement Week;
	
	@FindBy(xpath = "//div//button[@type='button' and text()='day']")
	WebElement Day;
	
	@FindBy(xpath = "//div//button[@type='button' and text()='list']")
	WebElement List;
	
	@FindBy(xpath = "//button[@aria-label='next']")
	WebElement BtnNext_Event;
	
	@FindBy(xpath = "//button[@aria-label='prev']")
	WebElement BtnPrevious_Event;
	
	@FindBy(xpath = "//button[text()='today']")
	WebElement BtnToday;
	
	@FindBy(xpath="//button[@type='submit' and normalize-space()='Save']")
	WebElement AddEvent_btnSave;
	
	@FindBy(xpath= "//button[@type='submit' and normalize-space()='Save']/preceding-sibling::button")
	WebElement AddEvent_btnClose;
	
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement Txt_AddEvent_Title;
	
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement Txt_AddEvent_Description;
	
	@FindBy(id ="start_date")
	WebElement select_StartDate;
	
	@FindBy(id ="end_date")
	WebElement select_EndDate;
	
	@FindBy(xpath ="//div/a[text()=' Delete event']")
	private WebElement buttonDelete;
	
	@FindBy(xpath = "//a[text()=' Edit event']")
	private WebElement buttonYesDelete;
	
	
	@FindBy(xpath = "//button[text()='month']")
	WebElement btnMonthEvent;
	
	@FindBy(xpath = "//button[text()='week']")
	WebElement btnWeekEvent;
	
	@FindBy(xpath = "//button[text()='day']")
	WebElement btnDayEvent;
	
	
	
	
	
	
	
	
	
	public void LoginFunction(String email, String pass) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPass.clear();
		txtPass.sendKeys(pass);
		btnLogin.click();
	}
	
	public void LogOutFunction() {
		UserLogined.click();
		signOut.click();
	}
	
	public void addNewEvent(String name, String StartDate, String EndDate) {
		
		EventPage.click();
		AddEvent.click();
		Txt_AddEvent_Title.click();
		Txt_AddEvent_Title.sendKeys(name);
		select_StartDate.click();
		select_StartDate.sendKeys(StartDate);
		AddEvent_btnSave.click();
		
		

	}	
	
	public void addNewEvent7Days(String name, String StartDate, String EndDate) throws InterruptedException{
		
		EventPage.click();
		AddEvent.click();
    	Thread.sleep(5000);

		Txt_AddEvent_Title.click();
		Txt_AddEvent_Title.sendKeys(name);
		
		WebElement startDate = driver.findElement(
                By.xpath("//input[@id='start_date']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", startDate);
	        startDate.clear();
	        startDate.sendKeys(StartDate);
	        startDate.sendKeys(Keys.TAB);
	     
	    WebElement endDate = driver.findElement(
	                By.xpath("//input[@id='end_date']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", endDate);
		        endDate.clear();
		        endDate.sendKeys(EndDate);
		        endDate.sendKeys(Keys.TAB);
		    	Thread.sleep(5000);

				AddEvent_btnSave.click();

	}
	
	public void  DeleteEvent() {
	
		buttonDelete.click();
    	buttonYesDelete.click();
		
	}
	
	
	// Hien thi event page theo chon loc month- nhấn vào event page , sau đó tìm xpath của month , click đến nó , rồi check hiển 
	public void EventMonth() {
		EventPage.click();
		btnMonthEvent.click();
		
	}

	private void pause(int i) {
		// TODO Auto-generated method stub
		
	}	
	
	
	
	
}
