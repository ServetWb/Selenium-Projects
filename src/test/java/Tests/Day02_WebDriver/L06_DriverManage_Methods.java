package Tests.Day02_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L06_DriverManage_Methods {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();

            // Navigate to the Test Otomasyonu homepage
            driver.get("https://www.testotomasyonu.com");

            // Maximize the browser window
            driver.manage().window().maximize();

            Thread.sleep(3000);

        }
            }
