package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class Login extends CommonBase{
	@BeforeTest
	public void openSystemUnderTest() {
		driver = initChromeDriver(CT_Account.webURL);
	}
	@Test
	public void LoginSuccessfully() {
		WebElement txtEmail = driver.findElement(CT_Account.TEXTBOX_EMAIL);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.TEXTBOX_PASS);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		WebElement btnLogin = driver.findElement(CT_Account.BTN_LOGIN);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
			
		}
		pause(4000);
		assertEquals(true,driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
	}
	@AfterTest
	public void closeChrome() {
		quitDriver(driver);
	}
	
}
