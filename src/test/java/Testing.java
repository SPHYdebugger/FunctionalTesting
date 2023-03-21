import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Testing {

    @Test
    public void testingWeb() throws InterruptedException {
        //configure the webdriver
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //open the web
        driver.manage().window().maximize();
        driver.get("http://www.lidl.es");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));


        //accept the cookies
        WebElement submitButton = driver.findElement(By.className("cookie-alert-extended-button"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //search products
        driver.findElement(By.id("mainsearch-input")).sendKeys("sandwichera" + Keys.ENTER);
        List<WebElement> total = driver.findElements(By.xpath("//*[@id=\"product-search-results\"]/article/div[2]/div/*"));
        System.out.println(total.size());


        //compare the list of products
        assertEquals(24, total.size());


        //compare the title of the results page
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("Resultado de búsqueda | Lidl", title);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //add one product
        WebElement submitButton2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[3]/div/div[2]/article/div[2]/div/div[3]/section/div/div/form/button"));
        submitButton2.click();
        Thread.sleep(5000);


        //confirm the shopping basket
        driver.get("https://www.lidl.es/es/basket/contents");
        List<WebElement> findProduct = driver.findElements(By.xpath("/html/body/div[2]/div[1]/section[3]/div[2]/div/article/div/table/tbody/tr/td[1]/div[2]/div/h4/a"));
        System.out.println(findProduct.size());
        assertEquals(1,findProduct.size());


        //close the browser
        driver.quit();
    }

}

