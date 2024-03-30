package Automation.testsuite;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.desktop.QuitEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.common.CommonBase;
import Automation.constant.CT_Account;
import Automation.pagelocator.LoginPageFactory;
import Automation.pagelocator.*;



public class EventPage extends CommonBase {
	
	
	@BeforeMethod //mo trinh duyet va chay login
	public void OpenChromeDriver() {
		driver = initChromeDriver(CT_Account.webURL);
		LoginPageFactory page = new LoginPageFactory(driver);
		page.LoginFunction(CT_Account.USER_NAME, CT_Account.PassWord);
		assertTrue(driver.findElement(CT_Account.MAIN_PAGE).isDisplayed());
	}
	
	

	
	@Test(priority = 1) //add New Event-1day
	public void addNewEvent() {
		LoginPageFactory addEvent = new LoginPageFactory(driver);
		addEvent.addNewEvent("NaNa", getCurrentDateTime(), getCurrentDateTime());
		
		Assert.assertTrue(isElementPresent(By.xpath("//td[@data-date='"+getCurrentDateTime1()+"']//descendant::span[text()=' NaNa']")));
	}
	
	
	@Test(priority = 2)  //add New Event- 7day
	public void addNewEvent_7day() throws InterruptedException{
		LoginPageFactory addEventSevenDays = new LoginPageFactory(driver);
		addEventSevenDays.addNewEvent7Days("Na add Event 7days", getCurrentDateTime(),getNext7DaysOfCurrentDateTime());
		pause(5000);
		Assert.assertTrue(isElementPresent(By.xpath("//td[@data-date='"+getCurrentDateTime1()+"']//descendant::span[text()=' Na add Event 7days']")));
	}
	
	@Test(priority = 3) // xoa event vua tao
	public void DeleteEvent() {
		WebElement clickEven = driver.findElement(By.xpath("//a/span[text()='Events']"));
		if(clickEven.isDisplayed()) {
			clickEven.click();
		}
		pause(3000);
		
		WebElement deleteEve = driver.findElement(By.xpath("//td[@data-date='"+getCurrentDateTime1()+"']//descendant::span[text()=' Na add Event 7days']"));
		if(deleteEve.isDisplayed()) {
			deleteEve.click();
		}
		pause(3000);

		LoginPageFactory deleteEvent = new LoginPageFactory(driver);
		deleteEvent.DeleteEvent();
	}
	
	
	@Test(priority = 4) //kiem tra man hinh hien thi theo month
	public void EventIsDisplay_Month() {
		LoginPageFactory EvenisDisPlay_Month = new LoginPageFactory(driver);
		EvenisDisPlay_Month.EventMonth();
		
		assertTrue(driver.findElement(By.xpath("//h2[text()='"+getCurrentMonth()+"']")).isDisplayed());

	}
	
	@AfterMethod
	public void closeBrowser() {
		quitDriver(driver);
	}
}
