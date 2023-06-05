package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbsPageObject {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait webDriverWait;

    public AbsPageObject(WebDriver driver){
        this.driver=driver;
        this.actions = new Actions(driver);
        this.webDriverWait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
        private WebElement header;

    public  void pageHeaderShouldBeSameAs(String header){
        Assertions.assertEquals(
                header,
                this.header.getText(),
                String.format("Header should be%s", header));

    }
}

