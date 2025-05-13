package Day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L01_Xpath_TextUsage {

            public static void main(String[] args) throws InterruptedException {

                // Launch a Chrome browser instance
                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();

                // 1- Navigate to https://testotomasyonu.com/addremove/
                driver.get("https://testotomasyonu.com/addremove/");

                // 2- Click on the "Add Element" button
                //   Classic way to locate using text:
                // driver.findElement(By.xpath("//button[text()='Add']")).click();

                //   If the tag is not important, and we just care about the text being 'Add':
                // driver.findElement(By.xpath("//*[text()='Add']")).click();

                //   We can even use '.' instead of text()
                driver.findElement(By.xpath("//*[.='Add']")).click();

                // 3- Verify that the "Remove" button is visible
                WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
                if (removeButton.isDisplayed()) {
                    System.out.println("Remove button test PASSED");
                } else {
                    System.out.println("Remove button test FAILED");
                }

                Thread.sleep(1000);

                // 4- Click on the "Remove" button
                removeButton.click();

                // 5- Verify that the "Add/Remove Elements" text is visible
                WebElement addRemoveTextElement = driver.findElement(By.xpath("//h2[.='Add/Remove Elements']"));

                if (addRemoveTextElement.isDisplayed()) {
                    System.out.println("Add/Remove text test PASSED");
                } else {
                    System.out.println("Add/Remove text test FAILED");
                }

                Thread.sleep(1000);
                driver.quit(); // Close the browser
    }
}
