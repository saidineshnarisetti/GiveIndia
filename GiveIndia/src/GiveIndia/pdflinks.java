package GiveIndia;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pdflinks extends LaunchBrowser{



	@Test(priority=5)
	public void GetPdfUrl(){
	WebElement Refrance =  driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div[47]"));
	List<WebElement> allLinks = Refrance.findElements(By.tagName("a"));
	List<String> pdfURLList = new ArrayList<String>();
		for(WebElement link:allLinks){
			String pdfulrs= link.getAttribute("href");
			if(pdfulrs.contains((".pdf"))) {
				//System.out.println(pdfulrs);
				pdfURLList.add(pdfulrs);
			}
		}
		System.out.println("Number of PDF links: "+pdfURLList.size());
	}
	@Test(priority=6)
	public void search() throws InterruptedException{
		driver.findElement(By.id("searchInput")).sendKeys("pluto");
		String ActSearchresults = driver.findElement(By.xpath("/html/body/div[7]/div/a[2]")).getText();
		Thread.sleep(3000);
		String ExpSearchresults = "Plutonium";
		Assert.assertEquals(ActSearchresults, ExpSearchresults);
	}
}
