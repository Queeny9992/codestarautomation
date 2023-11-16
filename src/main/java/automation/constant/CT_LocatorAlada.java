package automation.constant;
import org.openqa.selenium.By;


public class CT_LocatorAlada
{

	    public static By Dangnhap = By.xpath("//a[text()='Đăng Nhập']");
	    public static By LoginEmail = By.xpath("//input[@id='txtLoginUsername']");
	    public static By LoginPassword = By.xpath("//input[@id='txtLoginPassword']");
	    public static By ButtonDangnhap = By.xpath("//button[text()='ĐĂNG NHẬP' and contains(@class,'btn_submit')]");
	    public static By Avata = By.xpath("//div[@class='avatar2']");
	    public static By Chinhsuathongtin = By.xpath("//a[text()='Chỉnh sửa thông tin']");
	    public static By OldPassword = By.xpath("//input[@id='txtpassword']");
	    public static By NewPassword = By.xpath("//input[@id='txtnewpass']");
	    public static By ReNewpassword = By.xpath("//input[@id='txtrenewpass']");
	    public static By ButtonLuumatkhau = By.xpath("//button[contains(text(),'Lưu mật khẩu mới')]");
	    public static By Thongtinkhoahoc = By.xpath("//a[contains(text(),'Thông tin khóa học')]");
	    public static String webAladaURL = "https://alada.vn/";

	    public static String webPupupURL = "https://demo.guru99.com//popup.php";

	}

