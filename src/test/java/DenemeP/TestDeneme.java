package DenemeP;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestDeneme {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com"); // Adrese gittik

        // Arama kutusunu bul ve oraya phone yaz

      WebElement SearchBox= driver.findElement(By.id("global-search"));
      SearchBox.sendKeys("phone"+ Keys.ENTER);

List<WebElement> category = driver.findElements(By.className("panel-list"));

int Categorint= 8;
int beklenenSonuc= category.size();
if (Categorint==beklenenSonuc){
    System.out.println("Test Passed");
}else System.out.println("Test Failed");

for(WebElement EachElement:category){
    System.out.println(EachElement.getText());


}

driver.quit();


     }




    }


    
