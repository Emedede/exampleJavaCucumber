package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import java.util.NoSuchElementException;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CheckoutPage;

public class BlankStepDefs{
    public WebDriver driver;
    
    public BlankStepDefs(){
    	driver = Hooks.driver;
    }
    
    @Given("^Open events TW page$")
    public void OpenEventsPage() throws Throwable {
        driver.get("https://ticketweb.com.tweb.twdev2.websys.tmcs/events?page=5");
    }

	@When("^Select event$")
    public void selectEventInList() throws Throwable {
    	final By LINK_EVENT = By.xpath("//a[contains(text(),'US Event 2 with multiple sections(2)')]");
    	try{
    		WebElement selectedEvent=driver.findElement(LINK_EVENT);
        if (selectedEvent!=null){
        	System.out.println("Founded !!!!!!!");
        	selectedEvent.click();
        	CheckoutPage checkoutPage = new CheckoutPage(driver);
        	if (checkoutPage.isOKCheckoutPage()){
        		//Log.info("Hiiiiiiiiiiiiiiiii ");
        		System.out.println("In Checkout OK!");
        	}else{
        		System.out.println("ERROR Checkout OK!");
        	}
        }
    	}catch(NoSuchElementException e){
        	System.out.println("Don't exist event!");
        }
    }

    @Then("^I validate title and URL$")
    public void i_print_title_and_URL() throws Throwable {
    	System.out.println("Title is: "+driver.getTitle());
    	System.out.println("URL   is: "+driver.getCurrentUrl());
      //assertEquals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.",driver.getTitle());
      //assertEquals("http://www.seleniumframework.com/",driver.getCurrentUrl());
    }
    
}