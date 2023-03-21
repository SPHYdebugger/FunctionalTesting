import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class MainLidl {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.lidl.es");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement submitButton = driver.findElement(By.className("cookie-alert-extended-button"));
        submitButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("mainsearch-input")).sendKeys("sandwichera" + Keys.ENTER);

        List<WebElement> total = driver.findElements(By.xpath("//*[@id=\"product-search-results\"]/article/div[2]/div/*"));
        System.out.println(total.size());

        Thread.sleep(5000);


        driver.quit();
    }
}
