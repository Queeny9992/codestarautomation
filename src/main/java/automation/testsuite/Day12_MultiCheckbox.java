package automation.testsuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;


public class Day12_MultiCheckbox extends automation.common.CommonBase{
	  @BeforeMethod
	  public void init() {
	    driver = initDriverTest("https://demo.seleniumeasy.com/basic-checkbox-demo.html");    
	    }
	  
	  @Test
	  public void multiCheckbox() throws InterruptedException {
	        //Chon node checkbox
	        WebElement checkbox1 = driver.findElement(By.xpath("//label[text()='Option 1']//input"));
	        WebElement checkbox2 = driver.findElement(By.xpath("//label[text()='Option 2']//input"));
	        //Click chọn 2 checkbox
	        checkbox1.click();
	        checkbox2.click();
	        pause(2000);
	        //Cach kiem tra cac o checkbox da duoc click hay chua
	        //1. Lay het list checkbox
	        List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
	        System.out.println("Tong so luong checkbox: " + listCheckbox.size());
	        //2. Duyet List tren de lay ra tung thang checkbox
	        for (int i = 0; i < listCheckbox.size(); i++) {
	            //Lay ra tung vi tri checkbox theo thu tu bat dau tu 0
	        	System.out.println(listCheckbox.get(i).isSelected());
	            //Tao bien luu gia tri True False de if else (dat dieu kien)
	            boolean isCheckbox = listCheckbox.get(i).isSelected(); //Tra ra True/False
	            //3.1 Cach lay tung item (WebElement) trong List de so sanh
	            if (isCheckbox == true) {
	               System.out.println("Vi tri thu " + (i + 1) + " Passed");
	            }
	        }
	        //3.2 Cach chi dinh tung thang item trong list cu the de so sanh
	        System.out.println("--------------");
	        if (listCheckbox.get(0).isSelected() == true) {
	        	System.out.println("Vi tri thu nhat Passed");
	        }
	        if (listCheckbox.get(1).isSelected() == true) {
	        	System.out.println("Vi tri thu hai Passed");
	        }
	        //3.3 Cach lay ra tung element cu the - dua vao so luong item cua List tren
	        System.out.println("--------------");
	        //Duyet List tren de lay ra tung thang checkbox
	        for (int i = 0; i < listCheckbox.size(); i++) {
	            //Lay ra Element theo thu tu trong List WebElement da luu de kiem tra tung thang Checkbox
	            WebElement itemCheckbox = driver.findElement(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox'][" + (i + 1) + "]//input"));
	            System.out.println(itemCheckbox.isSelected());
	        }
	        pause(2000);
	       driver.close();
	    }
}
