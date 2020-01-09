package day9.HomeWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    /**
     * Open "http://the-internet.herokuapp.com/login"
     *
     * using XPath:
     *      grab username from first <em> tag and store inside a String
     *      grab password from second <em> tag and store inside a String
     *      fill in username and password inputs with above username and password
     *      find <button> with type="submit" and click it
     *      find and verify text "Welcome to the Secure Area. When you are done click logout below."
     *      find "Log out" button and click it
     *      find and verify text "You logged out of the secure area!"
     * */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        String username = driver.findElements(By.xpath("//h4[@class='subheader']/em")).get(0).getText();
        String password = driver.findElements(By.xpath("//h4[@class='subheader']/em")).get(1).getText();

        // both are giving x as the text, not the actual.

        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();

        Thread.sleep(2000);

        String loggedIn = driver.findElement(By.xpath("//div[@class='flash success']")).getText();
        System.out.println(loggedIn);
        String logInMessageFromDataBase = "Welcome to the Secure Area. When you are done click logout below.";
        if (logInMessageFromDataBase.equals(loggedIn.trim())) {
            System.out.println("log in message: success");
        } else {
            System.out.println("log in message: failure");
        }

        WebElement logOut = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        logOut.click();

        Thread.sleep(2000);

        String loggedOut = driver.findElement(By.xpath("//div[@class='flash success']")).getText();
        System.out.println(loggedOut);
        String loggedOutMessageFromDataBase = "You logged out of the secure area!";
        if (loggedOutMessageFromDataBase.equals(loggedOut.trim())) {
            System.out.println("logged out message: success");
        } else {
            System.out.println("logged out message: failure");
        }

        Thread.sleep(5000);
        driver.quit();


    }
}



