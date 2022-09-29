package com.files.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(xpath="//a[@class='lgpd-banner--button eva-3-btn -white -md']")
	WebElement cookies;
	
	@FindBy(css="i[class='shifu-icon-product shifu-3-icon-hotels']")
	WebElement alojamiento;
	
	@FindBy(xpath="//div[@class='sbox5-box-container']//div[@class='input-container']/input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement destino;
	
	@FindBy(xpath="(//div[@class='ac-container']//span[@class='item-text'])[1]")
	WebElement selectDestino;
	
	@FindBy(css="input[placeholder='Entrada']")
	WebElement calendario;
	
	@FindBy(css="div[class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']")
	WebElement calendarioModal;
	
	@FindBy(css="div[class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] a[class='calendar-arrow-right']")
	WebElement arrow;
	
	@FindBy(xpath="(//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber-number'])[3]")
	WebElement fechaIda;
	
	@FindBy(xpath="(//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber-number'])[21]")
	WebElement fechaVuelta;
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//em")
	WebElement apply;
	
	@FindBy(css="div[class='ac-wrapper -desktop -show sbox-ab-ls']")
	WebElement modalLugares;
	
	@FindBy(css="div[class='ac-container'] li:nth-of-type(1)")
	WebElement modalDestino;
	
	@FindBy(css="div[class='sbox5-3-double-input'] input[class='sbox5-3-first-input']")
	WebElement habitaciones;
	
	@FindBy(css="div[class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']")
	WebElement modalHabitaciones;
	
	@FindBy(xpath="(//div[@class='distribution__container distribution__type__rooms']//button[@class='steppers-icon-right stepper__icon'])[1]")
	WebElement addMayor;
	
	@FindBy(xpath="(//div[@class='distribution__container distribution__type__rooms']//div[@class='sbox5-3-steppers -md']//button[@class='steppers-icon-right stepper__icon'])[2]")
	WebElement addMenor;
	
	@FindBy(css="div[class='distribution__container distribution__type__rooms'] select[class='select']")
	WebElement selectEdad;
	
	@FindBy(css="div[class='distribution__container distribution__type__rooms'] a[class='sbox5-3-btn -md -primary']")
	WebElement applyHab;
	
	@FindBy(css="button[class='sbox5-box-button-ovr sbox5-3-btn sbox5-button -secondary -icon -lg'] em")
	WebElement result;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(this.driver, this);
	}
	
	public void closeElements() {
		wait.until(ExpectedConditions.elementToBeClickable(cookies));
		this.cookies.click();
	}
	
	public void redirect() {
		wait.until(ExpectedConditions.elementToBeClickable(alojamiento));
		this.alojamiento.click();
	}
	
	public void viajeDestino(String text) {
		wait.until(ExpectedConditions.visibilityOf(destino));
		wait.until(ExpectedConditions.elementToBeClickable(destino));
		this.destino.click();
		this.destino.sendKeys(text);
	}
	
	public void fechaViaje() {
		wait.until(ExpectedConditions.elementToBeClickable(calendario));
		this.calendario.click();
		wait.until(ExpectedConditions.visibilityOf(calendarioModal));
		wait.until(ExpectedConditions.visibilityOf(arrow));
		wait.until(ExpectedConditions.elementToBeClickable(arrow));
		this.arrow.click();
		wait.until(ExpectedConditions.visibilityOf(fechaIda));
		wait.until(ExpectedConditions.elementToBeClickable(fechaIda));
		this.fechaIda.click();
		wait.until(ExpectedConditions.visibilityOf(fechaVuelta));
		wait.until(ExpectedConditions.elementToBeClickable(fechaVuelta));
		this.fechaVuelta.click();
		wait.until(ExpectedConditions.elementToBeClickable(apply));
		this.apply.click();
	}
	
	public void selectDestino(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(destino));
		this.destino.clear();
		this.destino.click();
		wait.until(ExpectedConditions.visibilityOf(destino));
		this.destino.sendKeys(text);
		wait.until(ExpectedConditions.visibilityOf(modalLugares));
		wait.until(ExpectedConditions.elementToBeClickable(modalDestino));
		this.modalDestino.click();
	}
	
	public void addPasajero(String text) {
		wait.until(ExpectedConditions.visibilityOf(habitaciones));
		wait.until(ExpectedConditions.elementToBeClickable(habitaciones));
		this.habitaciones.click();
		wait.until(ExpectedConditions.visibilityOf(modalHabitaciones));
		wait.until(ExpectedConditions.elementToBeClickable(modalHabitaciones));
		wait.until(ExpectedConditions.elementToBeClickable(addMayor));
		this.addMayor.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMenor));
		this.addMenor.click();
		wait.until(ExpectedConditions.visibilityOf(selectEdad));
		Select edad = new Select(selectEdad);
		edad.selectByVisibleText(text);
		wait.until(ExpectedConditions.elementToBeClickable(applyHab));
		this.applyHab.click();
	}
	
	public PageResult clickBuscar() {
		this.result.click();
		return new PageResult(this.driver);
	}
	
}
