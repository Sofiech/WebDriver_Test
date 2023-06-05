package pages;

import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    private final static String hostname = System.getProperty("base.url");


    public AbsBasePage(WebDriver driver){
        super(driver);
    }

    public void openPage(String path){
        driver.get(hostname+path);
    }
}
