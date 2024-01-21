package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageObjects {

	WebDriver ldriver;
	
	public HomepageObjects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTxtBox;

	@FindBy(xpath = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "nav-search-submit-button")
	private WebElement menuBtn;

	@FindBy(id = "nav-logo-sprites")
	private WebElement AmazonLogo;

	@FindBy(xpath = "searchDropdownBox")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "searchDropdownBox")
	private WebElement searchDropdsown;
	
	@FindBy(id = "nav-cart")
	private WebElement Cart;
	
	@FindBy(id = "nav-orders")
	private WebElement Orders;
	
	@FindBy(xpath = "searchDropdownBox")
	private WebElement sesssarchDropdown;
	
	@FindBy(xpath = "searchDropdownBox")
	private WebElement ssearchDropdown;
	
	@FindBy(xpath = "searchDropdownBox")
	private WebElement searchDropdoswn;
	
	

	public  void GetTitle() {
		String Title= ldriver.getTitle();
		System.out.println(Title);
	}

	

}
