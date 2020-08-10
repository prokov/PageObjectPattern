package blog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class PostPage extends PageObject {

    @FindBy(xpath="/html/body/app-root/app-edit-post/div/div/form/div[1]/div[2]/input")
    private WebElement title;

    @FindBy(xpath="/html/body/app-root/app-edit-post/div/div/form/div[2]/div[2]/div/textarea")
    private WebElement body;


    public boolean isInitialised(){
        return title.isEnabled();
    }



    public PostPage(WebDriver driver) {
        super(driver);
    }
}
