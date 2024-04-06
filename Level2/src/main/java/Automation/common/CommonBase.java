package Automation.common;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.constant.CT_Account;

//import static automation.common.TestLogger.*;

public class CommonBase {

	public static WebDriver driver;
    public Duration initWaitTime = Duration.ofSeconds(4);
    public WebDriver setupDriver(String browser) {
    	Automation.constant.CT_Account ct= new Automation.constant.CT_Account();
    	String url = ct.webURL ;
    	switch(browser){
    	case "chrome":
    		return initChromeDriver(url);
    	case "safari":
    		return initSafariDriver(url);
    	default :
    		return initChromeDriver(url);
    	}
    }
    public WebDriver initChromeDriver(String URL)
    {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",
        System.getProperty("user.dir") + "/driver/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return driver;
    }
    private WebDriver initSafariDriver(String URL) {
    	SafariOptions option = new SafariOptions();
    	System.setProperty("webdriver.safari.driver", System.getProperty("user.dir")+"/driver/safaridriver");
    	driver = new SafariDriver(option);
    	driver.manage().window().maximize();
    	driver.get(URL);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
    	return driver;
    }

    public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) 
    {
        WebElement element = driver.findElement(inputElement);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            inputTextJavaScriptInnerHTML(inputElement, companyName);
        }
    }

    public void inputTextJavaScriptValue(By locator, String value) {
        WebElement element = getElementPresentDOM(locator);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            inputTextJavaScriptValue(locator, value);
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = getElementPresentDOM(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getElementPresentDOM(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public boolean isElementPresent(By locator)
    {
    	try {
        WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
        wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
        return getElementPresentDOM(locator).isDisplayed();
    	}catch (org.openqa.selenium.NoSuchElementException e) {
    		return false;
    	}catch (org.openqa.selenium.TimeoutException e2) {
    		return false;
    	}
    	
    	
    }
    public void click(By locator)
    {
        WebElement element = getElementPresentDOM(locator);
        WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public void type(By locator, String value)
    {
        WebElement element = getElementPresentDOM(locator);
        element.sendKeys(value);
    }
    /**
     * pause driver in timeInMillis
     *
     * @param timeInMillis
     */
    public void pause(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * get absolute path of file
     *
     * @param relativeFilePath
     * @return
     */
    public String getAbsoluteFilePath(String relativeFilePath) {
String curDir = System.getProperty("user.dir");
        String absolutePath = curDir + relativeFilePath;
        return absolutePath;
    }

    public void quitDriver(WebDriver dr) {
        if (dr.toString().contains("null")) {
            System.out.print("All Browser windows are closed ");
        } else {
            dr.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
            dr.manage().deleteAllCookies();
            dr.close();
        }
    }
    
    //Lấy ngày tháng năm hiện tại
    public String getCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		// calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentdateTime = df.format(calendar.getTime());
		System.out.println("Current day - month - year: " + currentdateTime);
		return currentdateTime;
	}
    
    public String getCurrentDateTime1() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentdateTime = df.format(calendar.getTime());
		System.out.println("Current year - month - day: " + currentdateTime);
		return currentdateTime;
	}
    
    //Lấy 7 ngày tiếp theo từ ngày hiện tại
    public String getNext7DaysOfCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 7);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		return next7Days;
		
    }
    
    public String getNext7DaysOfCurrentDateTime1() {
  		Calendar calendar = Calendar.getInstance();
  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 7);
  		String next7Days = df.format(calendar.getTime());
  		System.out.println("Next 7 days from current day: " + next7Days);
  		return next7Days;
  		
      }
    
    public String getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
		String currentMonth = df.format(calendar.getTime());
		System.out.println("currentMonthAsString: " + currentMonth);
		return currentMonth;
    }
		
}
    



