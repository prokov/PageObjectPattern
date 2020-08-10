package lieferando.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.PageObject;

public class RestListPage extends PageObject {
	
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/button")
	private WebElement indexLabel;
	
	@FindBy(id="irestaurantsearchstring-middle")
	private WebElement search;

//	@FindBy(className="restaurantname")
	private ArrayList<WebElement> restList;

	
	public RestListPage(WebDriver driver) {

		super(driver);

	}
	
	public MenuPage selectRest(String name){

		try{
		restList.forEach((x) -> {

			if(x.getText().equals(name)){
				x.click();
			}

		});}
		catch (StaleElementReferenceException e){
			System.out.println("Fuck exception!");
			return new MenuPage(driver);

		}

		return new MenuPage(driver);



//		restList = (ArrayList<WebElement>)driver.findElements(By.className("restaurantname"));
//
//		restList.forEach((x) -> {
//
//				if(x.getText().equals(name)){
//					x.click();
//				}
//
//			});
//
//		return new MenuPage(driver);
	}
	
	public String checkIndexLabel(){
		return indexLabel.getText();
	}
	
	public boolean checkSearch(){
		return search.isDisplayed()&search.isEnabled();
	}

}
