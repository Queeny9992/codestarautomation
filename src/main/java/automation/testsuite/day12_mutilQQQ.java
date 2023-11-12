package automation.testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
public class day12_mutilQQQ extends automation.common.CommonBase {

	@BeforeMethod
	
	public void init() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		
	}
	@Test
	public void multichekcbox() {
		//Lấy hết list checkbox
		List<WebElement> listcheckbox = driver.findElements(By.xpath("(//div[@class='panel-body']/[3])//div[@class='checkbox']//input"));
	System.out.println("Tong so luong check box: " + listcheckbox.size());
	//Duyet list tren de lay ra tung thang check box trong list cac checkbox
	for (int i = 0; i < listcheckbox.size(); i++) {
		//cach lay tung item (WebElement) trong list de so sanh 
		WebElement checkbox = listcheckbox.get(i);
		if(checkbox.isSelected()==true) {
			System.out.println("check box o vi tri thu" + (i+1)+ "da duoc check");
		}else {
			checkbox.click();
		}
		}
	pause(2000);
	driver.close();
	}
	
	@Test
	public void Multicheckbox3() {
		List<WebElement>  listcheckbox=driver.findElements(By.xpath("(//div[@class='panel-body']/[3])//div[@class='checkbox']//input"));
	System.out.println( " TOng so luong check box: " + listcheckbox.size());
	//3.3 cach lay ra tung element cu the -dua vao so luong  item cua list tren
	for (int i = 0; i < listcheckbox.size(); i++);{
		//lay ra element theo thu tu trong  list cac  WebElement da luu  de kiem tra  tung checkbox
//		WebElement checkbox = driver.findElement(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox'][" + ( i + 1 ) + "]//input"));
//		if (i==2 && checkbox.isSelected() == false)
//		{
//			checkbox.click();
//		}
	}
	}
}




