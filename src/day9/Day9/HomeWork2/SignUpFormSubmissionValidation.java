package day9.Day9.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpFormSubmissionValidation {
    /**
     * open SignUpForm.html
     * store values that you will use inside some Strings
     * fill in your data inside the all input elements using Strings above
     * submit the form
     * get URL
     * parse values that was submitted
     * validate parsed values with stored values above
     */
    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        String path =("file:/Users/EsraOzturk/IdeaProjects/seleniumm/src/Day9/HomeWork1/SignUpForm.html" );
        driver.manage().window().maximize();

        String myText = "esra";
        WebElement text = driver.findElement(By.name("text"));
        text.sendKeys(myText);
        WebElement password = driver.findElement(By.name("password"));
        String myPassword = "Password";
        password.sendKeys(myPassword);
        WebElement passwordrepeat = driver.findElement(By.name("password repeat"));
        passwordrepeat.sendKeys(myPassword);
        String Adress1 = "129";
        String Adrees2 = "miller";
        String Adress3 = "ave";
        WebElement textarea = driver.findElement(By.name("textarea"));
        textarea.sendKeys(Adress1 + " " + Adrees2 + " " + Adress3);
        List<WebElement> radio = driver.findElements(By.name("radio"));
        WebElement secondElementOfRadio = radio.get(1);// [0, 1, 2].click
        secondElementOfRadio.click();
        WebElement select = driver.findElement(By.name("select"));
        Select dropdown = new Select(select);
        List<WebElement> option = dropdown.getOptions();
        for (WebElement element : option) {
            if (element.getText().equals("option 2"))
                dropdown.selectByVisibleText("option 2");
        }
        WebElement checkbox = driver.findElement(By.name("checkbox"));
        checkbox.click();
        WebElement submitButton = driver.findElement(By.id("submit "));
        submitButton.click();
        String url = driver.getCurrentUrl();
        String[] arrOfStr = url.split("&");
        for (int i = 0; i < arrOfStr.length; i++) {
            System.out.println(i + " " + arrOfStr[i]);
            String result = " ";
            if (arrOfStr[i].contains(myText)) {
                result = "succes";

            } else if (arrOfStr[i].contains(myPassword)) {
                result = "succes";
            } else if (arrOfStr[i].contains(Adress1)) {
                result = "succes";

            } else if (arrOfStr[i].contains(Adrees2)) {
                result = "succes";
            } else if (arrOfStr[i].contains(Adress3)) {
                result = "succes";
            } else {
                result = "fail";


            }
            System.out.println(result);
        }


    }
}

