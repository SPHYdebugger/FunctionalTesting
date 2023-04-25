import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class UnitTest {



@BeforeAll
    public static void starDriver(){
    WebDriverWait wait;
    System.setProperty("webdriver.http.factory", "jdk-http-client");
    WebDriverManager.chromedriver().setup();
    wait = new WebDriverWait(MainLidl.driver, Duration.ofSeconds(10));
    //open the web
    MainLidl.openWeb(MainLidl.driver);
    //accept the cookies
    wait.until(ExpectedConditions.elementToBeClickable(By.className("cookie-alert-extended-button")));
    MainLidl.acceptCookies(MainLidl.driver);
    MainLidl.driver.manage().window().maximize();
}
@AfterEach
    public void returnPage(){
    MainLidl.openWeb(MainLidl.driver);
}
@AfterAll
    public static void shutdown(){
    MainLidl.driver.quit();
}

    @Test
    /*list the products of a category and check that the number
     of loaded products are the same that are loaded on the web*/
    public void testA()  {



        //search products
        int productsFound = MainLidl.searchProducts(MainLidl.driver);
        //compare the list of products
        Assertions.assertEquals(17, productsFound);


    }
    @Test
    /*use the e-commerce search bar, and check the title of the result*/
    public void testB() {
    System.setProperty("webdriver.http.factory", "jdk-http-client");
    WebDriverManager.chromedriver().setup();
    //open the web

    MainLidl.openWeb(MainLidl.driver);

    //search products
    MainLidl.searchProducts(MainLidl.driver);
    //compare the title of the results page
    String pageTitle = MainLidl.getTitle(MainLidl.driver);
    Assertions.assertEquals("Resultado de búsqueda | Lidl", pageTitle);
    MainLidl.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
    @Test
    /*test that is able to add an item to the shopping basket*/
    public void testC() throws InterruptedException {
    System.setProperty("webdriver.http.factory", "jdk-http-client");
    WebDriverManager.chromedriver().setup();
    //open the web
    MainLidl.openWeb(MainLidl.driver);

    //search products
    MainLidl.searchProducts(MainLidl.driver);
    //add one product
    MainLidl.addProduct(MainLidl.driver);


    //confirm the shopping basket
    MainLidl.driver.get("https://www.lidl.es/es/basket/contents");
    List<WebElement> findProduct = MainLidl.driver.findElements(By.xpath("/html/body/div[2]/div[1]/section[3]/div[2]/div/article/div/table/tbody/tr/td[1]/div[2]/div/h4/a"));
    System.out.println(findProduct.size());
    Assertions.assertEquals(1, findProduct.size());


        //close the browser

    }

}

