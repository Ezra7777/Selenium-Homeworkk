package day9.Day9.HomeWork4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class SimpleFormWithMath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");

        driver.manage().window().maximize();

        List<WebElement> name = driver.findElements(By.xpath("//input[@placeholder='Name']"));
        List<WebElement> message = driver.findElements(By.xpath("//textarea[@placeholder='Message']"));

        String randomName = getRandomString(driver, 5);
        String randomMessage = getRandomString(driver, 80);

        for (int i = 0; i < name.size(); i++) {
            name.get(i).sendKeys(randomName);
            message.get(i).sendKeys(randomMessage);
        }

        Thread.sleep(3000);

        List<WebElement> submitButtons = driver.findElements(By.xpath("//button[@type='submit']"));
        submitButtons.get(0).click();

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        String expected = "Form filled out successfully";
        if (expected.equals(text.getText().trim())) {
            System.out.println("text: success");
        } else {
            System.out.println("text: failure");
        }

        String mathProblem = driver.findElement(By.xpath("//p[@class='clearfix']/span")).getText();
        System.out.println("given math problem on website: " + mathProblem);
        int solution = stringToIntMathSolution (driver, mathProblem);
        System.out.println("solution of the math problem: " + solution);

        WebElement mathInput = driver.findElement(By.name("et_pb_contact_captcha_1"));
        mathInput.sendKeys(String.valueOf(solution));

        WebElement mathSubmit = driver.findElements(By.name("et_builder_submit_button")).get(1);
        mathSubmit.click();

        // success part is needed.

        Thread.sleep(3000);
        driver.quit();
    }

    private static int stringToIntMathSolution(WebDriver driver, String mathProblem) {
        String [] arr = mathProblem.split(" ");

        int x = Integer.valueOf(arr[0]);
        int y = Integer.valueOf(arr[arr.length-1]);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if ("+".equals(arr[i])) {
                result = x + y;
            }
            if ("-".equals(arr[i])) {
                result = x - y;
            }
            if ("*".equals(arr[i])) {
                result = x * y;
            }
            if ("/".equals(arr[i])) {
                result = x / y;
            }
        }
        return result;
    }


    private static String getRandomString(WebDriver driver, int i) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomStr = new StringBuilder();

        for (int j = 0; j < i; j++) {
            int random = new Random().nextInt(letters.length());
            randomStr.append(letters.charAt(random));
        }
        return randomStr.toString();
    }
}

