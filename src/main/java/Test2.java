import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test2 {
    @Parameters({"datasource", "jdbcDriver"})
    @BeforeMethod
    public void beforeTest(String ds, String driver) {
        System.out.println("Datasource: " + ds);
        System.out.println("JdbcDriver: " + driver);
    }

    @Parameters({"first-title", "search"})
    @Test
    public void testSingleString(String firstTitle, String search) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        try {
            driver.get("https://www.softserveinc.com/uk-ua");
            driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();
            WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys(search);
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h3[@class='search-card__title']"))));
            System.out.println(results.get(0).getText().equals(firstTitle));
            Screenshot.getScreenShot(driver);
        } finally {
            driver.quit();
        }
    }

    //Parameters can be declared optional with the Optional annotation
    @Parameters("db")
    @Test
    public void testNonExistentParameter(@Optional("mysql") String db) {
        System.out.println("db: " + db);
    }
}
