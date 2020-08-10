package gitHubTest;

import gitHubTest.pages.CreateRepoPage;
import gitHubTest.pages.LoginPage;
import gitHubTest.pages.MainPage;
import gitHubTest.pages.RepoListPage;
import gitHubTest.pages.SettingsPage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.FunctionalTestExtended;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//A page object should not have any assertions
//A page object should represent meaningful elements of a page and not necessarily a complete page
//When you navigate you should return the a page object for the next page

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicTest extends FunctionalTestExtended {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    SettingsPage settings;
    CreateRepoPage createPage;
    RepoListPage repoListPage = new RepoListPage(driver);

    String user = "prokov";
    String password = "Begemot1234*";
    String baseURL = "https://github.com/login";
    String repoListURL = "https://github.com/prokov?tab=repositories";
    static String repoName = "Repo" + String.valueOf((int) (Math.random() * 1000000));
    //TODO How to make it unique for each test?
    String repoDescr = "Some valid description";

    //TODO Add test for invalid credentials
    //TODO Add test for Create with options
    //TODO Add test for Delete

    @Test
    public void test1_createRepo() throws InterruptedException {
        driver.get(baseURL);
        mainPage = loginPage.login(user, password);

        createPage = mainPage.createRepo(repoName, repoDescr);
        assertFalse(createPage.createBtnEnabled());

        createPage.fillRequiredProperties(repoName, repoDescr);

        Thread.sleep(3000);
        assertTrue(createPage.createBtnEnabled());

        createPage.create();

        assertTrue(createPage.getRepoLabel().equals(repoName)); //strictly speaking we need particular page for it
        assertTrue(createPage.getUserLabel().equals(user));

        // Assert for created repo search result
        driver.get(repoListURL);
        assertEquals("1", repoListPage.searchRepo(repoName) );
        System.out.println("Created repo " + repoName);

    }

    @Test
    public void test2_deleteRepo() {

        driver.get("https://github.com/" + user + "/" + repoName + "/settings");
        settings = new SettingsPage(driver);
        //TODO Check that SubmitBtn is disabled

        settings.deleteRepo(user + "/" + repoName);

        //TODO To assert the label "Your repository "prokov/Repo175188" was successfully deleted."

        // Assert for deleted repo search result
        driver.get(repoListURL);
        assertEquals("0", repoListPage.searchRepo(repoName) );
        System.out.println("Deleted repo " + repoName);


    }


}