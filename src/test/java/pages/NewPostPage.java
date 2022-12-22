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

    public WebElement getTitleTextBox () {return titleTextBox;}
    public WebElement getSubtitleTextBox () {return subtitleTextBox;}
    public WebElement getBodyTextBox () {return bodyTextBox;}
    public WebElement getCreateButton () {return createButton;}
    public WebElement getNavBarLink () {return navBarLink;}

    public NewPostPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
