package testNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomclasses.CreateNewAccountPage;
import pomclasses.LoginOrSignUpPage;

public class PrivacyTermsCookies {

	WebDriver driver;
	CreateNewAccountPage createNewAccountPage;
	
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver","F:\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");
	    driver =new ChromeDriver();
		}
		
		if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","F:\\selenium\\geckodriver-v0.32.1-win32\\geckodriver.exe");
		    driver =new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Before Class");
		
	}
	
	@BeforeClass
	public void createPOMObjects() {
		 createNewAccountPage = new CreateNewAccountPage(driver);
		 
	}
	
	
	@BeforeMethod
	public void goTocraeteNewAccount()
	{
		driver.get("https://www.facebook.com");
		System.out.println("BeforeMethod");
		 //LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		createNewAccountPage.clickCreateNewAccountButton();
	}
	
	@Test(priority=1)
	public void goToTermsButton()
	{
		System.out.println("Test-1");
		//CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
		createNewAccountPage.clickTerms();
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String Url= driver.getCurrentUrl();
		System.out.println(Url);
		if(Url.equals("https://www.facebook.com/legal/terms/update"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}

	@Test(priority=2)
	public void goToPrivacyPolicy()
	{
		System.out.println("Test-2");
		//CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
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
	
	@Test(priority=3)
	public void goToCookiesPolicy()
	{
		System.out.println("Test-3");
		//CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
		createNewAccountPage.clickCookiesPolicy();
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(3));
		String Url= driver.getCurrentUrl();
		System.out.println(Url);
		if(Url.equals("https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0"))
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
	public void clearPOMObjects(){
		createNewAccountPage=null;
		
	}
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver =null;
		System.gc();
	}
}

//<class name="testNG.PrivacyPolicyTestNGClass"/>
//<class name="testNG.CreateNewAccAndForgotPassNGClass"/>
//<class name="testNG.TermsAndCookiesTestNGClass"/>

