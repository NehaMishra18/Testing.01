package automationexcercise1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Home {

    WebDriver driver; // Shared across all methods

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openPage() {
        String url = "https://automationexercise.com/test_cases";
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url, "URL should match");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @Test(priority = 2)
    public void Clickhome () {
        driver.findElement(By.xpath("//a[@href='/']")).click(); // Make sure this XPath is correct
    }
    
    @Test(priority=3)
    public void Clickproduct() {
    	driver.findElement(By.xpath("//a[@href='/products']")).click();
    }
     @Test(priority=4)
     public void Clickcart() {
    	 driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
     }
     
     @Test(priority=5)
     public void Clicksignup() {
    	 driver.findElement(By.xpath("//a[@href='/login']")).click();
     }
     @Test(priority=6)
     public void ClickTestcase() {
    	 driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
     }
     @Test(priority=7)
     public void ClickApiTesting(){
    	 driver.findElement(By.xpath("//a[@href='/api_list']")).click();
     }
    	 @Test(priority = 8)
    	 public void videoTutorial() {
    	     driver.findElement(By.xpath("//a[contains(@href, 'youtube.com/c/AutomationExercise')]")).click();
    	 }

     @Test(priority=9)
     public void contactus() {
    	 driver.findElement(By.xpath("//a[contains(@href, 'contact_us')]")).click();
    	


     }
    
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


