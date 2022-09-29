package com.files.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstResult {

	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css="i[class='login-incentive--close shifu-3-icon-close -eva-3-mr-md']")
	WebElement facebook;
	
	@FindBy(css="div[class='eva-3-container'] div[class='detail-product-pricebox -eva-3-shadow-1 -eva-3-bc-white']")
	WebElement buttonContainer;
	
	@FindBy(css="button[class='eva-3-btn -md -primary -eva-3-fwidth']")
	WebElement button;
	
	public FirstResult (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	public void closeModal() {
		wait.until(ExpectedConditions.visibilityOf(facebook));
		wait.until(ExpectedConditions.elementToBeClickable(facebook));
		this.facebook.click();
	}
	
	public void buttonCnt() {
		wait.until(ExpectedConditions.visibilityOf(buttonContainer));
		wait.until(ExpectedConditions.visibilityOf(buttonContainer));
	}
	
	public boolean buttonHotel() {
		wait.until(ExpectedConditions.visibilityOf(button));
		wait.until(ExpectedConditions.elementToBeClickable(button));
		return this.button.isDisplayed();
	}
	
}
