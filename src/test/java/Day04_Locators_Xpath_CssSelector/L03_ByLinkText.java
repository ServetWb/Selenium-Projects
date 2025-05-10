package Day04_Locators_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
public class L03_ByLinkText {

    public static void main(String[] args) throws InterruptedException {
// 1- Create a test class and perform the necessary setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Navigate to https://www.automationexercise.com/
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(3000);
        // If a cookie popup appears, handle it manually and accept

        // 3- Verify that there are 147 links on the page
        List<WebElement> linkElementsList = driver.findElements(By.tagName("a"));

        int expectedLinkCount = 147;
        int actualLinkCount = linkElementsList.size();

        if (expectedLinkCount == actualLinkCount) {
            System.out.println("Link count test PASSED");
        } else {
            System.out.println("Link count test FAILED");
        }

        // 4- Click on the "Products" link
        // WebElement productsLinkElement = driver.findElement(By.linkText(" Products"));

        // If we don’t want to type the full text:
        // WebElement productsLinkElement = driver.findElement(By.partialLinkText("Product"));
        // WebElement productsLinkElement = driver.findElement(By.partialLinkText("oduct"));
        WebElement productsLinkElement = driver.findElement(By.partialLinkText("duc"));

        productsLinkElement.click();

        // 5- Verify that the "Special Offer" text is visible
        WebElement specialOfferTextElement = driver.findElement(By.id("sale_image"));

        if (specialOfferTextElement.isDisplayed()) {
            System.out.println("Special offer text test PASSED");
        } else {
            System.out.println("Special offer text test FAILED");
        }

        // 6- Close the page
        Thread.sleep(3000);
        driver.quit();
        
    }
}
