package gitHubTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.PageObject;
import utils.PageObjectExtended;

public class LoginPage extends PageObjectExtended {

	@FindBy(id="login_field")
	private WebElement login;
	
	@FindBy(id="password")
	private WebElement password;


	
	@FindBy(name="commit")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
//
//	public MainPage login(String user, String pass){
//		login.sendKeys(user);
//		password.sendKeys(pass);
//
//		loginButton.click();
//		return new MainPage(driver);
//	}

	public MainPage login(String user, String pass){
		sendTextToWebElement(login, user);
		sendTextToWebElement(password, pass);
    	clickOnWebElement(loginButton);

		return new MainPage(driver);
	}
}