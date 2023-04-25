package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement (By xpath){
        return driver.findElement(xpath);
    }
    public List<WebElement> findElements (By xpath){
        return driver.findElements(xpath);
    }

    public void type(String imputText, By id){
        driver.findElement(id).sendKeys(imputText+ Keys.ENTER);
    }
    public void click (By className){
        driver.findElement(className).click();
    }

    public void visit(String url){
        driver.get(url);
    }
}
