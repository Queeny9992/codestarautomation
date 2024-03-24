package automation.testsuite;
import java.util.Set;
import java.sql.Driver;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.Day16_Acc;

public class PôppWindows_Day17 extends CommonBase{
@BeforeMethod
@Parameters("browserTest")
public void openBrower(@Optional("firefox") String browserName)
{
setupDriver(browserName);
driver.get(Day16_Acc.WEB_POPUP);
}
@Test
public void VerifyNewtab()
{
	pause(2000);
	click(By.xpath("//a[text()='Click Here']"));
	String mainWindow = driver.getWindowHandle();
	System.out.println("main window is : " + mainWindow);
	Set<String> listSubWindows = driver.getWindowHandles();
	for  (String subWindow : listSubWindows) {
		System.out.println("Sub window is: " +subWindow);
		if(!subWindow.equals(mainWindow))
		{
			driver.switchTo().window(subWindow);
			//Assert true
			assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/articles_popup.php");
			//"https://demo.guru99.com//popup.php"
			type(By.xpath("//input[@name='emailid']"),"testemail@gmail.com");
			click(By.xpath("//input[@name='btnLogin']"));
			
			System.out.println("Subwindow's title is : " + driver.switchTo().window(subWindow).getTitle());
			driver.close();
		}
	}
}
}
