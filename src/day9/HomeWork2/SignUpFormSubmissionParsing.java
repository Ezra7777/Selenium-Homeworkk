package day9.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SignUpFormSubmissionParsing {
    /**
     * open SignUpForm.html
     * fill in your data inside the all input elements
     * submit the form
     * get URL
     * parse values that was submitted and print them out
     * hint: https://examples.javacodegeeks.com/core-java/net/url/parse-url-example/
     * like nameOfTheInput = valueOfTheInput
     */
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:/Users/EsraOzturk/IdeaProjects/seleniumm/src/Day9/HomeWork1/SignUpForm.html");

        driver.manage().window().maximize();
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

        WebElement checkbox = driver.findElement(By.name("radio"));
        checkbox.click();
        List<WebElement> radio = driver.findElements(By.name("radio"));
        // [0, 1, 2].click
        WebElement secondElementOfRadio = radio.get(1);
        secondElementOfRadio.click();

        WebElement egreement = driver.findElement(By.name("agreement"));
        egreement.click();


        WebElement agree = driver.findElement(By.name("agreement"));
        agree.click();

        Thread.sleep(5000);

        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
        String url = driver.getCurrentUrl();
        parseUrl(driver, url);
        // page will renew after submission

        Thread.sleep(2000);
        driver.quit();

    }
    private static void parseUrl(WebDriver driver, String url) throws MalformedURLException {
        URL myUrl = new URL(url);
        String sentKeys = myUrl.getQuery();
        for (String str: sentKeys.split("&")) {
            System.out.println(str);
        }
    }
}

