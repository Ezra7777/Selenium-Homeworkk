package day9.HomeWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OptionalHomeWork {
    /**
     * go to "https://ultimateqa.com/automation/fake-pricing-page/"
     * maximize page
     * validate that "Free Trial" is $0
     * validate that "Basic" is $80
     * validate that "Enterprise" is $900
     **/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/automation/fake-pricing-page/");
        driver.manage().window().maximize();
        List<WebElement> priceList = driver.findElements(By.className("et_pb_sum"));
        String [] pricesFromDatabase = {"$0", "$80", "$900"};
        for (int i = 0; i < pricesFromDatabase.length; i++) {
            if (priceList.get(i).getText().equals(pricesFromDatabase[i])) {
                System.out.println("success: prices are equal for: " + priceList.get(i).getText());
            }
            else {
                System.out.println("fail at: " + ((List) priceList).get(i).getClass());
            }
        }

        Thread.sleep(2000);
        driver.quit();

    }
}





