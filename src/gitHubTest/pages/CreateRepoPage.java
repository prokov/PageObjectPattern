package gitHubTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObjectExtended;

public class CreateRepoPage extends PageObjectExtended {

    @FindBy(id = "repository_name")
    private WebElement name;

    @FindBy(id = "repository_description")
    private WebElement description;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[4]/button")
    private WebElement createButton;


    @FindBy(xpath = "//*[@id='js-repo-pjax-container']/div[2]/div/div/h1/span[1]/a")
    private WebElement userLabel;


    @FindBy(xpath = "//*[@id='js-repo-pjax-container']/div[2]/div/div/h1/strong/a")

    private WebElement repoLabel;


    public String getUserLabel() {
        return userLabel.getText();
    }


    public String getRepoLabel() {
        return repoLabel.getText();
    }


    public CreateRepoPage(WebDriver driver) {
        super(driver);
    }


    public boolean createBtnEnabled() {
        waitForElementToBeVisible(driver, 3, createButton);

        return createButton.isEnabled();
    }

    //TODO To add all parameters like private, readme etc.
    public void fillAllProperties(String repoName, String desc) {
        name.sendKeys(repoName);
        description.sendKeys(desc);

    }

    //    public void fillRequiredProperties(String repoName, String desc) {
//        name.sendKeys(repoName);
//        description.sendKeys(desc);
//
//    }
    public void fillRequiredProperties(String repoName, String desc) {
        sendTextToWebElement(name, repoName);
        sendTextToWebElement(description, desc);

    }

//    public void create() {
//        createButton.click();
//    }

    public void create() {
        clickOnWebElement(createButton);
    }
}