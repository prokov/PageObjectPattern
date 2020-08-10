package gitHubTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.PageObject;
import utils.PageObjectExtended;

public class SettingsPage extends PageObjectExtended {

	@FindBy(xpath="//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")
	private WebElement deleteBtn;

	@FindBy(xpath="//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
  	private WebElement repoName;

	@FindBy(xpath = "//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button")

	private WebElement submitBtn;




	public SettingsPage(WebDriver driver) {
		super(driver);

	}



	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public void deleteRepo(String name){

		deleteBtn.click();
		driver.switchTo().activeElement();
		repoName.clear();
		repoName.sendKeys(name);
		submitBtn.click();


}

}