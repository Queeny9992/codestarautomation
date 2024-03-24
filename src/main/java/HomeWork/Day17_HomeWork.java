package HomeWork;

import java.util.Set;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import automation.common.CommonBase;
import automation.constant.Day16_Acc;

public class Day17_HomeWork extends CommonBase{
	@BeforeMethod
	public void openChrome()
	{
		// Mở web cần test 
		//vào cái class ở constant trong file day16_acc để truy cập vào trang coder star
		driver = initChromeDriver(Day16_Acc.CODE_STAR);
	}
	@Test
	public void findFrameIndex()
	{
		pause(100000);
		//tim tong so iframe co trong web
		int totalFrame = driver.findElements(By.tagName("iframe")).size();
		//in ra tong so frame trong web bang cach goi ra total frame
		System.out.println("Tong so iframe trong web la:" + totalFrame);
		
		//dung vong lap for de loc total frame xem cai la cai frame minh can tim, dung findElements de tim bang By.xpath
		for (int i = 0; i < totalFrame; i++)
		{
			//switchTo() chuyen doi sang khung frame co xpath nhu ben duoi
			//tìm index của iframe cần swithc 
			driver.switchTo().frame(i);
			int IndexFrame = driver.findElements(By.xpath("//span[text()='Bắt đầu chat']")).size();
			// In ra man hinh la da tim thay frame
			System.out.println("Da tim thay Iframe: "+ IndexFrame);
			// khi ma tim duoc roi se switch ve defaultcontent(trang chủ) luon
			//sau khi in ra  element cần tìm  phải trở về frame cha  để tìm đến 
			driver.switchTo().defaultContent();
		}
		
	}
	@Test
	public void handleFrame()
	{	
		pause(30000);
		driver.switchTo().frame(5);
		click(By.xpath("//span[text()='Bắt đầu chat']"));
		pause(10000);
		click(By.xpath("//span[text()='Sử dụng Messenger']"));
		//luu lai lop windown dau tien
		String mainWindown = driver.getWindowHandle();
		System.out.println("Main windown hien tai la :" + mainWindown);
		//lay ra tat ca cac tab windown dang open bang ham getWindownHandle
		//set la 1  để lưu các phần tử giá trị KHÔNG trùng lặp
		Set<String> windowns = driver.getWindowHandles();
		//Cách duyệt từng tử không trùng lặp trong Collection (Set) ta dùng for each
		for(String windown : windowns) {
			System.out.println(windown);
			// so sánh nếu window nào khác  chính (đầu tiên) thì chuyển qua để thao tác 
			if(!mainWindown.equals(windown)) {
				driver.switchTo().window(windown);
				//Assert True
				type(By.xpath("//input[@type='email']"),"Automationtest@gmail.com");
				type(By.xpath("//input[@type='password']"),"hihi@1234");
				pause(2000);
				click(By.xpath("//div[text()='Use Messenger']/parent::button"));
				// trong truong hop ko loi, ko duoc dung if else
				assertTrue(driver.findElement(By.xpath("//")).isDisplayed());
				System.out.println("Đã chuyển đến lớp windown con");
				//Mot so ham ho tro
				System.out.println("Windown's Title: " +driver.switchTo().window(windown).getTitle());		
				driver.close();
			}
		}
		

	}
	

}
