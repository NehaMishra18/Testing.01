package automationexcercise1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyAllProductstest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		
	}
	 @Test(priority=1)
	 public void VerifyAllProductVisible() {
		 driver.findElement(By.xpath("//a[@href='/products']"));
		 String expectedTitle = "Automation Exercise - All Products";
		 Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title mismatch!");
		 List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));
	        Assert.assertTrue(products.size() > 0, "No products found!");

	        System.out.println("✅ Total Products Found: " + products.size());
	 }

	        
	        @Test(priority = 2, dependsOnMethods = "VerifyAllProductVisible")
	        
	        public void  VerifyAllProductDetails() {
	        	
	            // Click on first product 'View Product'
	            WebElement firstProduct = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
	            firstProduct. click();

	            // Verify product detail page is displayed
	            Assert.assertTrue(driver.getCurrentUrl().contains("/product_details"), "Not on product details page!");

	            // Verify product details: name, category, price, availability, condition, brand
	            WebElement productName = driver.findElement(By.xpath("//div[@class='product-information']/h2"));
	            WebElement category = driver.findElement(By.xpath("//p[contains(text(),'Category:')]"));
	            WebElement price = driver.findElement(By.xpath("//span/span"));
	            WebElement availability = driver.findElement(By.xpath("//p[contains(text(),'Availability:')]"));
	            WebElement condition = driver.findElement(By.xpath("//p[contains(text(),'Condition:')]"));
	            WebElement brand = driver.findElement(By.xpath("//p[contains(text(),'Brand:')]"));

	            // Assertions for visibility
	            Assert.assertTrue(productName.isDisplayed(), "Product name not displayed!");
	            Assert.assertTrue(category.isDisplayed(), "Category not displayed!");
	            Assert.assertTrue(price.isDisplayed(), "Price not displayed!");
	            Assert.assertTrue(availability.isDisplayed(), "Availability not displayed!");
	            Assert.assertTrue(condition.isDisplayed(), "Condition not displayed!");
	            Assert.assertTrue(brand.isDisplayed(), "Brand not displayed!");

	            System.out.println("✅ Product details verified successfully!");
	        }

	        @AfterClass
	        public void tearDown() {
	            driver.quit();
	        }
	    }
	 


