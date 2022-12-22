package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage {
    @FindBy(xpath = "//a[.=\"New Post\"]")
    private WebElement navBarLink;

    @FindBy(id = "id_title")
    private WebElement titleTextBox;

    @FindBy(id = "id_subtitle")
    private WebElement subtitleTextBox;

    @FindBy(id = "id_body")
    private WebElement bodyTextBox;

    @FindBy(css = ".btn.btn-success")
    private WebElement createButton;

    WebDriver driver;

    public NewPostPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to New Post page
    public void NavigateToNewPost (){
        navBarLink.click();
    }
    // Method to fill the Title text
    public void FillTitle () {
        titleTextBox.sendKeys("Test");
    }
    // Method to fill the subtitle text
    public void FillSubtitle () {
        subtitleTextBox.sendKeys("Test Subtitle");
    }
    // Method to fill the body text
    public void FillBody () {
        bodyTextBox.sendKeys("This is a test description :)");
    }
    // Method to click on the Create button
    public void ClickCreate () {
        createButton.click();
    }

//    public WebElement getTitleTextBox () {return titleTextBox;}
//    public WebElement getSubtitleTextBox () {return subtitleTextBox;}
//    public WebElement getBodyTextBox () {return bodyTextBox;}
//    public WebElement getCreateButton () {return createButton;}
//    public WebElement getNavBarLink () {return navBarLink;}

}
