package Day05_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class L03_RelativeLocatorUsage {

    public static void main(String[] args) throws InterruptedException {

         /*
            Using Relative Locator is not mandatory.

            IF we locate a web element but CANNOT INTERACT with it,
            THEN Relative Locator can be considered as an ALTERNATIVE method.
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1) Navigate to https://testotomasyonu.com/relativeLocators
        driver.get("https://testotomasyonu.com/relativeLocators");

        // 2) Locate the DSLR Camera using its own locator and try to click it
        driver.findElement(By.id("pic7_thumb")).click();
        // Since we are able to use its own locator, we don't need a relative locator here

        // 3) Verify that the opened product is DSLR Camera
        WebElement productTitleElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedProductName = "DSLR Camera";
        String actualProductName = productTitleElement.getText();

        if (expectedProductName.equals(actualProductName)) {
            System.out.println("Click using self-locator test PASSED");
        } else {
            System.out.println("Click using self-locator test FAILED");
        }

        Thread.sleep(2000);

        // Even though we don't need it, let's use a relative locator to see how it works
        driver.get("https://testotomasyonu.com/relativeLocators");

        // To use a Relative Locator, we need two things:

        // 1. A locator that identifies the target element (e.g., By.id("pic7_thumb"))
        // 2. A nearby WebElement to define the position relative to (e.g., "to the right of Apple headphone")
        WebElement appleHeadphone = driver.findElement(By.id("pic6_thumb"));

        // Locate DSLR Camera by describing it as the element to the right of the Apple headphone
        WebElement dslrCameraRightOfApple =
                driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appleHeadphone));

        dslrCameraRightOfApple.click();

        // 3) Verify again that the opened product is DSLR Camera

        // The previously found element is now stale due to page navigation
        // This leads to a StaleElementReferenceException if reused
        // Therefore, we must re-locate it
        productTitleElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        actualProductName = productTitleElement.getText();
        expectedProductName = "DSLR Camera";

        if (expectedProductName.equals(actualProductName)) {
            System.out.println("Right of Apple headphone test PASSED");
        } else {
            System.out.println("Right of Apple headphone test FAILED");
        }

        // Let's try one more: locate DSLR Camera by saying it is below Rockerz headphone
        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement rockertzHeadphone = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCameraBelowRockerz =
                driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).below(rockertzHeadphone));

        dslrCameraBelowRockerz.click();

        // 3) Verify again that the opened product is DSLR Camera
        productTitleElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        actualProductName = productTitleElement.getText();
        expectedProductName = "DSLR Camera";

        if (expectedProductName.equals(actualProductName)) {
            System.out.println("Below Rockerz headphone test PASSED");
        } else {
            System.out.println("Below Rockerz headphone test FAILED");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
