package automation.testsuite;
import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.CT_LocatorAlada;
import automation.constant.Day16_Acc;

public class Day16_HomeWork extends CommonBase{
	
	@BeforeMethod
    public void OpenChrome(){

       driver = initChromeDriver(CT_LocatorAlada.webAladaURL);
    }
    @Test
    public void AlertAlada(){
        click(CT_LocatorAlada.Dangnhap);
        type(CT_LocatorAlada.LoginEmail, Day16_Acc.EmailAlada);
        type(CT_LocatorAlada.LoginPassword,Day16_Acc.PassAlada);
        click(CT_LocatorAlada.ButtonDangnhap);
        click(CT_LocatorAlada.Avata);
        click(CT_LocatorAlada.Chinhsuathongtin);
        scrollToElement(CT_LocatorAlada.OldPassword);
        type(CT_LocatorAlada.OldPassword,Day16_Acc.PassAlada);
        type(CT_LocatorAlada.NewPassword,Day16_Acc.Passnew);
        type(CT_LocatorAlada.ReNewpassword,Day16_Acc.Passnew);
        click(CT_LocatorAlada.ButtonLuumatkhau);
        pause(2000);
        driver.switchTo().alert().accept();
        scrollToElement(CT_LocatorAlada.Thongtinkhoahoc);
        assertEquals(true,driver.findElement(CT_LocatorAlada.Thongtinkhoahoc).isDisplayed());



    }
    @AfterMethod
    public void CloseChrome(){
        quitDriver(driver);
    }
}
