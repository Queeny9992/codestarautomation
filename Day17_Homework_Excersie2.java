package HomeWork;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.Day16_Acc;
import bsh.org.objectweb.asm.Type;
import static org.testng.Assert.assertEquals;


public class Day17_Homework_Excersie2 extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(Day16_Acc.CODE_STAR);
	}
	@Test
	public void findFrameIndex() 
	{
		pause(100000);
		int totalFrame = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Tong so Iframe la: "+ totalFrame);
		for ( int i = 0; i < totalFrame; i++)
		{
			driver.switchTo().frame(i);
			int IndexFrame = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
			System.out.print("Da tim thay Fram la: "+ IndexFrame);
			driver.switchTo().defaultContent();		}
	}
	@Test
	public void handleFrame() 
	{
		pause(5000);
		scrollToElement(By.xpath("//button[text()='Gửi ngay']//parent::div//preceding-sibling::div//input[@id='account_phone']"));
		driver.switchTo().frame(1);
		//Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web
		type(By.xpath("//button[text()='Gửi ngay']//parent::div//preceding-sibling::div//input[@id='account_phone']"),"123456789");
		pause(3000);
		click(By.xpath("//button[text()='Gửi ngay']"));
        driver.switchTo().parentFrame();
        
        assertEquals(true,driver.findElement(By.xpath("//h2[contains(text(),'Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp')]")).isDisplayed());
		
		
	}
	
}
