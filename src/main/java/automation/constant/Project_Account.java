package automation.constant;

import org.openqa.selenium.By;

public class Project_Account {
	public static String webURL = "https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/events";
	public static By TEXTBOXEMAIL=By.id("email");
	public static By TEXTBOXPASS=By.id("password");
	public static By LOGIN =By.xpath("//button[@type='submit' and text()='Sign in']");
	
	

}
