package Tests.Day02_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L03_BasicPage_Tests {




            public static void main(String[] args) throws InterruptedException {

                WebDriver driver = new ChromeDriver();

                // 1. Navigate to the Test Otomasyonu page: https://www.testotomasyonu.com/
                driver.get("https://www.testotomasyonu.com/");

                // 2. Print the page title
                System.out.println(driver.getTitle());

                // 3. Verify that the page title contains “Test Otomasyonu”
                String expectedTitleContent = "Test Otomasyonu";
                String actualTitle = driver.getTitle();

                if (actualTitle.contains(expectedTitleContent)) {
                    System.out.println("Title test PASSED");
                } else {
                    System.out.println("Title test FAILED");
                }

                // 4. Print the page URL
                System.out.println(driver.getCurrentUrl());

                // 5. Verify that the page URL is "https://testotomasyonu.com/"
                String expectedUrl = "https://testotomasyonu.com/";
                String actualUrl = driver.getCurrentUrl();

                if (expectedUrl.equals(actualUrl)) {
                    System.out.println("URL test PASSED");
                } else {
                    System.out.println("URL test FAILED");
                }

        /*
            As testers, our responsibility is not to ensure that the test PASSES,
            but to verify whether the conditions defined in the requirements are met.

            If the result does not meet the requirements,
            the test should FAIL, and we must report it.

            A bug does not necessarily have to be a crash or a major failure;
            anything that does not align with the requirements should be reported as a bug.

            After we report it,
            whoever prepared the requirement should decide how to address the issue:
            Either the requirement is updated,
            or the actual result is modified to meet the requirement.
         */

                // 6. Print the window handle value
                System.out.println(driver.getWindowHandle());

                // 7. Verify that the word “otomasyon” appears in the page's HTML source code
                String expectedHtmlContent = "otomasyon";
                String actualPageSource = driver.getPageSource();

                if (actualPageSource.contains(expectedHtmlContent)) {
                    System.out.println("Page source test PASSED");
                } else {
                    System.out.println("Page source test FAILED");
                }

                // 8. Close the page
                Thread.sleep(3000);
                driver.quit();
    }
}
