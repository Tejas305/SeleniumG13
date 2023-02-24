package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewAccountPage {


	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createNewAcountButton ;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName ;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement Surname ;
	
	@FindBy(xpath="//input[@aria-label='Mobile number or email address']")
	private WebElement mobileNumberOrEmail ;
	
	@FindBy(xpath="//input[@aria-label='Re-enter email address']")
	private WebElement reenteremail ;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement newPassword ;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement dayOfBirth ;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement monthOfBirth ;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement yearOfBirth ;
	
	@FindBy(xpath="//label[text()='Female']")
	private WebElement genderFemale ;
	
	@FindBy(xpath="//label[text()='Custom']")
	private WebElement clickOnCustomRadioButton  ;
	
	@FindBy(xpath="(//button[text()='Sign Up'])[1]")
	private WebElement clickOnSignUpPage  ;
	
	@FindBy(xpath="(//a[text()='Privacy Policy'])[2]")
	private WebElement privacyPolicy  ;
	
	@FindBy(xpath="//a[text()='Cookies Policy']")
	private WebElement cookiesPolicy  ;
	
	@FindBy(xpath="(//a[text()='Terms'])[2]")
	private WebElement termsLink ;
	
	private WebDriver driver;
	private Actions action;
	private WebDriverWait wait;
	//private JavascriptExecutor javascriptExecutor ;
	
	public CreateNewAccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
		action = new Actions(this.driver);
		//or action = new Actions(driver);
		wait = new WebDriverWait(driver,20);
		//javascriptExecutor =(JavascriptExecutor)driver;
	}
	
	public void clickCreateNewAccountButton() {
		createNewAcountButton.click();		
	}
	
	public void sendFirstName() {
		firstName.sendKeys("Dipali");	
	}
	
	public void sendSurName() {
		Surname.sendKeys("Jagtap");	
	}
	
	public void sendMobileOrEmail() {
		mobileNumberOrEmail.sendKeys("D123456@gmail.com");	
	}
	
	public void sendReEnterEmail() {
		reenteremail.sendKeys("D123456@gmail.com");	
	}
	
	public void sendNewPassword() {
		newPassword.sendKeys("Dipali@123");	
	}
	
    public void selectDay() {
		Select s = new Select(dayOfBirth);
		s.selectByValue("18");
	}
	
	public void selectMonth() {
		Select s = new Select(monthOfBirth);
		s.selectByVisibleText("Aug");
	}
	
	public void selectYear() {
		Select s = new Select(yearOfBirth);
		s.selectByValue("2000");
	}
	
	public void clickOnFemaleRadioButton() {
		//Actions act = new Actions(driver);
		action.moveToElement(genderFemale).click().build().perform();
	}
	
//	public void clickOnCustomRadioButton() {
//		//Actions act = new Actions(driver);
//		action.moveToElement(clickOnCustomRadioButton).click().build().perform();
//	}
	
	public void clickTerms() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(termsLink));
		termsLink.click();
	}
	
	public void clickPrivacyPolicy() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(privacyPolicy));
		privacyPolicy.click();
	}
	
	public void clickCookiesPolicy() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(cookiesPolicy));
		cookiesPolicy.click();
	}
	
	public void clickOnSubmitButton() {
		//Actions act = new Actions(driver);
		action.moveToElement(clickOnSignUpPage).click().build().perform();
	}
}

