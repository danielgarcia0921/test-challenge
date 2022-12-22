package tests;

import org.junit.*;
import org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditPostPage;
import pages.LoginPage;
import pages.NewPostPage;
import pages.PostsPage;
import utils.AssertStrings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Scenario_1_Test {
    private WebDriver driver;
    private LoginPage loginPage;
    private NewPostPage newPostPage;
    private PostsPage postPage;
    private EditPostPage editPostPage;


    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://sheltered-mesa-19374.herokuapp.com/");
        loginPage = new LoginPage(driver);
        String username = AssertStrings.username;
        String password = AssertStrings.password;
        loginPage.completeLogin(username,password);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void urlTest(){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://sheltered-mesa-19374.herokuapp.com/");
    }

    @Test
    public void verifyFeature1Scenario1() {
        newPostPage = new NewPostPage(driver);
        postPage = new PostsPage(driver);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(AssertStrings.dateTimeFormat);
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        formattedDate = formattedDate.replace("AM","a.m.").replace("PM","p.m.");

        newPostPage.NavigateToNewPost();
        newPostPage.FillTitle();
        newPostPage.FillSubtitle();
        newPostPage.FillBody();
        newPostPage.ClickCreate();

        Assert.assertTrue("",driver.getCurrentUrl().contains(AssertStrings.POSTSPAGEURL));

        Assert.assertEquals(AssertStrings.NEWPOSTTITLE, postPage.getPostTitle().getText());
        Assert.assertEquals(AssertStrings.NEWPOSTSUBTITLE, postPage.getPostSubtitle().getText());
        Assert.assertEquals(AssertStrings.NEWPOSTDESCRIPTION, postPage.getPostDescription().getText());

        Assert.assertTrue(postPage.getPostDetails().getText().contains(AssertStrings.username));
        Assert.assertTrue(postPage.getPostDetails().getText().contains(formattedDate));

    }

    @Test
    public void verifyFeature1Scenario2() {
        newPostPage = new NewPostPage(driver);
        postPage = new PostsPage(driver);

        newPostPage.NavigateToNewPost();
        newPostPage.FillSubtitle();
        newPostPage.FillBody();
        newPostPage.ClickCreate();

        String errorMessage = newPostPage.getTitleTextBox().getAttribute("tagName");
        System.out.println(errorMessage);
        // The Error messages are not part of the DOM, they're an attribute
        JavascriptExecutor js = (JavascriptExecutor) driver;




    }

    @Test
    public void verifyFeature2Scenario1() {
        newPostPage = new NewPostPage(driver);
        postPage = new PostsPage(driver);
        editPostPage = new EditPostPage(driver);

         //Preconditions
        newPostPage.NavigateToNewPost();
        newPostPage.FillTitle();
        newPostPage.FillSubtitle();
        newPostPage.FillBody();
        newPostPage.ClickCreate();

        //Test
        postPage.getEditButton().click();
        editPostPage.getTitleTextBox().clear();
        editPostPage.getSubtitleTextBox().clear();
        editPostPage.getBodyTextBox().clear();
        editPostPage.FillTitle();
        editPostPage.FillSubtitle();
        editPostPage.FillBody();
        editPostPage.ClickEdit();

        Assert.assertTrue("",driver.getCurrentUrl().contains(AssertStrings.POSTSPAGEURL));
        Assert.assertEquals(AssertStrings.EDITPOSTTITLE, postPage.getPostTitle().getText());
        Assert.assertEquals(AssertStrings.EDITPOSTSUBTITLE, postPage.getPostSubtitle().getText());
        Assert.assertEquals(AssertStrings.EDITPOSTDESCRIPTION, postPage.getPostDescription().getText());
        Assert.assertTrue(postPage.getPostDetails().getText().contains(AssertStrings.username));

    }

    @Test
    public void verifyFeature2Scenario2 () {
        newPostPage = new NewPostPage(driver);
        postPage = new PostsPage(driver);
        editPostPage = new EditPostPage(driver);

        //Preconditions
        newPostPage.NavigateToNewPost();
        newPostPage.FillTitle();
        newPostPage.FillSubtitle();
        newPostPage.FillBody();
        newPostPage.ClickCreate();

        //Test
        postPage.getEditButton().click();
        editPostPage.getSubtitleTextBox().clear();
        editPostPage.getBodyTextBox().clear();
        editPostPage.FillSubtitle();
        editPostPage.FillBody();
        editPostPage.ClickEdit();

        Assert.assertTrue("",driver.getCurrentUrl().contains(AssertStrings.POSTSPAGEURL));
        Assert.assertEquals(AssertStrings.NEWPOSTTITLE, postPage.getPostTitle().getText());
        Assert.assertEquals(AssertStrings.EDITPOSTSUBTITLE, postPage.getPostSubtitle().getText());
        Assert.assertEquals(AssertStrings.EDITPOSTDESCRIPTION, postPage.getPostDescription().getText());
        Assert.assertTrue(postPage.getPostDetails().getText().contains(AssertStrings.username));
    }
}
