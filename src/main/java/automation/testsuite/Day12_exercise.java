package automation.testsuite;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Day12_exercise extends CommonBase{
	@BeforeMethod
    public void OpenChrome(){
        driver = initChromeDriver("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
    @Test (priority = 1)
    public void Bai_1a_SelectList(){
        WebElement elementSelectListDemo = driver.findElement(By.xpath("//select[@id='select-demo']"));

        Select selectListDemo = new Select(elementSelectListDemo);

        selectListDemo.selectByIndex(1);
        System.out.println("Đã chọn Sunday By Index");
        pause(2000);

        selectListDemo.selectByVisibleText("Monday");
        System.out.println("Đã chọn Monday By Text");
        pause(2000);

        selectListDemo.selectByValue("Tuesday");
        System.out.println("Đã chọn Tuesday By Value");
        pause(2000);

        if(selectListDemo.isMultiple()==true){
            System.out.println("Đây là dạng Mutil Select");
        }else {
            System.out.println("Đây không phải là dạng MutilSelect");
        }

        System.out.println("Số lượng thẻ Option : "+selectListDemo.getOptions().size());
        Assert.assertEquals(8,selectListDemo.getOptions().size());

        System.out.println(selectListDemo.getFirstSelectedOption().getText());
        Assert.assertEquals("Tuesday",selectListDemo.getFirstSelectedOption().getText());

        driver.close();
    }
    @Test (priority = 2)
    public void Bai_1b_MultiSelectList() {
        WebElement elementSelectMultiListDemo = driver.findElement(By.xpath("//select[@id='multi-select']"));

        Select selectMultiListDemo = new Select(elementSelectMultiListDemo);

        if(selectMultiListDemo.isMultiple()==true){
            System.out.println("Đây là dạng Mutil Select");
        }else {
            System.out.println("Đây không phải là dạng MutilSelect");
        }

        selectMultiListDemo.selectByVisibleText("California");
        pause(2000);

        selectMultiListDemo.selectByVisibleText("New York");
        pause(2000);

        selectMultiListDemo.selectByVisibleText("Florida");
        pause(2000);

        WebElement GetAllSelected = driver.findElement(By.xpath("//button[@id='printAll']"));
        GetAllSelected.click();
        pause(2000);
//Không hiển thị 3 Option sau khi chọn, chỉ hiển thị Option chọn cuối cùng Florida
        System.out.println("Đã chọn");
        pause(2000);
        driver.close();
    }
    @Test (priority = 3)
    public void Bai_2_SelectOption() {
        driver.navigate().to("http://demo.seleniumeasy.com/input-form-demo.html");

        WebElement elementState = driver.findElement(By.xpath("//select[@name='state']"));

        Select State = new Select(elementState);

        State.selectByVisibleText("Colorado");
        pause(2000);
        Assert.assertEquals("Colorado",State.getFirstSelectedOption().getText());

        WebElement elementHostingYes = driver.findElement(By.xpath(" //input[@name='hosting' and @value='yes']"));
        pause(2000);
        if (elementHostingYes.isSelected()) {
            System.out.println("Radio đã được chọn");
        }else {
            elementHostingYes.click();
        }
        pause(2000);

        driver.close();
    }
}
