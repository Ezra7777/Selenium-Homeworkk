package day9.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpForm {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:/Users/EsraOzturk/IdeaProjects/seleniumm/src/Day9/HomeWork1/SignUpForm.html");


        WebElement element = driver.findElement(By.name("text"));
        element.sendKeys("Ezra");
        System.out.println(element.getAttribute("type"));
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password ");
        System.out.println(element.getAttribute("type"));
        WebElement password1 = driver.findElement(By.name("password repeat"));
        password1.sendKeys("password repeat");
        System.out.println(element.getAttribute("type"));
        WebElement textarea = driver.findElement(By.name("textarea"));
        textarea.sendKeys("textarea");

        List<WebElement> gender = driver.findElements(By.name("sex"));
        gender.get(0).click();

        WebElement plan = driver.findElement(By.name("plan"));
        Select p = new Select(plan);
        int planSize = driver.findElements(By.tagName("option")).size();
        for (int i = 0; i < planSize; i++) {
            Thread.sleep(1000);
            p.selectByIndex(i);
        }

        WebElement agree = driver.findElement(By.name("agreement"));
        agree.click();

        Thread.sleep(5000);

        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
        // page will renew after submission

        Thread.sleep(2000);
        driver.quit();
    }
}




