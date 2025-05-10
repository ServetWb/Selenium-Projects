package Day04_Locators_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class L01_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

// Navigate to the TestOtomasyonu homepage
        driver.get("https://www.testotomasyonu.com");

// Search for "phone"
        WebElement searchBox = driver.findElement(By.className("search-input"));

        searchBox.sendKeys("phone" + Keys.ENTER);
// searchBox.submit();

// Verify that products are found in the search results

        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        String unExpectedResultText = "0 Products Found";
        String actualResultText = searchResultElement.getText();

        if (actualResultText.equals(unExpectedResultText)) {
            System.out.println("Product search test FAILED");
        } else {
            System.out.println("Product search test PASSED");
        }

// Click on the first product found

// class attribute is GENERALLY used to group elements that share the same appearance
// in this case, the locator is not unique and will select all elements with that appearance
        List<WebElement> foundProductElementsList = driver.findElements(By.className("prod-img"));

        foundProductElementsList.get(0).click();

// When using By.className locator,
// ensure that there is no space in the value we use for locating
// if there is a space in the class attribute, By.className will not work properly

// On the opened product page,
// verify that the product description contains "phone", case-insensitively

// WebElement productDescriptionElement = driver.findElement(By.className("prod-detail"));

        WebElement productDescriptionElement =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedProductContent = "phone";
        String actualProductDescription = productDescriptionElement.getText().toLowerCase();
// converted to lowercase to make the comparison case-insensitive

        if (actualProductDescription.contains(expectedProductContent)) {
            System.out.println("Product name content test PASSED");
        } else {
            System.out.println("Product name content test FAILED");
        }

// Close the page

        Thread.sleep(3000);
        driver.quit();
    }
}
