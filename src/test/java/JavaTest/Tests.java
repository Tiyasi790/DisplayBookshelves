package JavaTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import MainCode.Elements;
import static Read.UrlRead.getUrl;

@SuppressWarnings("deprecation")
public class Tests {
	
	public static WebDriver driver;
	public static ExtentTest logger;
	String reportName = System.currentTimeMillis() + ".html";
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Report/automation"+ reportName);
	ExtentReports report = new ExtentReports();

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser){
		System.out.println("Browser name is : "+browser);
		
		if (browser.equalsIgnoreCase("Chrome")) {
			String driverLocation = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			String driverLocation = System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver",  driverLocation);
			driver = new EdgeDriver();
		}
	}
	
	@BeforeTest
	public void beforeTest() {
		report.attachReporter(htmlReporter);
	}
	
	@Test(priority = 0)
    public void Test1() throws InterruptedException, IOException {
		logger = report.createTest("Test1 - Test to validate opening url and maximizing browser");
		logger.log(Status.INFO, "Starting the test scenario 1");
		driver.get(getUrl());
		driver.manage().window().maximize();
		logger.info("This will open the Website");
    }
	
	@Test(priority = 1)
	    public void Test2() throws Exception {
		logger= report.createTest("Test2 - Test to validate opening bookshelves element");
	    logger.log(Status.INFO, "Starting the test scenario 2");
        Elements elements = new Elements(driver);
        logger.info("This will open the bookshelves element");
		elements.openBookShelves();
		elements.screenshot();
	}

	@Test(priority = 2)
	public void Test3() throws InterruptedException{
		logger=report.createTest("Test3 - Test to validate functionality of Popup closing");
	    logger.log(Status.INFO, "Starting the test scenario 3");
		Elements elements = new Elements(driver);
		logger.info("This will close the popup window");
		elements.closePopup();
		elements.screenshot();
	}
	
	@Test(priority = 3)
	public void Test4() throws Exception{
		logger=report.createTest("Test4 - Test to validate selecting the filter of 'open' type bookshelf ");
	    logger.log(Status.INFO, "Starting the test scenario 4");
		Elements elements = new Elements(driver);
	    logger.info("This will select the type of bookshelves");
		elements.storageType();
		elements.screenshot();
	}
	
	@Test(priority = 4)
	public void Test5() throws Exception{
		logger=report.createTest("Test5 - Test to validate locating the price slider");
	    logger.log(Status.INFO, "Starting the test scenario 5");
		Elements elements = new Elements(driver);
	    logger.info("This will locate the price slider element and a set a limit to ₹15000");
		elements.slider();
		elements.screenshot();
	}
	
	@Test(priority = 5)
	public void Test6() throws Exception{
		logger=report.createTest("Test6 - Test to validate exclude out of stock checkbox is working or not");
		logger.log(Status.INFO, "Starting the test scenario 6");
		Elements elements = new Elements(driver);
		logger.info("This will add filter for bookshelves which are out of stock and validate it");
		elements.excludeCheckbox();
		elements.screenshot();
	}
	
	@Test(priority = 6)
	public void Test7() throws InterruptedException{
		logger=report.createTest("Test7 - Test to validate all datas are being printed or not");
		logger.log(Status.INFO, "Starting the test scenario 7");
		Elements elements = new Elements(driver);
		logger.info("This will locate and print name and price of 1st three bookshelves");
		elements.printshelves();
	}
	
	@Test(priority = 7)
	public void Test8() throws Exception{
		logger=report.createTest("Test8 - Test to validate locating study chair element and priniting those");
		logger.log(Status.INFO, "Starting the test scenario 8");
		Elements elements = new Elements(driver);
		logger.info("This will locate the study chair element and validate it");
		elements.displayChair();
		elements.screenshot();
	}

	@Test(priority = 8)
	public void Test9() throws Exception{
		logger=report.createTest("Test9 - Test to validate all the required data are being printed or not");
		logger.log(Status.INFO, "Starting the test scenario 9");
		Elements elements = new Elements(driver);
		logger.info("This will locate the study chair element and validate it");
		elements.printchairs();
	}
	
	@Test(priority = 9)
	public void Test10() throws Exception{
		logger=report.createTest("Test10 - Test to validate locating the collections menu");
		logger.log(Status.INFO, "Starting the test scenario 10");
		Elements elements = new Elements(driver);
		logger.info("This will locate the Collections menu and validate it");
		elements.collections();
		elements.screenshot();
	}
	
	@Test(priority = 10)
	public void Test11() throws Exception{
		logger=report.createTest("Test11 - Test to validate all sub products under all furnitures are being printed or not");
		logger.log(Status.INFO, "Starting the test scenario 11");
		Elements elements = new Elements(driver);
		logger.info("This will print all elements under all furnitures and print all those sub products");
		elements.Beingprint();
    }
	
	@Test(priority = 11)
	public void Test12() throws Exception{
		logger=report.createTest("Test12 - Test to validate locating the giftcard element");
		logger.log(Status.INFO, "Starting the test scenario 12");
		Elements elements = new Elements(driver);
		logger.info("This will locate the gift card element and validate it");
		elements.giftcards();
		elements.screenshot();
	}
	
	@Test(priority = 12)
	public void Test13() throws Exception{
		logger=report.createTest("Test13 - Test to validate filling up the custom form");
		logger.log(Status.INFO, "Starting the test scenario 13");
		Elements elements = new Elements(driver);
		logger.info("This will fillup the custom form input and validate it");
		elements.customForm();
		elements.screenshot();
    }
	
	@Test(priority = 13)
	public void Test14() throws Exception{
		logger=report.createTest("Test14 - Test to validate filling up the receipient form ");
		logger.log(Status.INFO, "Starting the test scenario 14");
		Elements elements = new Elements(driver);
		logger.info("This will fillup the receiver data from and validate it");
		elements.recForm();
    }
	
	@Test(priority = 14)
	public void Test15() throws Exception{
		logger=report.createTest("Test15 - Test to validate filling up the sender form ");
		logger.log(Status.INFO, "Starting the test scenario 15");
		Elements elements = new Elements(driver);
		logger.info("This will fillup the sender data from and validate it");
		elements.senderForm();
		elements.screenshot();
    }
	
	@AfterMethod
     public void setTestResult(ITestResult result) throws IOException {

          if (result.getStatus() == ITestResult.FAILURE) {
              logger.log(Status.FAIL, result.getName());
              logger.log(Status.FAIL,result.getThrowable());
          } else if (result.getStatus() == ITestResult.SUCCESS) {
              logger.log(Status.PASS, result.getName());
          } else if (result.getStatus() == ITestResult.SKIP) {
              logger.skip("Test Case : " + result.getName() + " has been skipped");
          }
      }
	@AfterTest
	public void closeBrowser() {
		report.flush();
		driver.quit();
	}

}
