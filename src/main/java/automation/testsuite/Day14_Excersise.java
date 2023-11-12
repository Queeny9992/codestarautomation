package automation.testsuite;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class Day14_Excersise{

	 private WebDriver driver;

	    @FindBy(xpath = "//a[text()='Đăng Ký']")
	    private WebElement Dangki;
	    @FindBy(xpath = "//input[@id='txtFirstname']")
	    private WebElement Hoten;
	    @FindBy(xpath = "//input[@id='txtEmail']")
	    private WebElement Email;
	    @FindBy(xpath = "//input[@id='txtCEmail']")
	    private WebElement ReEmail;
	    @FindBy(xpath = "//input[@id='txtPassword']")
	    private WebElement Password;
	    @FindBy(xpath = "//input[@id='txtCPassword']")
	    private WebElement RePassword;
	    @FindBy(xpath = "//input[@id='txtPhone']")
	    private WebElement Phone;
	    @FindBy(xpath = "//input[@id='chkRight']")
	    private WebElement AgreeCheckbox;
	    @FindBy(xpath = "//button[text()='ĐĂNG KÝ' and @class='btn_pink_sm fs16']")
	    private WebElement ButtonDangki;


	    @FindBy(xpath = "//div[@class='avatar2']")
	    private WebElement Avata;
	    @FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
	    private WebElement Chinhsuathongtin;
	    @FindBy(xpath = "//input[@id='txtpassword']")
	    private WebElement OldPassword;
	    @FindBy(xpath = "//input[@id='txtnewpass']")
	    private WebElement NewPassword;
	    @FindBy(xpath = "//input[@id='txtrenewpass']")
	    private WebElement ReNewpassword;
	    @FindBy(xpath = "//button[contains(text(),'Lưu mật khẩu mới')]")
	    private WebElement ButtonLuumatkhau;


	    @FindBy(xpath = "//a[text()='Đăng Nhập']")
	    private WebElement Dangnhap;
	    @FindBy(xpath = "//input[@id='txtLoginUsername']")
	    private WebElement LoginEmail;
	    @FindBy(xpath = "//input[@id='txtLoginPassword']")
	    private WebElement LoginPassword;
	    @FindBy(xpath = "//button[text()='ĐĂNG NHẬP' and contains(@class,'btn_submit')]")
	    private WebElement ButtonDangnhap;

	    public Day14_Excersise(WebDriver _driver){
	        this.driver = _driver;
	        PageFactory.initElements(driver,this);
	    }
	    public void SignUpFunction(String hoten, String email, String pass,String phone){
	        Dangki.click();
	        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        Hoten.clear();
	        Hoten.sendKeys(hoten);
	        Email.clear();
	        Email.sendKeys(email);
	        ReEmail.clear();
	        ReEmail.sendKeys(email);
	        Password.clear();
	        Password.sendKeys(pass);
	        RePassword.clear();
	        RePassword.sendKeys(pass);
	        Phone.clear();
	        Phone.sendKeys(phone);
	        if (AgreeCheckbox.isSelected() == false){
	            AgreeCheckbox.click();
	        }
	        ButtonDangki.click();
	    }
	    public void ChangePassword(String email,String oldpasswork,String newpasswork) throws InterruptedException {
	        Dangnhap.click();
	        LoginEmail.clear();
	        LoginEmail.sendKeys(email);
	        LoginPassword.clear();
	        LoginPassword.sendKeys(oldpasswork);
	        ButtonDangnhap.click();
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        Avata.click();
	        Chinhsuathongtin.click();
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        WebElement element = driver.findElement(By.xpath("//input[@id='txtpassword']"));
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        Thread.sleep(3000);
	        OldPassword.clear();
	        OldPassword.sendKeys(oldpasswork);
	        NewPassword.clear();
	        NewPassword.sendKeys(newpasswork);
	        ReNewpassword.clear();
	        ReNewpassword.sendKeys(newpasswork);
	        ButtonLuumatkhau.click();
	    }
	    public void LoginNewPassword(String email, String newpassword){
	        Dangnhap.click();
	        LoginEmail.clear();
	        LoginEmail.sendKeys(email);
	        LoginPassword.clear();
	        LoginPassword.sendKeys(newpassword);
	        ButtonDangnhap.click();
	    }

	}

