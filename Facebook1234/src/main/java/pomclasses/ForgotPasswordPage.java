package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	@FindBy(xpath="//div[@class='_9nq2 marginBottom16px']")
	private WebElement forgotGotTextMessage ;
	
	@FindBy(xpath="//input[@aria-label='Email address or mobile number']")
	private WebElement emailOrMobile ;
	
	@FindBy(xpath="//button[@id='did_submit']")
	private WebElement search ;
	
	@FindBy(xpath="//a[@href='/login.php']")
	private WebElement cancel ;
	
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getForgotWindowMessage() {
		String text = forgotGotTextMessage.getText();
		System.out.println(text);
	}
	
	public void sendEmailOrMobile() {
		emailOrMobile.sendKeys("123456");
	}
	
	public void clickOnCancel() {
		cancel.click();
	}
	
	public void clickOnSearch() {
		search.click();
	}
}



