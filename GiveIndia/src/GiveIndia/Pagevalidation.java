package GiveIndia;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GiveIndia.LaunchBrowser;

public class Pagevalidation extends LaunchBrowser {

	@Test(priority=1)
	 public void TitleValidation() {
		String actTitle = driver.getTitle();
		String expTitle = "Selenium - Wikipedia";
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Validating Title");
	}
	@Test(priority=2)
	 public void ExternallinksValidation() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"toc\"]/ul/li[10]/a/span[2]")).click();
		String actExtUrl = driver.getCurrentUrl();
		String expExtUrl = "https://en.wikipedia.org/wiki/Selenium#External_links";
		Assert.assertEquals(actExtUrl, expExtUrl);
		Reporter.log("Validating Externallinks");
	}
	@Test(priority=3)
	 public void OxygenlinksValidation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div[19]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[7]/a")).click();
		Thread.sleep(3000);
		String OxygenActtitle = driver.getTitle();
		String OxygenExttitle = "Oxygen - Wikipedia";
		Assert.assertEquals(OxygenActtitle, OxygenExttitle);
		Reporter.log("Validating Oxygen Externallinks");
	}
	
	@Test(priority=4)
	 public void Oxygenlinksfeaturedarticle() throws InterruptedException, IOException {
		if(driver.findElement(By.xpath("//*[@id=\"mw-indicator-featured-star\"]/a")).isDisplayed()) {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("/Users/saidinesh/workspace/GiveIndia/Screenshots/featuredarticlestar.jpg"));
			Reporter.log(" Validating featured article");
		}
	}

}
