package automation.common;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static automation.common.TestLogger.*;

public class CommonBase {

	public WebDriver driver;
    public int initWaitTime = 40;
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

		public WebDriver initFirefoxDriver(String URL) 
		{
		System.out.println("Launching Firefox browser...");
		System.setProperty("webdriver.firefox.driver", 
		System.getProperty("user.dir") + "/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.get(URL);
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

    public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
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
    private WebDriver initChromeDriver() {
		System.out.println("Launching Chrome browser...");
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", 
		System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser...");
		System.setProperty("webdriver.firefox.driver", 
		System.getProperty("user.dir") + "/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initEdgeDriver() {
		System.out.println("Launching Edge browser...");
		System.setProperty("webdriver.edge.driver",
		System.getProperty("user.dir") + "/driver/msedgedriver");
		// Creating an object of EdgeDriver
	    driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver initEdgeDriver(String URL) {
		System.out.println("Launching Edge browser...");
		System.setProperty("webdriver.edge.driver",
		System.getProperty("user.dir") + "/driver/msedgedriver");
		// Creating an object of EdgeDriver
	    driver = new EdgeDriver();
	    driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
		case "edge":
			driver = initEdgeDriver();
			break;
		default:
			System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
			driver = initChromeDriver();
		}
		return driver;
	}
	

}




