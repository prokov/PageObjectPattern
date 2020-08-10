package blog;

import org.junit.Test;
import utils.FunctionalTest;

import static org.junit.Assert.assertTrue;

public class BlogTest extends FunctionalTest {

    String baseURL = "http://localhost:8080/";
    MainPage  mainPage ;
    PostPage postPage;


    @Test
    public void testBasic(){
        driver.get(baseURL);

        mainPage = new MainPage(driver);
        assertTrue(mainPage.isInitilised());

        postPage = mainPage.createPost();
        assertTrue(postPage.isInitialised());

    }



}
