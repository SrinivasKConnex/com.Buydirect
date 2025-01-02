package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

public class CongratulationPage extends TestBase {

	By welcomePageHeader = By.id("headerConfirmation");

	By sucssesMessage = By.xpath("//p[@id='dynamic-congrats-message']/child::span");

	public WebElement waitUntilConfirmationPageDisplay() {
		return driver.findElement(welcomePageHeader);
	}

	public String getConfirmationPageHeaderText() {
		
		return getText_custom(driver.findElement(welcomePageHeader), "Confirmation header Message");

	}

	public String getConfirmationSucssesMessage() {
		return getText_custom(driver.findElement(sucssesMessage), "Confirmation Sucsses Message");

	}
}
