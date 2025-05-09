package Day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L03_ProductSearchTest {
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the homepage of testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        // To interact with a web element,
        // 1 - The first thing we need to do is
        // inspect the HTML code of that element
        // and find a unique attribute to identify it

        // When we inspect the search box, we see that
        // it has an id = "global-search", which is a unique identifier

        // 2 - After finding the unique address of the HTML element,
        // we define it for the driver
        // and save it as an object to use in our code

        WebElement searchBox = driver.findElement(By.id("global-search"));

        // Type "phone" into the search box
        searchBox.sendKeys("phone");

        // Here, you could press Enter or click a search button if required
        // For example: searchBox.sendKeys(Keys.ENTER);

        // TODO: Verify that products are found in the search results
        // This step would require additional logic to locate and verify result elements

        // Wait for 5 seconds to observe results (not recommended in real tests)
        Thread.sleep(5000);

        // Close the browser
        driver.quit();

    }
}
