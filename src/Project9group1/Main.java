package Project9group1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
    WebDriver driver = new ChromeDriver();
        driver.get("https:////test-basqar.mersys.io/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

         WebDriverWait wait = new WebDriverWait(driver, 5);
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector(".group-items > :nth-child(2)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(2) > .children > :nth-child(2)")).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();
        driver.findElement(By.cssSelector(".cdk-overlay-3")).click();








    }
}