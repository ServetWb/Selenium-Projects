package Day03_WebElements_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L02_TheTreeHorsemen {

    public static void main(String[] args) {

        // When we create a class for automation,
        // the first thing we need to do is create a WebDriver object
        // and make the necessary configurations.
        // We will write 3 lines of code for this process,
        // and I call these the "Three Horsemen of the Apocalypse".

        // WebDriverManager.chromedriver().setup();
        // If the company provides a custom WebDriver, that would be the 4th horseman.

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // implicitlyWait tolerates delays caused by our computer, internet,
        // or the server of the connected website.
        // The 10 seconds we wrote is the maximum duration it will tolerate.
        // The main focus is not waiting but performing the operation.
        // If the operation finishes within the given time range,
        // it proceeds without waiting further.
        // If the operation does not complete within the given time,
        // it throws an exception and stops execution.

        // Thread.sleep() also causes waiting, but it is not practical.
        // It pauses the code for the exact duration given.
        // Even if the operation has been completed, it continues to wait.
        // That's why it's impractical in batch runs.
    }
}
