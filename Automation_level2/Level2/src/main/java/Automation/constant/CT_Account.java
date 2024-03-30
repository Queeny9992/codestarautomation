package Automation.constant;

import org.openqa.selenium.By;


public class CT_Account {
	
	
	//correct infor
	public static By TEXTBOX_EMAIL = By.id("email");
	public static By TEXTBOX_PASS = By.id("password");
	public static By BTN_LOGIN = By.xpath("//button[@type='submit' and text()='Sign in']");
	public static By MAIN_PAGE = By.xpath("//h4[text()='Dashboard']");

	
	public static String webURL = "https://rise.fairsketch.com/signin";	
	public static final String USER_NAME ="admin@demo.com";
	public static final String PassWord ="riseDemo";
	
	//public static final String 

	//wrong infor
	public static final String Wrong_email = "Admin@hahaha";
	public static final String Wrong_pass = "wrongpass";
	public static By LOGIN_FAIL = By.xpath("//div[@role='alert']");
	
}
	