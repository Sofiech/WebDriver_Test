package factory;

import data.DriverData;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class FactoryWebDriver {

    private String chromeName = System.getProperty("browser");

    public WebDriver getDriver() {
        return getDriver(null, null);
    }

    public WebDriver getDriver(DriverData driverData, Capabilities options) {
        if (!CHROME.equals(driverData)) {
            return null;
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(options);

//
        return new ChromeDriver(chromeOptions);
    }
}
