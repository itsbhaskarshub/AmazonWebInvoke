package stepDefination;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webpages.AmazonLoginPage;

public class StepDefination_Amazon {

	public static WebDriver driver;
	public static String path = "..//test/Drivers/chromedriver.exe";
	public AmazonLoginPage lp;
	public static JavascriptExecutor js;
	
	@Given("^user enters \"([^\"]*)\"$")
	public void user_enters(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		lp = new AmazonLoginPage(driver);
		
		driver.get(arg1);

		System.out.println("Chrome Broswer Opened");
		System.out.println("====URL is Opened====");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\"$")
	public void and(String arg1, String arg2) throws Throwable {
		lp.LinkAccount();
		lp.Email(arg1);
		System.out.println("Email :" + arg1 );
		lp.continueButton();
		lp.password(arg2);
		System.out.println("password :"+ arg2);
		lp.signin();
	}

	@When("^search for \"([^\"]*)\"$")
	public void search_for(String arg1) throws Throwable {
		lp.SearchBox("EarPhones");
		System.out.println("User entered" + arg1 + "in Search Bar");
		Thread.sleep(2000);
		lp.SearchButton();
	}

	@Then("^select the product$")
	public void select_the_product() throws Throwable {
		List<WebElement> items = driver.findElements(By.xpath("//a[contains(@href,'picasso')]"));
		items.get(0).click();
		Thread.sleep(2000);
	}

	@Then("^Add to cart$")
	public void add_to_cart() throws Throwable {
		Thread.sleep(5000);
		String currentHandle= driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				//Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		lp.AddCart();
		
		System.out.println("Product is Added");
		Thread.sleep(5000);
		driver.quit();
	}
	}
	

