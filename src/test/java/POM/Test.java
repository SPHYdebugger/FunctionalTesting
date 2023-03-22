package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class Test {

    private WebDriver driver;
    Data data;

    @org.junit.jupiter.api.Test
    public void setUp() throws Exception{
        data = new Data(driver);
        driver = data.chormeDriverConnection();
        data.visit(data.urlWeb);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        data.click(data.submitButton);
        data.type(data.product, data.search);
        int total = data.findElements(data.xpath).size();
        assertEquals(24, total);
        String title = driver.getTitle();
        assertEquals(data.title,title);
        WebElement button = data.findElement(data.buy);
        button.click();
        data.visit(data.basket);
        Thread.sleep(5000);
        int productsBought = data.findElements(data.bought).size();
        assertEquals(1,productsBought);
        driver.quit();
    }

}
