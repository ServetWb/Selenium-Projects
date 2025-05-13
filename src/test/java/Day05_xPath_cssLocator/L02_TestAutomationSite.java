package Day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L02_TestAutomationSite {

    public static void main(String[] args) throws InterruptedException {

        // 1- Create a WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Navigate to https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 3- Maximize the browser window
        driver.manage().window().maximize();

        // 4- Refresh the page
        driver.navigate().refresh();

        // 5- Verify that the page title contains the phrase “Test Otomasyonu”
        String expectedTitleKeyword = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleKeyword)) {
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
        }

        // 6- Click on the Furniture link
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

        // Can the driver interact with an HTML WebElement that is not visible on the screen?
        // There is no definite answer.
        // On some web pages, it might work, while on others it might not.
        // So we should assume it will work and write the code accordingly.
        // If it fails despite being correct, it probably means the element must be visible.
        // In that case, we can scroll down using the code below:

        // Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // We'll cover this topic in detail later.
        // This command scrolls the page down once.

        // 7- In the price range filter, enter min value as 40 and max value as 200, then apply the filter
        WebElement minPriceBox = driver.findElement(By.xpath("//*[@*='form-control minPrice']"));
        WebElement maxPriceBox = driver.findElement(By.xpath("//*[@*='form-control maxPrice']"));

        // When we send numbers to the input boxes,
        // we observed that the default 0 gets appended after the number we enter.
        // So we should clear the box first
        minPriceBox.clear();
        maxPriceBox.clear();
        Thread.sleep(1000);

        minPriceBox.sendKeys("40");
        maxPriceBox.sendKeys("200");

        // Click the filter button
        driver.findElement(By.xpath("//*[@*='price-range-button']")).click();

        // 8- Verify that some products are found as a result of filtering
        //    Let's verify that the result text is not "0 Products Found"
        WebElement resultTextElement = driver.findElement(By.className("product-count-text"));
        String unexpectedResult = "0 Products Found";
        String actualResult = resultTextElement.getText();

        if (unexpectedResult.equals(actualResult)) {
            System.out.println("Filter test FAILED");
        } else {
            System.out.println("Filter test PASSED");
        }

        // 9- Click on the first product
        driver.findElement(By.xpath("(//img[@class='lazy'])[1]")).click();

        // 10- Verify that the product price is between 40 and 200
        WebElement productPriceElement = driver.findElement(By.xpath("//span[@id='priceproduct']"));

        // System.out.println(productPriceElement.getText()); // $50.00
        // Printed the price to see the format
        // It's a String with $ and . formatting
        // We need to convert it to a numerical value to compare

        // Remove the $ sign
        String productPriceStr = productPriceElement.getText();  // $50.00
        productPriceStr = productPriceStr.replace("$", "");      // "50.00"

        double productPrice = Double.parseDouble(productPriceStr);  // 50.00 as a number

        if (productPrice >= 40 && productPrice <= 200) {
            System.out.println("Product price test PASSED");
        } else {
            System.out.println("Product price test FAILED");
        }

        // 11- Close the browser
        Thread.sleep(2000);
        driver.quit();
    }
}
