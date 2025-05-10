package Day02_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L01_First_Automation {

    public static void main(String[] args) throws InterruptedException {

  /*
    To perform test automation with Selenium,
    most of the actions we can do with our hands, eyes, keyboard, and mouse
    can be done for us by the Selenium WebDriver object.

    Soooo...
    When we want to create a test automation script,
    the FIRST thing we need to do
    is to OBTAIN a WebDriver object.
 */

// WebDriver driver = new WebDriver();
// 'WebDriver' is abstract; cannot be instantiated
// WebDriver is an interface and
// you cannot create an object directly from interfaces.
// To create an object, you must use a constructor of one of its child classes.

        WebDriver driver = new ChromeDriver();

// driver.get("URL") takes us to the specified URL
        driver.get("https://www.testotomasyonu.com");

/*
    Notes:
    1- Not every red message seen in the console indicates an error, as it does in Java.
       If the console shows
       "Process finished with exit code 0"
       it means the code ran and finished without any problems.

    2- If we create a WebDriver but
       do not use the object at all,
       Selenium will open an empty browser
       and wait for your commands.

    3- Selenium does not use the actual browser installed on your computer.
       It uses a copy of the browser that Selenium has created.
       At the top of the browser opened by the driver object,
       you will see a message: "Chrome is being controlled by automated test software".

    4- When writing a URL, even if we omit "www", the driver still navigates to the correct address.
       BUUUUT if we omit "https", the code will not work.

    5- When the driver object has finished its job, it should be closed.
       To close it, we can use either driver.close() or driver.quit().

       The difference between the two:
       driver.close(): If multiple windows were opened during the test,
                       it only closes the most recently used one; others stay open.
                       (If only one window was opened, there is no issue.)

       driver.quit(): If multiple windows were opened during the test,
                      it closes all windows that it opened.

    6- It is preferable for tests run by automation to finish as quickly as possible.
       HOOOWEVER, if you want to see your test steps
       or demonstrate them during a presentation,
       you can delay the execution using Thread.sleep().

       Thread.sleep() causes a compile time exception warning.
       You must either use `throws` or handle the exception with try-catch.

    7- When initially working on the test or during a presentation,
       it is fine to use Thread.sleep().
       BUT once you're done, it's better to remove them.
       If not removed, they may cause serious time loss in batch test executions.
 */

        Thread.sleep(3000); // 3000 milliseconds = 3 seconds

// driver.close();
        driver.quit();


    }

}
