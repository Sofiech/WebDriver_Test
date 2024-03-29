package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.AbsPageObject;

public abstract class AbsBaseComponent extends AbsPageObject {
    public AbsBaseComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); //не импортируется Selenium.PageFactory
    }

}
