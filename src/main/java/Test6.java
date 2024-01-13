import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Test6 {
    private final static Color HEX_COLOUR_FIND_BUTTON = Color.fromString("#00a046");
    private final static Color HEX_COLOUR_FIND_BUTTON_WRONG = Color.fromString("#02a046");

    public static WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void softAssert2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement findButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
        System.out.println(findButton.getText());

        Color findButtonBackgroundColor = Color
                .fromString(driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"))
                        .getCssValue("background-color"));
        System.out.println(findButtonBackgroundColor.equals(HEX_COLOUR_FIND_BUTTON));

        SoftAssert softAssertion = new SoftAssert();
        System.out.println("softAssert method1 was started");
        softAssertion.assertEquals(findButtonBackgroundColor, HEX_COLOUR_FIND_BUTTON_WRONG);
        System.out.println("softAssert method2 was started");
        softAssertion.assertEquals(findButtonBackgroundColor, HEX_COLOUR_FIND_BUTTON);
        System.out.println("softAssert method3 was started");
        softAssertion.assertEquals(findButton.getText(), "Знайти");
        System.out.println("softAssert method4 was started");
        softAssertion.assertEquals(findButton.getText(), "Знайти ще");
        System.out.println("softAssert Method Was Executed");
        softAssertion.assertAll();
    }

    @AfterTest
    public void setDown() {
        driver.quit();
    }
}
