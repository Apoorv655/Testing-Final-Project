package stepdefinition;

import io.cucumber.java.Before;

import io.cucumber.java.en.*;
import pageObjects.BookingPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class BookingSteps extends Base {

    private BookingPage PG;

    @Before
    public void initPages() {
        
        PG = new BookingPage(Base.driver);
    }

    private static final Logger log = (Logger) LogManager.getLogger(BookingSteps.class);
    
    
    @Given("user is on the booking site home page")
    public void user_is_on_the_booking_site_home_page() throws Exception {
    	
    	 log.info("Opening Airbnb website");
        driver.get(this.getUrl()); 
        
        log.info("Searching Destinations");
        
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
           WebElement searchBox = PG.meathodTask();

           searchBox.click();
           Thread.sleep(7000);
           searchBox.sendKeys("Goa");
           
           log.info("Typed destination: Goa");
           Thread.sleep(3000);
           System.out.println("Home Page");
    }
    
    
    @When("user searches for {string}")
    public void user_searches_for(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Searched String");
    }

	@When("user selects check-in {string} and check-out {string}")
	public void user_selects_check_in_and_check_out(String string, String string2) throws Exception {
		    // 1) Open calendar using your new XPath
		
		    PG.openCalendar().click();
		    Thread.sleep(3000);
		    log.info("Selected Checkin dates");
		    driver.findElement(By.xpath("//*[@data-state--date-string='2026-03-18']")).click();
		    
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@data-state--date-string='2026-03-20']")).click();
		    Thread.sleep(3000);
		    
		    log.info("Selected Checkout dates");
		    
		    PG.clickSearchButton();
		    log.info("Clicked on Searched Button");
		    Thread.sleep(3000);
		    
		System.out.println("CheckIn - CheckOut");
	}
	@When("user applies price filter {string} to {string}")
	public void user_applies_price_filter_to(String string, String string2) {
	 
		System.out.println("Filter ");
	}
	@Then("results should display only items within {string} to {string}")
	public void results_should_display_only_items_within_to(String string, String string2) {
	
		System.out.println("Results ");
	}
}
