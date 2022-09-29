package com.files.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Driver {
	private enum browsers {
		CHROME, FIREFOX, EDGE
	}
	
	public static WebDriver LevantarBrowser(String browserName, String url) {
		WebDriver driver = null;
		switch(browsers.valueOf(browserName)) {
		case CHROME:
		{	
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			System.out.print("Abrir Chrome");
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver(opt);
			break;
		}
		case FIREFOX:
		{
			System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
			Reporter.log("Abrir Navegador Firefox");
			driver = new FirefoxDriver();
			break;
		}
		case EDGE:
		{
			System.setProperty("webdriver.edge.driver", "C:/Drivers/edgedriver.exe");
			Reporter.log("Abrir Navegador Edge");
			driver = new EdgeDriver();
			break;
		}
		default:
		{
			Reporter.log("No se encontro un navegador correcto, se abre Chrome por default");
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			Reporter.log("Abrir Navegador Chrome");
			driver = new ChromeDriver();
			break;
		}
	}
	
	driver.manage().window().maximize();
	
	driver.get(url);
	
	return driver;
 }
}
