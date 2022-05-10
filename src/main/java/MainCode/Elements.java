package MainCode;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Read.ExcelRead;
import Write.ExcelWrite;

public class Elements {
	
	public static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");

	public Elements(WebDriver driver) {
		Elements.driver = driver;
	}

	 //opening bookshelf link
		public void openBookShelves() {
			try {
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait1.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//*[@id=\"content\"]/div[3]/div/div[3]/a[4]"))).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//closing pop up page
	public void closePopup() {
			try {
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait2.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//a[@class='close-reveal-modal hide-mobile']"))).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	//select the type of bookshelf
	public void storageType(){
		try {
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(40));
			WebElement element1 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]")));
			Actions action = new Actions(driver);
			action.moveToElement(element1);
			action.build().perform();
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("filters_storage_type_Open"))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	//select the price range of bookshelf
	public void slider() throws InterruptedException {
		try {
			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(40));
			WebElement element2 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]")));
			Actions action = new Actions(driver);
			action.moveToElement(element2);
			Thread.sleep(2000);
			action.build().perform();

			Actions move = new Actions(driver);
			WebElement lower = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-lower']"));
			move.dragAndDropBy(lower, 0, 0).click();
			move.build().perform();
   
			WebElement upper = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
			move.dragAndDropBy(upper, -202, 0).click();
			move.build().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//excluding all the out of stock items
	public void excludeCheckbox() throws InterruptedException{
		try {
			WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait5.until(ExpectedConditions.elementToBeClickable(By.id("filters_availability_In_Stock_Only"))).click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//printinf and storing the 1st 3 bookshelves form the search result
	public void printshelves() {
		try {
			List<WebElement> shelfname = driver.findElements(By.xpath("//span[@class='name']"));
			List<WebElement> shelfprice = driver.findElements(By.xpath("//div[@class='price-number']/span[1]"));

			String[] sname = new String[3];
			String[] sprice = new String[3];

			for (int i = 0; i < 3; i++) {
				sname[i] = shelfname.get(i).getText();
				sprice[i] = shelfprice.get(i).getText();
				System.out.print(shelfname.get(i).getText() + " ");
				System.out.println(shelfprice.get(i).getText());
				ExcelWrite.output(sname, sprice);
			}
			 for(int j=0; j<=46; j++){   
				   System.out.print("=");   
				   }
				   System.out.println("\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//selecting study chairs from study 
	public void displayChair(){
		try {
			WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));
			
			wait6.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//span[contains(@class,'topnav_itemname') and contains(text(),'Study')]"))).click();
			wait6.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[@href='/study-chair?src=g_topnav_study_study-chairs_study-chairs']//span[contains(text(),'Study Chairs')]"))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Selecting !st 3 study chairs with whighest recommendation
	public void printchairs() {
		
    	try {
			List<WebElement> chairname = driver.findElements(By.xpath("//span[@class='name']"));
			List<WebElement> chairprice = driver.findElements(By.xpath("//div[@class='price-number']/span[1]"));

			String[] cname = new String[3];
			String[] cprice = new String[3];

			for (int i = 0; i < 3; i++) {
				cname[i] = chairname.get(i).getText();
				cprice[i] = chairprice.get(i).getText();
				System.out.print(chairname.get(i).getText() + " ");
				System.out.println(chairprice.get(i).getText());
				ExcelWrite.output1(cname,cprice);
			}
		    for(int a = 0; a < cprice.length; a++) {
			for (int b = a+1; b < cprice.length; b++) {
		        if (cprice[a].equals(cprice[b])) {
		            System.out.println("\n"
		            		+ "***The price of "+cname[a]+" is same as "+cname[b]+"***");
		        }
		     }
		  }
			 for(int j=0; j<=46; j++){   
				   System.out.print("=");   
				   }
				   System.out.println("\n");
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//clicking on 'collections' and finding element 'All furniture'
	public void collections() throws InterruptedException {
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'topnav_itemname') and contains(text(),'Collections')]"))).click();
			WebElement element3 = driver.findElement(By.xpath("//a[normalize-space()='All Furniture']"));
			wait7.until(ExpectedConditions.visibilityOf(element3));
			Actions select = new Actions(driver);
			select.moveToElement(element3).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //navigating toall furniture section and prnting all the sub products
	public void Beingprint(){
		
		try {
			List<WebElement> subMenuItems = driver.findElements(By.xpath("//a[contains(text(),'All Furniture')]/parent::*/following-sibling::ul/li"));

					String prodname[] = new String[20];
					for (int i = 0; i < 6; i++) {
						prodname[i] = subMenuItems.get(i).getText();
						System.out.println(prodname[i]);
				        ExcelWrite.output2(prodname);
					}
					   for(int j=0; j<=46; j++){   
					   System.out.print("=");   
					   }
					   System.out.println("\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//locating the gift card link text element 
	public void giftcards() throws InterruptedException {
		try {
			WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait8.until(ExpectedConditions.elementToBeClickable(By.linkText("Gift Cards"))).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,750)", "");
			
			wait8.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//img[@alt='Birthday/Anniversary Gift Card by Urban Ladder']"))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
      	}
		//Custom gift card
	public void customForm(){
		try {
			WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));	
			wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'₹ 10000')]"))).click();
			
			Select element4 = new Select(wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[1]"))));
			element4.selectByIndex(2);
			Select element5 = new Select(wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[2]"))));
			element5.selectByIndex(15);
			wait9.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button"))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	    //filling recipient form 
		public void recForm() throws InterruptedException, IOException{
			String[] feedData1 = ExcelRead.readrecData("input.xlsx");
			
			WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(40));
			
			wait10.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='ip_4036288348']"))).sendKeys(feedData1[0]);
			
			wait10.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='ip_137656023']"))).sendKeys(feedData1[1]);
		}
		public void senderForm() throws InterruptedException, IOException{
			String[] feedData2 = ExcelRead.readsendData("input.xlsx");
			
			WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait11.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("ip_1082986083"))).sendKeys(feedData2[0]);
			
			wait11.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("ip_4081352456"))).sendKeys(feedData2[1]);
			
			wait11.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("ip_2121573464"))).sendKeys(feedData2[2]);
			
			wait11.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//button[@type='submit']"))).click();
			
			if(driver.findElement(By.id("ip_4081352456")).getAttribute("validationMessage")!=null)
			{
				String msg = driver.findElement(By.id("ip_4081352456")).getAttribute("validationMessage");
				
				System.out.println("Error Message:");
				System.out.println(msg+"\n");

				 for(int j=0; j<=46; j++){   
					   System.out.print("*");   
					   }
					   System.out.println("\n");
	        }
		}	
		public void screenshot() {
			TakesScreenshot ts = (TakesScreenshot) driver;
			try {
				File source = ts.getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date(0));

				FileUtils.copyFile(source, new File(userDir + "\\Screenshots\\Screen"+timestamp+".png"));

			} catch (Exception e) {
				System.out.println("\n"
						+ "The Screenshot is not taken \n");
				for(int j=0; j<=46; j++)   
				{   
				System.out.print("*");   
				}   

			}
		}

}
