package day9.HomeWork5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class CreatingAccount {
    /**
     * Part 1:
     *  Open "https://courses.ultimateqa.com/users/sign_up"
     *  create random and valid first name, last name, email and password, store for later validating
     *  fill in account submission form with data above
     *  Click on checkbox with id="user[terms]" to agree with terms and conditions
     *  click on "Sign up" button
     *  go to https://courses.ultimateqa.com/account
     *  validate that first name, last name and email you provided earlier is correct
     *
     * Part 2 (Optional)
     *  sign out of the website
     *  go to "https://courses.ultimateqa.com/users/sign_in"
     *  fill in sign in form with your stored email and password
     *  click on "Sign in" button
     *  validate that message "Signed in successfully." is displayed
     **/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.ultimateqa.com/users/sign_up");

        driver.manage().window().maximize();
        WebElement nameInput = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String name = randomString(driver, 5);
        nameInput.sendKeys(name);

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastName = randomString(driver, 6);
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        String email = randomString(driver, 7)+"@hotmail.com";
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='New Password']"));
        String password = randomString(driver, 8);
        passwordInput.sendKeys(password);

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='user[terms]']"));
        checkbox.click();

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        driver.get("https://courses.ultimateqa.com/account");

        WebElement accountName = driver.findElement(By.id("user[first_name]"));
        WebElement accountLastName = driver.findElement(By.id("user[last_name]"));
        WebElement accountEmail = driver.findElement(By.id("user[email]"));

        if (accountName.getCssValue("value").equalsIgnoreCase(name)) {
            System.out.println("account name : success");
        }
        if (accountLastName.getCssValue("value").equalsIgnoreCase(lastName)) {
            System.out.println("account last name : success");
        }
        if (((WebElement) accountEmail).getCssValue("value").equalsIgnoreCase(email)) {
            System.out.println("account email: success");
        }
        else {
            System.out.println("fail");
        }

        Thread.sleep(3000);
        driver.quit();
    }

    private static String randomString(WebDriver driver, int numOfLetters) {
        String letters = "ADMINISTRATIVELY";
        StringBuilder randomStr = new StringBuilder();

        for (int j = 0; j < numOfLetters; j++) {
            int random = new Random().nextInt(letters.length());
            randomStr.append(letters.charAt(random));
        }
        return randomStr.toString();

    }
}

