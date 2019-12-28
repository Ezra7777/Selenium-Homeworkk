package day9.Day9.HomeWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CSSSelector {
    /**
     * Open "https://ultimateqa.com/complicated-page/"
     * find "Skills Improved:" using css selectors and validate text
     * find "How to deal with a large page that has many elements and divisions?" using css selector and validate it
     * find "Properly structuring your page objects" using css selector and validate it
     * */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/complicated-page/");
        driver.manage().window().maximize();

        String skillsTextFromDatabase = "Skills Improved:";
        WebElement skillsText = driver.findElement(By.cssSelector("span#Skills_Improved"));

        String howToFromDataBase = "How to deal with a large page that has many elements and divisions?";
        String properlyFromDataBase = "Properly structuring your page objects";
        List<WebElement> list = driver.findElements(By.cssSelector("div.et_pb_text_inner ul li"));
        WebElement howToText = list.get(0);
        WebElement properlyText = (WebElement) ((List) list).get(1);

        if (skillsTextFromDatabase.equals(skillsText.getText().trim())) {
            System.out.println("skills text: success");
        }
        if (howToFromDataBase.equals(howToText.getText().trim())) {
            System.out.println("how to text: success");
        }
        if (properlyFromDataBase.equals(properlyText.getText().trim())) {
            System.out.println("properly text: success");
        }
        else {
            System.out.println("fail");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}


