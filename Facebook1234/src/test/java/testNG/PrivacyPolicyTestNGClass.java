package testNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pomclasses.CreateNewAccountPage;

public class PrivacyPolicyTestNGClass {

	public class CreateNewAccAndForgotPassNGClass {
		WebDriver driver;
		
		@BeforeSuite
		public void beforesuite()
		{
			System.out.println("Beforesuite");
		}
		
		@BeforeTest
		public void beforeTest()
		{
			System.out.println("BeforeTest");
		}
		
		@BeforeClass
		public void launchBrowser()
		{
			System.setProperty("webdriver.chrome.driver","F:\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		
		    driver =new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Before Class");
			
		}
		
		@BeforeMethod
		public void goTocraeteNewAccount()
		{
			driver.get("https://www.facebook.com");
			System.out.println("BeforeMethod");
			CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
			 createNewAccountPage.clickCreateNewAccountButton();
		}
		
		@Test
		public void goToPrivacyPolicy456()
		{
			System.out.println("Test-2");
			CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
			createNewAccountPage.clickPrivacyPolicy();
			ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(2));
			String Url= driver.getCurrentUrl();
			System.out.println(Url);
			if(Url.equals("https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
		}
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("AfterMethod");
		}

		@AfterClass
		public void afterclass()
		{
			//driver.quit();
			System.out.println("AfterClass");
		}
		
		@AfterTest
		public void afterTest()
		{
			System.out.println("AfterTest");
		}
		
		@AfterSuite
		public void Aftersuite()
		{
			System.out.println("Aftersuite");
		}
		
		
	}

}


