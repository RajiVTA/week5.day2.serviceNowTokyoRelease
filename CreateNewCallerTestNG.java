package week5.day2.serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateNewCallerTestNG extends BaseClassServiceNow {
	
	@Test
	public void createNewCaller() throws InterruptedException
	{
		// 3.1 -------Enter Callers in filter navigator and press enter -------------------

		Thread.sleep(10000);
		WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
		proposal.sendKeys("Callers");
		Thread.sleep(15000);
		proposal.sendKeys(Keys.ENTER);
		Thread.sleep(20000);
		
		//4. -----------------Create new Caller by filling all the fields and click 'Submit'---------
		
		WebElement frameEle2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameEle2);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
	
		driver.switchTo().defaultContent();
		
		WebElement frame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		
		// 4.1 --------------Filling all the fields --------------------------------------------------------
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Akshaya"); //FirstName
		
		String lName="Ravi";
		WebElement lastName = driver.findElement(By.xpath("//input[@name='sys_user.last_name']"));
		lastName.sendKeys("Ravi"); //LastName
		
		
		driver.findElement(By.xpath("//input[@name='sys_user.title']")).sendKeys("Title");     //Title
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("abc@gmail.com");  //Email
		driver.findElement(By.xpath("//input[@name='sys_user.phone']")).sendKeys("121212");  //Business Phone
		driver.findElement(By.xpath("//input[@name='sys_user.mobile_phone']")).sendKeys("555555");  //Mobile
		Thread.sleep(8000);
		
		//driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default']")).click();  //Submit button
		
		// 4.2 --------------Click 'Submit' button-----------------------------------------------------------
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();  // Submit button
		
		driver.switchTo().defaultContent();   // Switch back to parent
		
		// 5. ---------------Search by LastName --------------------------------------------------------------
		
		WebElement frame3 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame3);
		
		// 5.1---------------Verify the newly created Caller ------------------------------------------------------
									
		WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='outputmsg_text']"));
		String confirm = confirmationMessage.getText();
		
		// 5.2 --------------Check whether the confirmation message is displayed for the New Caller---------------
		if(confirm.contains(lName))
		{
			System.out.println("New record for " +lName  + " is successfully created");
		}
		else
		{
			System.out.println("New record for " +lName  + " is not successfully created");
		}
		
		// 5.3 -------------- Select 'Last Name' as search field---------------------------------------------------
		WebElement forText = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select sel=new Select(forText);
		sel.selectByValue("last_name");
		
		// 5.4----------------Enter LastName of the newly created Caller------------------------------------------
		Thread.sleep(5000);
		WebElement searchEle = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchEle.sendKeys(lName);
		Thread.sleep(4000);
		searchEle.sendKeys(Keys.ENTER);
		
		// 5.5 --------------Fetch the LastName from the table displayed and verify the newly created caller -------
		
		WebElement resultData = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[2]/td[3]"));
		String result = resultData.getText();
		if(lName.equals(result))
		{
			System.out.println("New caller creation is verified");
		}
		else
		{
			System.out.println("New caller creation is not verified");
		}

		driver.switchTo().defaultContent();
	}

}
