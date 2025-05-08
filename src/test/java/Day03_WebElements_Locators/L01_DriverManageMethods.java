package Day03_WebElements_Locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L01_DriverManageMethods {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testotomasyonu.com");

        // With the driver.manage() methods,
        // we can control the size and position of the browser window opened by the driver

        System.out.println("Initial position: " + driver.manage().window().getPosition());
        // Initial position: (22, 60)
        System.out.println("Initial size: " + driver.manage().window().getSize());
        // Initial size: (1200, 1035)
        Thread.sleep(3000);

        driver.manage().window().setSize(new Dimension(500, 500));
        driver.manage().window().setPosition(new Point(100, 100));

        System.out.println("Position after adjustment: " + driver.manage().window().getPosition());
        // Position after adjustment: (100, 100)
        System.out.println("Size after adjustment: " + driver.manage().window().getSize());
        // Size after adjustment: (500, 500)

        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println("Position after maximize: " + driver.manage().window().getPosition());
        // Position after maximize: (0, 38)
        System.out.println("Size after maximize: " + driver.manage().window().getSize());
        // Size after maximize: (1728, 1079)

        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("Position in full screen: " + driver.manage().window().getPosition());
        // Position in full screen: (0, 37)
        System.out.println("Size in full screen: " + driver.manage().window().getSize());
        // Size in full screen: (1728, 1080)

        Thread.sleep(3000);
        driver.quit();

    }

}