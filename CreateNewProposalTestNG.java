package week5.day2.serviceNow;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateNewProposalTestNG extends BaseClassServiceNow {
	
	@Test
	public void createNewProposal() throws InterruptedException
	{
		
		// 3.1 -------Enter Proposal in filter navigator and press enter -------------------

				Thread.sleep(10000);
				WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
				proposal.sendKeys("Proposals");
				Thread.sleep(5000);
				proposal.sendKeys(Keys.ENTER);
				Thread.sleep(20000);
				
				// 4.---------- Click- new  and  fill mandatory fields and click 'Submit' Button.---------------------------
			
				WebElement frameEle2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(frameEle2);
				
				driver.findElement(By.xpath("//button[text()='New']")).click();
			
				driver.switchTo().defaultContent();
				
				// 4.1 ----------Template Description------------------------------------------------------------------------
				
				WebElement frame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(frame1);
				
				String proposalNumber = driver.findElement(By.xpath("//input[@name='sys_original.std_change_proposal.number']")).getAttribute("value");
				System.out.println("Proposal Number :"+proposalNumber);
						
				driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Testing Proposal");
				Thread.sleep(5000);
				
				// 5.------------ click 'Submit' Button.-----------------------------------------------------------------------
				
				driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();   
			
				driver.switchTo().defaultContent();  
				
				// 6. ------------Verify the successful creation of new Proposal" ----------------------------------------------
				
				Thread.sleep(5000);
				WebElement frame2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(frame2);
				
				WebElement tableName = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']"));
				
				// 6.1 -----------Fetching the rows and finding row count-----------------------------------------------
				List<WebElement> row = tableName.findElements(By.tagName("tr"));
				int rowSize = row.size();
				System.out.println("Row count :"+rowSize);
			
				// 6.2 -----------Fetching the columns and finding Column count------------------------------------------
				List<WebElement> column = row.get(rowSize-1).findElements(By.tagName("td"));
				int colSize = column.size();
				System.out.println("Column count : "+colSize);
				
				// 6.3 ----------Create an ArrayList to store the Proposals------------------------------------------------
				List<String> proposalList = new ArrayList<String>();

				// 6.4 ----------Verify the newly added Proposal in our ArrayList-----------------------------------------	
					for(int j=0;j<colSize;j++)
					{
						{
							proposalList.add(column.get(j).getText());
						}
						
					}
					for (String string : proposalList) {
						if(string.equals(proposalNumber))
						{
							System.out.println("Proposal number newly added :"+string);
							System.out.println("Proposal is Successfully created");
						}
						
					}
					driver.switchTo().defaultContent();
	}

}
