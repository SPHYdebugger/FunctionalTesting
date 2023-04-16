import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class Testing {

    @Test
    public void testingWeb() throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();


        //open the web
        MainLidl.openWeb(MainLidl.driver);



        //accept the cookies
        MainLidl.acceptCookies(MainLidl.driver);


        //search products
        int productsFound = MainLidl.searchProducts(MainLidl.driver);


        //compare the list of products
        assertEquals(18, productsFound);


        //compare the title of the results page
        String pageTitle = MainLidl.getTitle(MainLidl.driver);
        assertEquals("Resultado de búsqueda | Lidl",pageTitle);
        MainLidl.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //add one product
        MainLidl.addProduct(MainLidl.driver);


        //confirm the shopping basket
        MainLidl.driver.get("https://www.lidl.es/es/basket/contents");
        List<WebElement> findProduct = MainLidl.driver.findElements(By.xpath("/html/body/div[2]/div[1]/section[3]/div[2]/div/article/div/table/tbody/tr/td[1]/div[2]/div/h4/a"));
        System.out.println(findProduct.size());
        assertEquals(1,findProduct.size());


        //close the browser
        MainLidl.driver.quit();
    }

}

