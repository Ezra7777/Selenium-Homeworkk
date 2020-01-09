package day9.HomeWork4;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class WaitForElementVisibilityWithError {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait( driver, 2 );
        WebElement checkBox = driver.findElement( By.cssSelector( "#checkbox-example input[type='checkbox']" ) );

        driver.findElement( By.xpath( "//button[contains(text(), 'Remove')]" ) ).click();

        try {
            wait.until( ExpectedConditions.invisibilityOf( checkBox ) );
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, checkBox was not invisible in 5 seconds!" );
            File file = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );
            File DestFile = new File( System.getProperty( "user.dir" ) + "/src/day9/homework/homework4/visibilityFailed.png" );
         //   FileUtils.copyFile( file, DestFile );
        }
    }
    }

