import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test3 {
    @DataProvider(name = "test3")
    public Object[][] createData1() {
        return new Object[][]{
                {"academy", "IT Академія"},
                {"qa", "SoftServe performed QA Consulting to assess the QA processes  - Resources | SoftServe"},
        };
    }

    @Test(dataProvider = "test3")
    public void verifyData(String search, String firstTitle) {
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
}
