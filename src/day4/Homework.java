package day4;

import org.openqa.selenium.WebElement;

import java.util.List;


    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

    public class Homework {
        // go to URL: https://www.seleniumeasy.com/test/
        // click on each link of class="board-inner"
        // and validate that class="tab-content" has
        // correct text for "h3" tag and adjacent "p" tag in active div
        // after you click associated link above
        // h3 + p
        // there should be at least 5 test of "h3" tag and adjacent "p" tag

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.seleniumeasy.com/test/");
            String[][] testData = {
                    {"WELCOME TO SELENIUM EASY DEMO", "We have listed most of the components that are used by developers to build web applications."},
                    {"BASIC EXAMPLES TO START WITH SELENIUM", "Assuming you have a basic understanding of HTML and CSS."},
                    {"INTERMEDIATE EXAMPLES WITH MOST POPULAR COMPONENTS", "Hoppe you had Great fun automating basic demo components."},
                    {"ADVANCED EXAMPLES WITH COMPONENTS", "  These are not much difficult to Automate. Give a try to automate below components "},
                    {"THANKS FOR STAYING TUNED! WE ARE DONE", "\n" +
                            "                                  Now focus on building automation framework from scratch using Selenium WebDriver.\n" +
                            "                                "},
            };

            List<WebElement> links = driver.findElements(By.cssSelector(".board-inner a"));
            for (int i = 0; i < links.size(); i++) {
                System.out.println(links.get(i).getAttribute("href"));
                links.get(i).click();
                Thread.sleep(1000);
                validate(driver, testData[i]);
            }
            driver.quit();
        }

        private static void validate(WebDriver driver, String[] testStrings) {
            WebElement activeH3Tag = driver.findElement(By.cssSelector(".tab-content .active h3"));
            WebElement activeFirstPTag = driver.findElement(By.cssSelector(".tab-content .active p"));

            System.out.println(activeH3Tag.getText());

            boolean h3Condition = activeH3Tag.getText().trim().equals(testStrings[0].trim());
            boolean p1Condition = activeFirstPTag.getText().trim().equals(testStrings[1].trim());

            if (h3Condition && p1Condition) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        }
    }

