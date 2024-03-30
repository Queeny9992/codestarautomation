package Automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.common.CommonBase;
import Automation.constant.CT_Account;
import Automation.pagelocator.LoginPageFactory;

public class Login_New extends CommonBase{

	
	@BeforeMethod
	
	public void OpenChromeDriver() {
		driver = initChromeDriver(CT_Account.webURL);
		
	}
	
	@Test(priority = 1)
	public void LoginSuccess() {
		LoginPageFactory page = new LoginPageFactory(driver);
		page.LoginFunction(CT_Account.USER_NAME, CT_Account.PassWord);
		assertTrue(driver.findElement(CT_Account.MAIN_PAGE).isDisplayed());
	}
	
	@Test(priority = 2)
	public void LoginFail_WrongEmail() {
		LoginPageFactory page = new LoginPageFactory(driver);
		page.LoginFunction(CT_Account.Wrong_email, CT_Account.PassWord);
		assertTrue(driver.findElement(CT_Account.LOGIN_FAIL).isDisplayed());
		
	}
	
	@Test(priority = 3)
	public void LoginFail_WrongPassword() {
		LoginPageFactory page = new LoginPageFactory(driver);
		page.LoginFunction(CT_Account.USER_NAME, CT_Account.Wrong_pass);
		assertTrue(driver.findElement(CT_Account.LOGIN_FAIL).isDisplayed());
	}
	
	@Test(priority = 4)
	public void LoginFail_WrongEmailPass() {
		LoginPageFactory page = new LoginPageFactory(driver);
		page.LoginFunction(CT_Account.Wrong_email, CT_Account.Wrong_pass);
		assertTrue(driver.findElement(CT_Account.LOGIN_FAIL).isDisplayed());
		
	}
	
	@Test(priority = 5)
	public void LoginAndLogoutFunction() {
		LoginPageFactory page = new LoginPageFactory(driver);
		page.LoginFunction(CT_Account.USER_NAME, CT_Account.PassWord);
		
		page.LogOutFunction();
		assertTrue(driver.findElement(CT_Account.BTN_LOGIN).isDisplayed());

	}
	
	
	@AfterMethod
	public void closeChrome() {
		quitDriver(driver);
	}
	
	
}
