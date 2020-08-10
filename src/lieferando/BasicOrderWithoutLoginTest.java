package lieferando;

import static org.junit.Assert.*;

import org.junit.Test;

import lieferando.pages.MainPage;
import lieferando.pages.MenuPage;
import lieferando.pages.RestListPage;
import utils.FunctionalTest;

public class BasicOrderWithoutLoginTest extends FunctionalTest   {
	
	final String url = "https://www.lieferando.de";
	final String index = "10787";
	final String restName = "Pizza Max";
	final String dishName = "Shawarma-Hähnchen-Teller";

	
	MainPage mainPage  = new MainPage(driver);
	RestListPage restListPage;


	MenuPage menuPage;

	
	
	@Test
	public void orderingTest() throws InterruptedException {
		
		//Conditions
		driver.get(url);

		Thread.sleep(1000);
		//Action
		restListPage = mainPage.enterAddress(index);
		
		//Assertion
		assertTrue(restListPage.checkSearch());
//
	//	String lab = restListPage.checkIndexLabel();
		//assertTrue(restListPage.checkIndexLabel().contains(index));
//

		Thread.sleep(2000);
		//Action
		menuPage = restListPage.selectRest(restName);

		//Assertion

	//	assertTrue(restName.equals( menuPage.checkLabel()));
//
//		//Action
//		menuPage.selectDish(dishName);
//		menuPage.selectAddOn(0);
//		menuPage.checkOut();
//
//		//TODO Order Summaary Assertion andd next steps


		
		
	}

}
