package POM;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class ObjectTest {

    private WebDriver driver;


    WebDriverWait wait;
    Data data;

    @org.junit.jupiter.api.Test
    public void setUp() throws Exception{

        data = new Data(driver);
        driver = data.chromeDriverConnection();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        data.visit(data.urlWeb);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        data.click(data.submitButton);
        /*wait.until(ExpectedConditions.elementToBeClickable(By.id("mainsearch-input")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainsearch-input")));
        data.type(data.product, data.search);
        int total = data.findElements(data.xpath).size();
        Assertions.assertEquals(17, total);
        String title = driver.getTitle();
        Assertions.assertEquals(data.title, title);
        WebElement button = data.findElement(data.buy);
        button.click();
        data.visit(data.basket);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/section[3]/div[2]/div/article/div/table/tbody/tr/td[1]/div[2]/div/h4/a")));
        int productsBought = data.findElements(data.bought).size();
        Assertions.assertEquals(1, productsBought);
        
         */
        driver.quit();
    }

}
