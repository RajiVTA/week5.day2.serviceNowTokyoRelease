package week5.day2.serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrderingMobileTestNG extends BaseClassServiceNow {
	
	@Test
	public void orderingMobile() throws InterruptedException
	{
		//Enter Service catalog in filter navigator and press enter 
				shadow.findElementByXPath("//span[text()='Service Catalog']").click();
				
				// ------ 4. Click on  mobiles -----------------------------------------------------------
				WebElement eleFrame = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(eleFrame);
				
				//driver.findElement(By.xpath("//h2[text()='Mobiles']")).click();
				shadow.findElementByXPath("//h2[contains(text(),'Mobiles')]").click();
				
				driver.switchTo().defaultContent();
				
				// --------5. Select Apple iphone6s --------------------------------------------------------
				
				WebElement eleFrame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(eleFrame1);
				
				shadow.findElementByXPath("//h2[text()='Apple iPhone 13']").click();
				shadow.setImplicitWait(10);
				
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				
			
				// --------6.1 Replacement for a broken ------------------------------------------------
				
				
				WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
				driver.switchTo().frame(eleFrame2);
				
				driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
				
				// ---------6.2 Monthly Allowance ------------------------------------------------
				WebElement monthAllowance = driver.findElement(By.xpath("//select[@name='IO:33494b069747011021983d1e6253af45']"));
				Select sel=new Select(monthAllowance);
				sel.selectByValue("Unlimited");
						
				
				// --------6.3 Update color field to Pink -----------------------------------------------
				driver.findElement(By.xpath("//label[text()='Pink']")).click();
				
			
				// --------6.4  Update storage field to 256GB -------------------------------------------
				
				driver.findElement(By.xpath("//label[text()='256 GB [add $100.00]']")).click();
				
						
				//------- 7. Select  Order now option -------------------------------------------------------
				
				driver.findElement(By.xpath("//button[@name='oi_order_now_button']")).click();
				driver.switchTo().defaultContent();
				
				// -------8.Verify order is placed and copy the request number" ------------------------------
				
				WebElement eleFrame3 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
				driver.switchTo().frame(eleFrame3);
				
				String confirm = driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();
				System.out.println("Confirmation message :"+confirm);
				
				String requestNo = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
				System.out.println("Request Number  :"+requestNo);
				
				shadow.setImplicitWait(5);
				driver.switchTo().defaultContent();
				
	}

}
