package com.files.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResult {

	WebDriver driver = null;
	WebDriverWait wait = null;
	
	
	@FindBy(css="div[class='eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover'] span[class='accommodation-name -eva-3-ellipsis']")
	WebElement firstResult;
	
	public PageResult (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	public void infoHotel() {
		wait.until(ExpectedConditions.visibilityOf(firstResult));
		wait.until(ExpectedConditions.elementToBeClickable(firstResult));
	}
	
	public FirstResult clickResult() {
		this.firstResult.click();
		return new FirstResult(this.driver);
	}
}
