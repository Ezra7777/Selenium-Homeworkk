package day9.Day9.HomeWork4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class SimpleForm {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");

        driver.manage().window().maximize();
        String text= "hgdfgfcjkhgjgf";
        String message="asds asd asda dadada dada ad";
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_name_0\"]")).sendKeys(text);
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_message_0\"]")).sendKeys(message);
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")).click();
            Thread.sleep(5000);
        }
        WebElement element = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[1]/p"));

        if(element.getText().equals("Form filled out successfully")){
            System.out.println("success message is displayed");
        }else
            System.out.println("success message is not displayed");

    }
}



