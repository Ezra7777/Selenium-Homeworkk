package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


    public class CheckBox {
        // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        // Click on the button "Check All"
        // validate that all checkboxes are checked
        // using By.cssSelector( "input:checked" );
        public static void main(String[] args) {
            System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
            WebDriver driver = new ChromeDriver();
            driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );
            List<WebElement> uncheckedBoxes = driver.findElements( By.cssSelector( ".cb1-element:not(:checked)" ) );
            int sizeBefore = uncheckedBoxes.size();

            driver.findElement( By.id( "check1" ) ).click();

            List<WebElement> checkedBoxes = driver.findElements( By.cssSelector( ".cb1-element:checked" ) );
            int sizeAfter = checkedBoxes.size();

            if(sizeBefore == sizeAfter) {
                System.out.println("Success!");
            } else {
                System.out.println("Failure!");
            }


        }
    }


