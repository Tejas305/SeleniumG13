package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {

	@FindBy(xpath="//input[@aria-label='Email address or phone number']")
	private WebElement emailOrPhoneNo ;
	
	@FindBy(xpath="//input[@aria-label='Password']")
	private WebElement password ;
	
	@FindBy(xpath="//button[@id='u_0_5_OS']")
	private WebElement loginButton ;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgotPasswordLink ;
	
	@FindBy(xpath="//a[@id='u_0_0_1H']")
	private WebElement createNewAcountButton ;
	
	public LoginOrSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void sendEmailOrPhoneNo() {
		emailOrPhoneNo.sendKeys("hfhtfhg");
	}
		
	public void sendPassword() {
		password.sendKeys("12344");
	}
			
    public void ClickOnLogInButton() {
		loginButton.click();
    }
    
    public void ClickOnForgotPassword() {
    	forgotPasswordLink.click();
    }
    
    public void openSignUpForm() {
    	createNewAcountButton.click();
    }
}