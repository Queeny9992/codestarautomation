package automation.testsuite;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import automation.common.CommonBase;
import automation.constant.Day16_Acc;

public class Handle_IFrame_Day17 extends CommonBase {
	@BeforeTest
	public void openChrome(){
		
		driver = initChromeDriver(Day16_Acc.CODE_STAR);
		
	}
	@Test
	//tim index cua iframe can switch toi
	public void findIFrameIndex()
	{
		pause(6000);
		int totalFrame = driver.findElements(By.tagName("iframe")).size();
		//
		System.out.println( "Tong so frame la :" +totalFrame);
		for(int i = 0; i < totalFrame; i++)
		{
			driver.switchTo().frame(i);
			int IndexFrame = driver.findElements(By.xpath("//button[text()='Đăng ký ngay']")).size();
			System.out.println("Da tim thay  Element Index:" + IndexFrame);
			driver.switchTo().defaultContent();
		}
		}
	@Test
		public void handleFrame() {
			scrollToElement(By.xpath("//h2[contains(text(),'Đăng ký nhận tài liệu')]"));
			driver.switchTo().frame(3);
			type(By.xpath("//input[@name='account_name']"), "AutoTestName");
			click(By.xpath("//button[text()='Đăng ký ngay']"));
			assertTrue(isElementPresent(By.xpath("//button[text()='Đăng ký ngay']")));
			driver.switchTo().defaultContent();
		}
	}


