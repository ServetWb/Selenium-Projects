package Tests.Day02_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L02_Driver_GetMethods {

    public class C02_driverGetMethods {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.testotomasyonu.com");

            System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

            System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

            System.out.println(driver.getWindowHandle());
            // 72B4B1422C9EAD12A694E914149B9C99

            System.out.println(driver.getWindowHandles());
            // [72B4B1422C9EAD12A694E914149B9C99]

        /*
            Selenium does not use the actual browsers installed on our computer,
            it uses COPY BROWSERS that it creates itself.

            For each browser it creates,
            Selenium assigns a unique handle value.

            If only one window is opened during the test,
            both methods will return the same value.
            The difference is:
            getWindowHandle() returns the driver's handle as a single String,
            while getWindowHandles() returns it as a Set.

            If more than one window is opened during the test,
            the two methods return different results.
            getWindowHandle() returns the handle of the most recently opened browser window,
            whereas getWindowHandles() returns a Set containing the handles of
            all browser windows opened by the driver.

            The window handle value is used
            to switch between different browser windows during the test.
         */

            System.out.println(driver.getPageSource());
            // Returns the entire HTML source code of the page
            // It can be used for tests such as checking whether a specific keyword (e.g., "automation") exists in the page source

            Thread.sleep(3000);
            driver.quit();

        }
    }
}