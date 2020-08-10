package gitHubTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;
import utils.PageObjectExtended;

public class MainPage extends PageObjectExtended {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[4]/div/aside[1]/div[2]/div/div/h2/a")
    private WebElement createRepoBtn;

//    public CreateRepoPage createRepo(String user, String pass) {
//        createRepoBtn.click();
//        return new CreateRepoPage(driver);
//    }

    public CreateRepoPage createRepo(String user, String pass) {
        clickOnWebElement(createRepoBtn);
        return new CreateRepoPage(driver);
    }
}