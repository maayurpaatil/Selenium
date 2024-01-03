package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTxtBox;

	@FindBy(xpath = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "nav-search-submit-button")
	private WebElement menuBtn;

	@FindBy(xpath = "searchDropdownBox")
	private WebElement searchDropdown;

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchText() {
		//searchField.sendKeys("realme");
	}

	public void clickSearchButton() {
		//searchButton.click();
	}

	public void clickCartButton() {
		//cartBtn.click();
	}//

	public boolean isProfileNameVisible() {
		try {
			//WebElement element = expliciteWait(driver, profileName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
