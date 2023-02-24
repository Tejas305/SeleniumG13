package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomclasses.CreateNewAccountPage;
import pomclasses.ForgotPasswordPage;
import pomclasses.LoginOrSignUpPage;

public class Test {

	public static void main(String[]args) {
	
	System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driverTest =new ChromeDriver();
	driverTest.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driverTest.manage().window().maximize();
	
	driverTest.get("https://www.facebook.com/");
	
	LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driverTest);
//	
//	loginOrSignUpPage.sendEmailOrPhoneNo();
//	loginOrSignUpPage.sendPassword();
  // loginOrSignUpPage.ClickOnLogInButton();
//	loginOrSignUpPage.ClickOnForgotPassword();
//	
//	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverTest);
//	forgotPasswordPage.sendEmailOrMobile();
//	forgotPasswordPage.getForgotWindowMessage();
//	forgotPasswordPage.clickOnSearch();
	
	CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driverTest);
	createNewAccountPage.clickCreateNewAccountButton();
	createNewAccountPage.sendFirstName();
	createNewAccountPage.sendSurName();
	createNewAccountPage.sendMobileOrEmail();
	createNewAccountPage.sendReEnterEmail();
	createNewAccountPage.sendNewPassword();
	createNewAccountPage.selectDay();
	createNewAccountPage.selectMonth();
	createNewAccountPage.selectYear();
	createNewAccountPage.clickOnFemaleRadioButton();
	//createNewAccountPage.clickOnCustomRadioButton();
	createNewAccountPage.clickTerms();
	createNewAccountPage.clickPrivacyPolicy();
	createNewAccountPage.clickCookiesPolicy();
	createNewAccountPage.clickOnSubmitButton();

}
}
