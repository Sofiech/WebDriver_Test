package testProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainBaseTest {

    private WebDriver driver;

    public MainBaseTest(WebDriver driver) {
        this.driver = driver;
    }

    public final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MainBaseTest.class);



    @BeforeAll
    public static void setUp() {                        //0.Открыть драйвер 1 раз за все время тестирования

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startUp() {
        //1. Открыть сайт в режиме "headless"
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=");
        options.addArguments("headless");
        logger.info("Драйвер поднят");
        driver = new ChromeDriver(options);
    }


    @AfterEach
        public void close () {
            if (driver != null){
                driver.close();
                driver.quit();
        }
    }
}





