package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Day1 {
		 WebDriver driver;
		 boolean status;

		@Given("Open Browser")
		public void open_browser() {
		    // Write code here that turns the phrase above into concrete actions
		    driver =new ChromeDriver();
		}

		@When("Enter url")
		public void enter_url() throws InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
		    driver.get("https:/www.google.com");
		    driver.manage().window().maximize();
		    Thread.sleep(3000);
		}

		@Then("Verify the home page")
		public void verify_the_home_page() {
		    // Write code here that turns the phrase above into concrete actions
		    status=driver.getPageSource().contains("Google offered in");
		    if(status==true)
		    {
		    	System.out.println("Test case pass");
		    }else {
		    	System.out.println("Test case Fail");
		    }
		}



}
