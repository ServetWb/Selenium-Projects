package Day04_Locators_Xpath_CssSelector;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L05_XPath {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Navigate to https://testotomasyonu.com/addremove/
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Click the "Add Element" button
        driver.findElement(By.xpath("//button[@id='sub-btn']")).click();

        // 3- Verify that the "Remove" button is visible
        WebElement removeButton = driver.findElement(By.xpath("//button[@class='remove-btn']"));

        if (removeButton.isDisplayed()) {
            System.out.println("Remove button test PASSED");
        } else {
            System.out.println("Remove button test FAILED");
        }

        // 4- Click the "Remove" button
        removeButton.click();

        // 5- Verify that the "Add/Remove Elements" text is visible
        WebElement addRemoveTextElement = driver.findElement(By.xpath("//h2"));

        if (addRemoveTextElement.isDisplayed()) {
            System.out.println("Add/Remove text test PASSED");
        } else {
            System.out.println("Add/Remove text test FAILED");
        }

        // Close the browser
        driver.quit();

    }
}
