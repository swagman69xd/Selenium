package com.pruebas.selenium;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Caso3Test {
	
	 private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void caso3() {
	    driver.get("http://localhost:8000/");
	    driver.manage().window().setSize(new Dimension(1057, 811));
	    driver.findElement(By.id("nombre")).click();
	    driver.findElement(By.id("nombre")).sendKeys("Usuario de Pruebas");
	    driver.findElement(By.id("apellidos")).sendKeys("Pruebecitas");
	    {
	      WebElement dropdown = driver.findElement(By.id("rol"));
	      dropdown.findElement(By.xpath("//option[. = 'Editor']")).click();
	    }
	    driver.findElement(By.cssSelector(".btn")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".btn"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.cssSelector(".btn-danger")).click();
	    vars.put("filas", driver.findElements(By.xpath("//*[@id=\'tabla\']/thead/tr")).size());
	    assertEquals(vars.get("filas").toString(), "1");
	  }

}
