package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task3SolutionTESTNG {
    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Normal success message" button then validate
    // that message is equal "I'm a normal success message. To close use the appropriate button."
    // then click on X button on the message
    // validate the the message is invisible or not present

    WebDriver driver;
    @BeforeClass
    public void clickwebsite() {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver" );
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test
    public void click() {
        driver.findElement( By.id( "normal-btn-success" ) ).click();
        WebElement message = driver.findElement( By.cssSelector( ".alert-normal-success" ) );
        WebElement button = driver.findElement( By.cssSelector( ".alert-normal-success > button" ) );
        String text = message.getText().replace( button.getText(), "" ).trim();
        String test = "I'm a normal success message. To close use the appropriate button.";
        Assert.assertEquals(test,text);
        button.click();
        Assert.assertTrue(!message.isDisplayed());

    }
}