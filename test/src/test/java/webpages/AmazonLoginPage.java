package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

	public WebDriver ldriver;
	
	public AmazonLoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
		// Link Account of Signing button
		@FindBy(xpath = "//a[@id='nav-link-accountList']")
		@CacheLookup
		WebElement LinkAccount;
		
		// User Email ID
		@FindBy(id = "ap_email")
		@CacheLookup
		WebElement Email;
		
		// Email Submit Button
		@FindBy(id = "continue")
		@CacheLookup
		WebElement continueButton;
		
		//Password Submit Button
		@FindBy(id = "ap_password")
		@CacheLookup
		WebElement txtPwd;
		
		//Submit Button
		@FindBy(id = "signInSubmit")
		@CacheLookup
		WebElement signInSubmit;
		
		// WebElement for Search Box
		@FindBy(id = "twotabsearchtextbox")
		@CacheLookup
		WebElement SearchBox;
		
		// WebElement for Search Button
		@FindBy(id = "nav-search-submit-button")
		@CacheLookup
		WebElement SearchButton;
		
		// WebElement for Add to Cart
		@FindBy(id = "a-autoid-0-announce")
		@CacheLookup
		WebElement AddCart;
		

		public void LinkAccount(){
			LinkAccount.click();
		}
		
		public void Email(String email){
			Email.sendKeys(email);
		}
		public void continueButton(){
			continueButton.click();
		}
		public void password(String pwd){
			txtPwd.sendKeys(pwd);
		}
		
		public void signin(){
			signInSubmit.click();
		}
		
		public void SearchBox(String product){
			SearchBox.clear();
			SearchBox.sendKeys(product);
		}
		public void SearchButton(){
			SearchButton.click();
		}

		public void AddCart(){
			AddCart.click();
		}


		
	
}
