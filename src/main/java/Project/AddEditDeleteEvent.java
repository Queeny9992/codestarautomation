	package Project;

	import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.pageLocator.Project_Login;

	public class AddEditDeleteEvent extends CommonBase {

	
		@BeforeMethod
		public void openChromeDriver()
		{
			driver = initChromeDriver("https://rise.fairsketch.com/signin");
			//tao bien theo cai project login
			Project_Login login = new Project_Login(driver);
			//goi phuong thuc login
			login.EventsPage("admin@demo.com", "riseDemo");
			
		}
		@Test(priority = 1)
		//ben login ma co throws interrup thi ben nay cung phai co thi moi chay duoc 
		public void addNewEvent() throws InterruptedException
		{
			//dat ten bien 
			Project_Login addEvent = new Project_Login(driver);
			//goi phuong thuc add o trong project_login
			addEvent.AddEvent("hihihi", "30-11-2023");
			pause(5000);
			Assert.assertTrue(driver.findElement(By.xpath("//td[@data-date='2023-11-30']//descendant::span[text()=' hihihi']")).isDisplayed());
		}
		
		
		@Test(priority = 2)
		//		public void EditEvent--chi la tu dat ten cho phuong thuc

		public void EditEvent() throws InterruptedException
		{
			Project_Login EditEventHihihi = new Project_Login(driver);
			EditEventHihihi.EditEvent("hahaha", "29-11-2023");
			pause(5000);
			Assert.assertTrue(driver.findElement(By.xpath("//td[@data-date='2023-11-29']//descendant::span[text()=' hahaha']")).isDisplayed());
		// delete event hahaha
		}
		
		@Test(priority = 3)
		
		public void DeleteEventHahaha()
		{
			Project_Login DeleteHahaha = new Project_Login(driver);
			DeleteHahaha.DeleteEvent();
		}
	}
