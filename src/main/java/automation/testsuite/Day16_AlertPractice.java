package automation.testsuite;


import org.testng.annotations.*;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;
import bsh.org.objectweb.asm.Type;

public class Day16_AlertPractice extends CommonBase{

	@BeforeMethod
	public void openChromeDriver()
	{
		driver = initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
	}
	
	@Test
	public void deleteCustomer()
	{
		type(By.xpath("//input[@name='cusid']"),"id123");
		click(By.xpath("//input[@name='submit']"));
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		assertEquals(driver.getTitle(),"Delete Customer");
		assertTrue(isElementPresent(By.xpath("//h2[text()='Guru99 Bank']")));
		System.out.println("Page title is : "+driver.getTitle());
	}
	@AfterMethod
	public void quitDriver()
	{
	//	quitDriver();
	}
}
