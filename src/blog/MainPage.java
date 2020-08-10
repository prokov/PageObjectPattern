package blog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class MainPage extends PageObject {

    @FindBy(xpath="/html/body/app-root/app-header/header/div[2]/div/div/div/h1")
    private WebElement header;

    @FindBy(xpath="//*[@id=\"navbarResponsive\"]/ul/div[5]/app-navigation-item/li/a")
    private WebElement createPost;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitilised(){
        return header.getText().equals("Clean Blog");
    }

    public PostPage createPost(){
        createPost.click();
        return new PostPage(driver);
    }

}
