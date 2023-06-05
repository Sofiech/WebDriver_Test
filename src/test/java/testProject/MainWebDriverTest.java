package testProject;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class MainWebDriverTest {

    protected WebDriver driver;
    public final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MainBaseTest.class);

    @Test //задание №1
    public void testTitle() {
        //2. Зайти на сайт -> https://duckduckgo.com/
        final String URL = "https://duckduckgo.com/";
        driver.get(URL);
        logger.info("Главная страница поискового сайта открыта");


        //3. Найти поисковую строку и ввести "ОТУС":
        WebElement findEl = driver.findElement(By.cssSelector("input[id='search_form_input_homepage']"));
        logger.info("Поисковая строка найдена");
        findEl.sendKeys("Отус", Keys.ENTER);
        logger.info("В поисковую строку введено слово ОТУС и ENTER -> переход");
        // 4. Проверить результат "Онлайн-курсы....
        String title = driver.findElement(By.xpath("//h1")).getText();
        assertSame(title, "Авторские онлайн-курсы");
    }

    @Test //Задание №2
    public void setWindow() {

        final String URL = " https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";

        //1. Окно в стиле киоск
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        logger.info("Сайт на нужной странице открыт");

        //2.Определяемся с локатором нужной картинки и переходим к ней,
        WebElement gallery = driver.findElement(By.cssSelector("body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(3)"));
        gallery.sendKeys("Keys.PAGE_DOWN");
        WebElement picture = driver.findElement(By.cssSelector("body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(3) > span > a > img"));
        picture.click();
        logger.info("Модальное окно отражено");
    }

    @Test //Задание №3

    public void testLogin() {
        //1. Открыть otus.ru в режиме полного окна
        driver.manage().window().fullscreen();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://otus.ru");
        logger.info("Открыта страница ОТУС");

        String login = "tistegitra@tozya.com";
        String password = "Qwerty76_";
        String locator = "button.header2__auth";
        By.cssSelector(locator).findElement(driver).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector(".js-email-input")).sendKeys(login);
        driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
    }

    @Test //Задание №4.
    public void cookieTest() {
        // Отразить все cookies

        driver.manage().addCookie(new Cookie("key", "value"));
        driver.manage().getCookies();
        assertEquals(0, driver.manage().getCookies().size());

    }

}