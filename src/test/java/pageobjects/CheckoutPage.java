package pageobjects;

import helpers.Log;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class CheckoutPage extends BaseClass {
	private static final By BUTTON_CHECKOUT = By.id("edp_checkout_btn"); 
	private static final By BUTTON_ADD_TICKETS = By.xpath("(//div[@class='section-body']//a[@class='btn-circle illust'])[1]//*");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	
/*	@FindBy(how = How.ID, using = )
	public static WebElement buttonCheckout;*/

	public boolean isOKCheckoutPage() throws InterruptedException{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement buttonCheckout;
			buttonCheckout= wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CHECKOUT));
			
			//Adding Tickets:
			int ticketsAccount = 4; int i=0;
			while (i < ticketsAccount) {
                driver.findElement(BUTTON_ADD_TICKETS).click();
                //wait = new WebDriverWait(driver,2);
                i++;
            }
			WebElement ticketsUI= driver.findElement(By.xpath("(//a[@class='btn-circle illust'])[1]//..//span"));
			String textTicketsShowed = ticketsUI.getText();
			System.out.println(">>>>>> Quantity : "+textTicketsShowed+"  <<<<<<<<");
			buttonCheckout.click();
		return true;
		}catch(NoSuchElementException e){
        	System.out.println("Error loading Checkout Page!"+e.getMessage());
        	return false;
        }
	}
}
