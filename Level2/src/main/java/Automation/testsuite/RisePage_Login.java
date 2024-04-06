package Automation.testsuite;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.common.CommonBase;
import Automation.constant.CT_Account;


public class RisePage_Login extends CommonBase {

	@BeforeMethod
	@Parameters("browserTest")
	
	public void OpenBrowser(@Optional("Chrome") String browserName) {
		setupDriver(browserName);
		driver.get(Automation.constant.CT_Account.webURL);
	}
	
	@Test(priority = 1)
	//login test / case đăng nhập thông tin đúng --đăng nhập thành công
	public void LoginSuccessfull() {
		WebElement txtEmail = driver.findElement(CT_Account.TEXTBOX_EMAIL);
			if(txtEmail.isDisplayed()) {
				txtEmail.clear();
				txtEmail.sendKeys(CT_Account.USER_NAME);
		}
		pause(3000);
		
		WebElement txtPass = driver.findElement(CT_Account.TEXTBOX_PASS);
			if(txtPass.isDisplayed()) {
				txtPass.clear();
				txtPass.sendKeys(CT_Account.PassWord);
		}
	
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement btnloginSubmit = driver.findElement(CT_Account.BTN_LOGIN);
			if(btnloginSubmit.isDisplayed()) {
				btnloginSubmit.click();
	}
	assertEquals(true, driver.findElement(CT_Account.MAIN_PAGE).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void loginFail_IncorrectEmail() {
	
		WebElement incorrectEmail= driver.findElement(CT_Account.TEXTBOX_EMAIL);
		if(incorrectEmail.isDisplayed()) {
			incorrectEmail.clear();
			incorrectEmail.sendKeys(CT_Account.Wrong_email);
		}
		
		WebElement txtPassword = driver.findElement(CT_Account.TEXTBOX_PASS);
		if(txtPassword.isDisplayed()) {
			txtPassword.clear();
			txtPassword.sendKeys(CT_Account.PassWord);
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement btnLoginSubmit = driver.findElement(CT_Account.BTN_LOGIN);
		if(btnLoginSubmit.isDisplayed()) {
			btnLoginSubmit.click();
		}
		assertEquals(true, driver.findElement(CT_Account.LOGIN_FAIL).isDisplayed());
		
	}
	 
	@Test  (priority = 3)
	public void loginFail_IncorrectPass() {
		
		WebElement txtEmail = driver.findElement(CT_Account.TEXTBOX_EMAIL);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys(CT_Account.USER_NAME);
		}
		
		WebElement txtWrongPassword = driver.findElement(CT_Account.TEXTBOX_PASS);
		if(txtWrongPassword.isDisplayed()) {
			txtWrongPassword.clear();
			txtWrongPassword.sendKeys(CT_Account.Wrong_pass);
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement btnLogin = driver.findElement(CT_Account.BTN_LOGIN);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		assertEquals(true, driver.findElement(CT_Account.LOGIN_FAIL).isDisplayed());
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		quitDriver(driver);
	}
	
	
	
	
	
}
