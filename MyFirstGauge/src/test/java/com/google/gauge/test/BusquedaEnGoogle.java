package com.google.gauge.test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.gauge.Step;

public class BusquedaEnGoogle {
	private WebDriver bot;
	private WebElement buscar;
	private WebElement confirmarBusqueda;
	
	@Step("El usuario debe estar en la pagina principal de google")
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		bot = new ChromeDriver();
		bot.get("https://www.google.com/");
	}
	
	@Step("El usuario ingresa <gauge framework> en la barra de busqueda y presiona enter")
	public void realizarBusqueda(String keyword) {
		buscar = bot.findElement(By.name("q"));
		buscar.sendKeys(keyword);
		buscar.sendKeys(Keys.ENTER);
	}
	
	@Step("El usuario debe ver el resultado de la busqueda")
	public void busquedaExitosa() {
		confirmarBusqueda = bot.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a"));
		assertTrue(confirmarBusqueda.isDisplayed());
		bot.quit();
	}
}
