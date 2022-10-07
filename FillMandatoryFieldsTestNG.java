package week5.day2.serviceNow;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FillMandatoryFieldsTestNG extends BaseClassServiceNow{
	
	@Test
	public void fillMandatoryFields() throws InterruptedException {
		
		// 3.1 -------Enter Knowledge in filter navigator and press enter -------------------

		Thread.sleep(10000);
		WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
		proposal.sendKeys("Knowledge");
		Thread.sleep(15000);
		proposal.sendKeys(Keys.ENTER);
		Thread.sleep(20000);
		
		//4. -----------------Create new article by filling all the fields and click 'Submit'---------
		
		WebElement frameEle2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameEle2);
		
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
	
		driver.switchTo().defaultContent();
		
		// 5.-----------------Select knowledge base as IT and category as IT- java and Click Ok----------
		
		WebElement frameEle3 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameEle3);
		
		driver.findElement(By.xpath("//input[@name='sys_display.kb_knowledge.kb_knowledge_base']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
		Thread.sleep(9000);
		
		driver.switchTo().defaultContent();
		
		// 5.0 ----------------Window Handling and checking the PageTitle--------------------------------------
		 Set<String> windowHandles = driver.getWindowHandles();
		 ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandles); 
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println(driver.getTitle());
			
		// 5.1----------------- Move to 'Knowledge Bases' window and fetch IT value------------------------------
		Thread.sleep(15000);
		WebElement itField = driver.findElement(By.xpath("//table[@id='kb_knowledge_base_table']/tbody/tr/td[3]"));
		itField.click();
		Thread.sleep(8000);
		WebElement itField1 = driver.findElement(By.xpath("//table[@id='kb_knowledge_base_table']/tbody/tr/td[3]/a"));
		itField1.click();
		
		Thread.sleep(20000);
		
		driver.switchTo().window(windowHandlesList.get(0));
			
		Thread.sleep(8000);
		
		// 5.2 ----------------Move to 'Knowledge Bases' window and fetch IT-Java---------------------------------
		
		WebElement frameEle4 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameEle4);
		
		driver.findElement(By.xpath("//input[@name='sys_display.kb_knowledge.kb_category']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();
		Thread.sleep(9000);
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		// 5.3--------------- Move to 'Category Picker' and pick IT-------------------------------------------------
								
		WebElement frameEle5 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameEle5);
		
		Thread.sleep(15000);
		driver.findElement(By.xpath("//table[@id='window.kb_categories_dialog']/tbody/tr[2]/td//div[4]/span[text()='IT']")).click();
		//driver.findElement(By.xpath("//span[text()='IT']")).click();
		Thread.sleep(4000);
		
		// 5.4---------------- Pick Java from 'Category Picker'-----------------------------------------------------
		
		//driver.findElement(By.xpath("//table[@id='window.kb_categories_dialog']//span[@aria-label='Java,level2']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Java,level2']")).click();
		Thread.sleep(6000);
		
		// 5.5 -----------------Click OK button in 'Category Picker'---------------------------------------------------
		
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(4000);
		
		// 5.6 ------------------Enter 'Short Description' ------------------------------------------------------------
		
		driver.findElement(By.xpath("//input[@name='kb_knowledge.short_description']")).sendKeys("Knowledge Transfer session handled");
		Thread.sleep(4000);
		
		// 6.--------------------Click on 'Submit' button------------------------------------------------------------------
		
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		Thread.sleep(6000);


	}

}
