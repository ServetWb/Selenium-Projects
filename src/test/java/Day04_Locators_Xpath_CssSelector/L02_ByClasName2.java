package Day04_Locators_Xpath_CssSelector;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class L02_ByClasName2 {
    public static void main(String[] args) throws InterruptedException {

            // 1- Create a test class and perform necessary setup

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 2- Navigate to https://www.testotomasyonu.com/
            driver.get("https://www.testotomasyonu.com/");

            // 3- Type "phone" into the search box and trigger the search
            WebElement searchBox = driver.findElement(By.id("global-search"));
            searchBox.sendKeys("phone" + Keys.ENTER);

            // 4- Verify that there are 8 elements in the Category section
            List<WebElement> categoryElementsList = driver.findElements(By.className("panel-list"));

            int expectedCategoryCount = 8;
            int actualCategoryCount = categoryElementsList.size();

            if (expectedCategoryCount == actualCategoryCount) {
                System.out.println("Category count test PASSED");
            } else {
                System.out.println("Category count test FAILED");
            }

            // 5- Print the names of the categories

            System.out.println(categoryElementsList);
            // Since categories are WebElements, they cannot be printed directly

            // Let's use a for-each loop to iterate through each WebElement and print its text
            // If we wanted to collect the texts into a list of Strings, we would extract
            // the text from each WebElement and add it to a String list

            for (WebElement eachElement : categoryElementsList) {
                System.out.println(eachElement.getText());
            }

            // 6- Close the page
            Thread.sleep(3000);
            driver.quit();
        }
    }
