import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MainLidl {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

    }



    public static void openWeb (WebDriver driver){

        driver.manage().window().maximize();
        driver.get("http://www.lidl.es");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    public static void acceptCookies (WebDriver driver){
        WebElement submitButton = driver.findElement(By.className("cookie-alert-extended-button"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    public static int searchProducts (WebDriver driver){
        driver.findElement(By.id("mainsearch-input")).sendKeys("freidora" + Keys.ENTER);
        List<WebElement> total = driver.findElements(By.xpath("//*[@id=\"product-search-results\"]/article/div[2]/div/*"));
        int numProducts = total.size();
        return numProducts;
    }
    public static String getTitle (WebDriver driver){
        String title = driver.getTitle();
        System.out.println(title);
        return title;

    }
    public static void addProduct (WebDriver driver) throws InterruptedException {
        WebElement submitButton2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[3]/div/div[2]/article/div[2]/div/div[3]/section/div/div/form/button"));
        submitButton2.click();
        Thread.sleep(5000);

    }


}
