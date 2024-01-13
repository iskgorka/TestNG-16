import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {
    private final static Color HEX_COLLOR_BUTTON = Color.fromString("#00a046");

    @Test(groups = {"functest", "checkintest"})
    public static void testMethod1() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://rozetka.com.ua/");
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
            System.out.println(firstResult.getText());
            Color searchButtonBackgroundColor = Color
                    .fromString(driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"))
                            .getCssValue("background-color"));
            System.out.println(searchButtonBackgroundColor.equals(HEX_COLLOR_BUTTON));
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {"functest", "checkintest"})
    public static void testMethod2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://rozetka.com.ua/");
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
            System.out.println(firstResult.getText());
            Color searchButtonBackgroundColor = Color
                    .fromString(driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"))
                            .getCssValue("background-color"));
            System.out.println(searchButtonBackgroundColor.equals(HEX_COLLOR_BUTTON));
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {"functest"})
    public static void testMethod3() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://rozetka.com.ua/");
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
            System.out.println(firstResult.getText());
            Color searchButtonBackgroundColor = Color
                    .fromString(driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"))
                            .getCssValue("background-color"));
            System.out.println(searchButtonBackgroundColor.equals(HEX_COLLOR_BUTTON));
        } finally {
            driver.quit();
        }
    }
}
