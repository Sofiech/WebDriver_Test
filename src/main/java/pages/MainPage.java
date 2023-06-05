package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbsBasePage{

    private MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(tagName = "title")
    private WebElement title;

    private String titleTempalateLocator = "//a[@title='%s']";
    private String modalSelect = ".modal";


}
