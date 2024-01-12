import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Test4 {
    @Test
    public void verifyData() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        try {
            driver.get("https://www.softserveinc.com/uk-ua");
            driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();
            WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys("career");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h3[@class='search-card__title']"))));

            assertEquals(results.get(0).getText(), "Streamline Retail Operations with Generative AI Solutions", "academy doesn't work");
            Screenshot.getScreenShot(driver);
        } finally {
            driver.quit();
        }
    }
}
