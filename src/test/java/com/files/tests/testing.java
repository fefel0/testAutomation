package com.files.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.files.driver.Driver;
import com.files.pages.FirstResult;
import com.files.pages.MainPage;
import com.files.pages.PageResult;


public class testing {
	
	WebDriver driver = null;
	MainPage homePage = null;
	
	@BeforeMethod(alwaysRun = true)
	public void iniciarTest(ITestContext context) {
		String navigatorSuite = context.getCurrentXmlTest().getParameter("nav");
		String navigator = navigatorSuite != null ? navigatorSuite : "CHROME";
		this.driver = Driver.LevantarBrowser(navigator, "https://www.despegar.com.ar");
		homePage = new MainPage(this.driver);
	}
	
	@DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	    	{"Mallorca"},
	        {"Copenhague"},
	        {"Bariloche"}};
	  }
	
  @Test(dataProvider="dp", description="validar que se visualice el boton Ver Habitacion", groups = {"grupo 1"})
  public void validarBoton(String text) throws Exception {
	  homePage.closeElements();
	  homePage.redirect();
	  Thread.sleep(2000);
	  homePage.viajeDestino(text);
	  Thread.sleep(1000);
	  homePage.fechaViaje();
	  homePage.selectDestino(text);
	  homePage.addPasajero("5 años");
	  PageResult resultHotel = homePage.clickBuscar();
	  resultHotel.infoHotel();
	  FirstResult resultValidator = resultHotel.clickResult();
	  resultValidator.closeModal();
	  Assert.assertTrue(resultValidator.buttonHotel(), "El titulo no esta visible");
  }
  
  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  driver.quit();
  }
}
