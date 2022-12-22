package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AssertStrings;

public class PostsPage {
    @FindBy(css = ".container h1")
    private WebElement titleHeader;

    @FindBy(css = ".container h1")
    private WebElement postTitle;

    @FindBy(css = ".container h5")
    private WebElement postSubtitle;

    @FindBy(css = ".container p")
    private WebElement postDescription;

    @FindBy(css=".container small")
    private WebElement postDetails;

    @FindBy(css = ".btn.btn-outline-primary")
    private WebElement editButton;

    WebDriver driver;

    public PostsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitleHeader (){return titleHeader;}
    public WebElement getPostTitle (){return postTitle;}
    public WebElement getPostSubtitle (){return postSubtitle;}
    public WebElement getPostDescription (){return postDescription;}
    public WebElement getPostDetails (){return postDetails;}
    public WebElement getEditButton (){return editButton;}

}
