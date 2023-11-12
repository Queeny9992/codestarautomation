package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_checkbox_radio_Drop extends CommonBase {
	@BeforeMethod
	public void OpenChrome()
	{
			driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}
	@Test
	public void ClickOnCheckBox()
	{
		//Kiểm tra giá trị mặc định của checkbox khi ở page( giả sử RQM là : khi mở page thì Default checkbox đã được chẹcked)
	 WebElement defaultCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Default Checked']/input"));
	 if(defaultCheckbox.isSelected()==true)
	 {
		 System.out.println("Pass vi default checkbox da duoc check ");
	 }
	 else {
		 System.out.println("Fail vi default checkbox chua duoc check hoac bi loi");
	 }
	 //Ấn vào check box bất kì còn lại 
	 WebElement testcheckbox = driver.findElement(By.xpath("//label[normalize-space()='Click on this check box']/input"));
	 if(testcheckbox.isSelected()==false)
	 {
		 testcheckbox.click();
		 System.out.println("Test check box da duoc cheked");
	 }
	}
	
}
