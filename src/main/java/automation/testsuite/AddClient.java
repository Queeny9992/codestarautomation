package automation.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.pageLocator.ClientPageFactory;

public class AddClient extends CommonBase{
	@BeforeMethod
    public void OpenChrome(){
        driver = initChromeDriver("https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/events");
    }
    @Test
    public void AddClient() throws InterruptedException {
        ClientPageFactory client = new ClientPageFactory(driver);
        client.AddNewClientFunction("1111");
    }
    
}
	


