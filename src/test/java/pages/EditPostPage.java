package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditPostPage {
    @FindBy(id = "id_title")
    private WebElement titleTextBox;

    @FindBy(id = "id_subtitle")
    private WebElement subtitleTextBox;

    @FindBy(id = "id_body")
    private WebElement bodyTextBox;

    @FindBy(css = ".btn.btn-success")
    private WebElement editButton;

    WebDriver driver;

    public WebElement getTitleTextBox () {return titleTextBox;}
    public WebElement getSubtitleTextBox () {return subtitleTextBox;}
    public WebElement getBodyTextBox () {return bodyTextBox;}
    public WebElement getEditButton () {return editButton;}

    public EditPostPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to fill the Title text
    public void FillTitle () {
        titleTextBox.sendKeys("Edited Post");
    }
    // Method to fill the subtitle text
    public void FillSubtitle () {
        subtitleTextBox.sendKeys("This is an edited post");
    }
    // Method to fill the body text
    public void FillBody () {
        bodyTextBox.sendKeys("Teehee haha");
    }
    // Method to click on the Create button
    public void ClickEdit () {
        editButton.click();
    }
}