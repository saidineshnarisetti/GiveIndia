package GiveIndia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class LaunchBrowser {
	
	public static WebDriver driver=null;
	@Parameters({ "browser" })
	@BeforeTest
	public void opendriver(String browser) {
		System.out.println("browser passed as :- " + browser);
		if(browser.equalsIgnoreCase("Firefox")){
					System.setProperty("webdriver.gecko.driver","/Users/saidinesh/workspace/GiveIndia/drivers/geckodriver");
					driver = new FirefoxDriver();
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Chrome")){
					System.setProperty("webdriver.chrome.driver","/Users/saidinesh/workspace/GiveIndia/drivers/chromedriver");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
		}
	}
	

	@AfterTest
	public void terminateBrowser(){
        driver.close();
	}
}
