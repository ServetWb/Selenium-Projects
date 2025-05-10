package Day02_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L05_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Go to the Test Otomasyonu homepage
        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(1000);

        // Go to the Wise Quarter homepage
        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(1000);

        // Go back to the Test Otomasyonu homepage
        driver.navigate().back();
        Thread.sleep(1000);

        // Navigate forward to the Wise Quarter homepage again
        driver.navigate().forward();
        Thread.sleep(1000);

        driver.quit();
    }
}
