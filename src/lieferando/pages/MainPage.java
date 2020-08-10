 package lieferando.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.PageObject;

public class MainPage extends PageObject{
	
	@FindBy(id="imysearchstring")
	private WebElement search;
	
	@FindBy(id="submit_deliveryarea")
	private WebElement submit;
	

	public MainPage(WebDriver driver) {
		super(driver);
	
	}
	
	public RestListPage enterAddress(String index){

		//d.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		//d.clear();
		//d.sendKeys(index);

		submit.click();
		return new RestListPage(driver);
		
	}
	
	

}
