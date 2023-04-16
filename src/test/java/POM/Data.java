package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Data extends Base{

    String urlWeb = "http://www.lidl.es";
    By submitButton = By.className("cookie-alert-extended-button");
    By search = By.id("mainsearch-input");
    String product = "freidora";
    By xpath = By.xpath("//*[@id=\"product-search-results\"]/article/div[2]/div/*");
    String title = "Resultado de búsqueda | Lidl";
    By buy = By.xpath("/html/body/div[2]/div[1]/section[3]/div/div[2]/article/div[2]/div/div[3]/section/div/div/form/button");
    String basket = "https://www.lidl.es/es/basket/contents";
    By bought = By.xpath("/html/body/div[2]/div[1]/section[3]/div[2]/div/article/div/table/tbody/tr/td[1]/div[2]/div/h4/a");

    public Data(WebDriver driver) {
        super(driver);
    }



}
