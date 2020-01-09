package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Task1SolutionTESTNG {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // write a function that takes a number, and clicks the "Add Element" button
    // given number of times, and then validate that given number of
    // "Delete" buttons is displayed

    private WebDriver driver;
    private int num = 100;

    @BeforeClass
    public void clickWebsite() {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void clickAndValidate() {
        WebElement btn = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < num; i++) {
            btn.click();
        }
        List<WebElement> list = driver.findElements(By.className("added-manually"));

        Assert.assertEquals(list.size(), num);

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}