package automation.testsuite;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_MultiCheckbox1 extends automation.common.CommonBase {
	@BeforeMethod
	@Parameters("browserTxest")
	public void openChrome(String browser) {
	
		//	driver = initEdgeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html"); 
	
		setupDriver(browser);driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}
	@Test
	public void handleRadioButton() {
		WebElement FemaleRadio = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
		if (FemaleRadio.isEnabled()== false)// kiem tra neu checkbox chua enable thi doi 3s
		{
			pause(3000);
				
		}
		if(FemaleRadio.isSelected() ==false) 
		{
			FemaleRadio.click();
		}
		
	}

}
