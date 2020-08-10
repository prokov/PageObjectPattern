package lieferando.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import java.util.ArrayList;

public class MenuPage extends PageObject {

    @FindBy(xpath = "//*[@id='menu-tab-content']/div[1]/div/div[1]/h1")
    private WebElement restLabel;


    @FindBy(className = "menucard__meals")
    private WebElement menuCard;

    @FindBy(className = "sidedish-checkbox")
    private WebElement addOn;


    @FindBy(xpath = "//*[@id=\"isidedishselectionformO1N3QQPQQ\"]/div[2]/div[2]/button")
    private WebElement checkoutBtn;



    public void checkOut() {

        checkoutBtn.click();

    }


    public void selectAddOn(int number) {

      driver.findElements(By.className("checkbox-inline")).get(number).
              findElement(By.tagName("span"))
              .click();

    }


    public void selectDish(String dishName) {

        ArrayList<WebElement> spansList = (ArrayList<WebElement>) menuCard.findElements(By.tagName("span"));

        spansList.forEach((x) -> {
            if (x.getText().equals(dishName)) x.click();

        });

    }


    public MenuPage(WebDriver driver) {
        super(driver);

    }

    public String checkLabel() {
        return restLabel.getText();
    }

}
